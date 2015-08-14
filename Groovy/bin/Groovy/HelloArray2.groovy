package Groovy
//array
		
	def sayHello(name) {
		println("Hello $name")
	}
	
		
	//adding, removing entries
	def names = ["Htan", "Kaitlyn", "Keira"]
		names += 'Jim'
		names -= 'Keira'
	
	names.sort()
	
	for (name in names) {
		sayHello(name)
	}

