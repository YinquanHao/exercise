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
        			env.DO_RESTORE = input(message: 'Proceed', id: '8023', ok: 'True',parameters: [choice(name: 'RELEASE_SCOPE', choices: 'Proceed DB Restore\nDont Proceed DB Restore', description: 'Proceed DB Restore?')])
        		}
        	} catch (exc) {
        		echo "enter catch"
        		env.DO_RESTORE = "Dont Proceed DB Restore"
        	}
        }
        echo "enter ! ${env.DO_RESTORE}"
      }
    }
    stage('DB-Restore') {
    	when{
    		expression { env.DO_RESTORE == 'Proceed DB Restore' }
    	}
    	steps {
    		echo "DO_RESTOREING"
    	}
    }
    Stage('Rest-Job'){
    	steps {
    		echo "finish!"
    	}
    }
  }
}
