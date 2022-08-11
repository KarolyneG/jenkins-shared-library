def call(Map config=[:], Closure body) {
      
    node {
        git url: "https://github.com/werne2j/sample-nodejs"

        stage("Install") {
            sh "npm install"
        }

        stage("Test") {
            //sh "npm test"
            //mvn clean test
            sh "mvn verify -U"
            sh "mvn --version"
            sh 'mvn clean test'
  
            
        }

        stage("Deploy") {
            if (config.deploy) {
                sh "npm publish"
            }
        }

        body()
    }
}
