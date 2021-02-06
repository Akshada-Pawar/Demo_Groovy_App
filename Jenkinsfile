def code
node(){
        
        stage('checkout'){
            deleteDir()
            checkout scm
        }
        stage('build'){
                echo "Build Successful"
                //code = build 'pip install -r requirements.txt'
        }
        stage('test'){
            
                code = test 'python test.py'
                }
        stage('load'){
            code = load 'example.Groovy'
        }
        stage('execute'){
            code.example1()
        }
        stage('publish'){
                
                    junit 'test-reports/*.xml'
                    
                }
}
code.example2()