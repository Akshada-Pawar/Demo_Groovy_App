import unittest
#import xmlrunner
import app

class TestHello(unittest.TestCase):
    def setUp(self):
        app.app.testing = True
        self.app = app.app.test_client()
        
    def test_hello(self):
        rv = self.app.get('/')
        
        self.assertEqual(rv.status, '200 OK')

        self.assertEqual(rv.data, b'Hello World!\n')

    def test_hello_hello(self):
        rv = self.app.get('/hello/')
        
        self.assertEqual(rv.status, '200 OK')
        
        self.assertEqual(rv.data, b'Hello World!\n')
    
    
if __name__ =='__main__':
   # runner = xmlrunner.XMLTestRunner(output='test-reports')
    #unittest.main(testRunner=runner)
    unittest.main()