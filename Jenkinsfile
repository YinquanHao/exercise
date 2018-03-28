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
        input(message: 'Proceed', id: '8023', ok: 'True',parameters: [choice(name: 'RELEASE_SCOPE', choices: 'patch\nminor\nmajor', description: 'What is the release scope?')])
      }
    }
  }
}
