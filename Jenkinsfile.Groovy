node(){
        stage('checkout'){
            deleteDir()
            checkout scm
        }
        stage('build'){
                echo "Build Successful"
                //sh 'pip install -r requirements.txt'
        }
        stage('test'){
            
                sh 'python test.py'
                }
        
        stage('publish'){
                
                    junit 'test-reports/*.xml'
                    
                }
}