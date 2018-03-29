pipeline {
  agent any
  stages {
    stage('build') {
      agent any
      steps {
        sh 'echo /"enter build stage/" '
      }
    }
    stage('promote') {
      steps {
        script{
        	try{
        		timeout(time: 3, unit: 'MINUTES'){
        			env.DO_RESTORE = input(message: 'Proceed to DB-Restore?', id: '8023', ok: 'True')
        		}
        		env.DO_RESTORE = "TRUE"
        	} catch (exc) {
        		echo "enter catch"
        		env.DO_RESTORE = "FALSE"
        	}
        }
        echo "enter ! ${env.DO_RESTORE}"
      }
    }
    stage('DB-Restore') {
    	when{
    		expression { env.DO_RESTORE == 'TRUE' }
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
