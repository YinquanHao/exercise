pipeline {
  agent any
  stages {
    stage('build') {
      agent any
      steps {
        sh 'echo /"enter build stage/" '
      }
    }
    stage('Restore Database') {
      steps {
        script{
          try{
            timeout(time: 3, unit: 'MINUTES'){
              env.SHOULD_RESTORE_DB = input {
                message 'Restore the database?'
                ok "Restore"
                parameters {
                choice(name: 'SHOULD_RESTORE_DB', choices: 'Restore\nSkip', description: 'Should we restore the database from the appropriate production environment?')
                }
              }
            }
            echo 'In the try clause ${env.SHOULD_RESTORE_DB}'
          } catch (exc) {
            echo "enter catch"
            env.SHOULD_RESTORE_DB = "Skip"
          }
        }
        echo "enter ! ${env.SHOULD_RESTORE_DB}"
      }
    }
    stage('Database Restore') {
      when{
        environment name: 'SHOULD_RESTORE_DB', value: 'Restore'
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