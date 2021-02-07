#!/usr/bin/env python
node{
        
        stage('Get Latest Code'){
            deleteDir()
            checkout scm
        }
        stage('build'){
                echo "Building..."
                //sh 'python -m py_compile src/app.py'
                stash(name: 'compiled-results', includes: 'src/*.py*')
                echo "Build Successful"
        }
        stage('test'){
            echo "Testing..."
            def testError = null
            try{
                sh ''' py.test sources/test.py '''
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
            echo "Test Successful..."
        }
}