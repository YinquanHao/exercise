pipeline {
  agent any
  stages {
    stage('build') {
      agent any
      steps {
        sh 'echo /"enter build stage/" '
      }
    }

    stage('DB-Restore') {
      #timeout(time:3, unit: 'MINUTES'){
        input {
          message "Restore the database?"
          ok "Restore"
          parameters {
              booleanParam(name: 'SHOULD_RESTORE_DB', defaultValue: false, description: 'Should we restore the database from the appropriate production environment?')
          }
        }
      #}
      when {
        expression {
          params.SHOULD_RESTORE_DB == true
        }
      }
      steps {
        echo "DO_RESTOREING"
      }
    }
    stage('Rest-Job'){
    	steps {
    		echo "finish!"
    	}
    }
  }
}