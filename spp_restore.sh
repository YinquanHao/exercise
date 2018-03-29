#!/bin/bash


DB_DATABASE=${1}
DB_INSTANCE_IDENTIFIER=${2}
HOST=${3}
SQLHOST="${DB_INSTANCE_IDENTIFIER}"
MNT="/mnt/dsk1/"
DUMP="spp_restore"


if [[ -z "${DB_DATABASE}" ]]; then
    echo 'ERROR: No database name specified'
    exit 1
fi

if [[ -z "${DB_INSTANCE_IDENTIFIER}" ]]; then
    echo 'ERROR: No database instance identifier specified'
    exit 1
fi

if [[ -z "${HOST}" ]]; then
    echo 'ERROR: No host name specified'
    exit 1
fi


#getting HOST down
echo "getting ${HOST} down"
ssh -p 2011 ${HOST} "sudo -u www-data php /var/www/${HOST}/artisan down"
if [[ ${?} -ne 0 ]]; then
    echo "ERROR: Not able to get ${HOST} down"
    exit 1
fi

#stop the queue listeners
echo "stopping the queue listeners"
ssh -p 2011 ${HOST} "sudo supervisorctl stop queue-${HOST}:*"
if [[ ${?} -ne 0 ]]; then
    echo "ERROR: Not able to stop ${HOST} queue listeners"
    exit 1
fi

if [[ -e "${MNT}${DUMP}.sql" ]]; then
    echo "Dropping Database ${DB_DATABASE}."
    mysql -u master -pcorsomaster -h ${SQLHOST} -P 10009 <<< "DROP DATABASE IF EXISTS ${DB_DATABASE}"
    echo "done."
    echo "Creating Database ${DB_DATABASE}."
    mysql -u master -pcorsomaster -h ${SQLHOST} -P 10009 <<< "CREATE DATABASE ${DB_DATABASE}"
    echo "done."
else 
    echo "File ${DUMP}.sql not available , getting ${HOST} up"
    ssh -p 2011 ${HOST} "sudo -u www-data php /var/www/${HOST}/artisan up"
    if [[ ${?} -ne 0 ]]; then
    echo "ERROR: Not able to get ${HOST} up"
    exit 1
    fi
    exit 1
fi

echo "Importing spp_live to spp_staging.Please wait...."

mysql -u master -pcorsomaster --max_allowed_packet=512M -h ${SQLHOST} -P 10009 ${DB_DATABASE} < ${MNT}${DUMP}.sql &
PID2=$!
wait ${PID2}
if [[ ${?} -ne 0 ]]; then
   echo "Error: Unable to import spp_live to ${HOST}"
   exit 1
fi

#getting HOST up
echo "Import completed , getting ${HOST} up" 
ssh -p 2011 ${HOST} "sudo -u www-data php /var/www/${HOST}/artisan up"
if [[ ${?} -ne 0 ]]; then
   echo "ERROR: Not able to get ${HOST} up"
   exit 1
fi

#start the queue listeners
echo "starting the queue listeners"
ssh -p 2011 ${HOST} "sudo supervisorctl start queue-${HOST}:*"
if [[ ${?} -ne 0 ]]; then
    echo "ERROR: Not able to start ${HOST} queue listeners"
    exit 1
fi
