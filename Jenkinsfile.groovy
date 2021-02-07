#!groovy
node{
        
        stage('Get Latest Code'){
            deleteDir()
            checkout scm
        }
        stage('build'){
                bat '''source bin/activate
                pip install -r requirements.txt
                deactivate
                '''
                echo "Build Successful"
        }
        stage('test'){
            def testError = null
            try{
                bat ''' python test.py '''
            }
            catch(err){
                testError = err
                currentBuild.result = 'FAILURE'
            }
            finally{
                junit 'test-reports/*.xml'
                if(testError){
                    throw testError
                }

            }
        stage('Create Artifact'){
            //code = load 'example.Groovy'
        }
}
node{
    stage('Deploy Artifact'){
        
    }
}
node{
    stage('Run End-to-End Tests'){

    }
}