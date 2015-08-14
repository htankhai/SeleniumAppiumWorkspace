package Groovy
//Java Application. Groovy script. Groovy Console

class HelloJavaApp {
	
		def sayHello(name) {
			println("Hello $name!")
		}
		
		static main(args) {
			
			HelloJavaApp hello = new HelloJavaApp()
			def name = 'world March'
			hello.sayHello(name)
			
			//
			println()
			println( "Hello world")
		}
	}
	
