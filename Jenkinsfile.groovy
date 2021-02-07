#!/usr/bin/env groovy
node{
        
        stage('Get Latest Code'){
            deleteDir()
            checkout scm
        }
        stage('build'){
                sh '''source bin/activate
                pip install -r requirements.txt
                deactivate
                '''
                echo "Build Successful"
        }
        stage('test'){
            def testError = null
            try{
                sh ''' python test.py '''
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
        }
}