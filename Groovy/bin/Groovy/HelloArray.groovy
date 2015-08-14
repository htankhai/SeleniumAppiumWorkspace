package Groovy
//array

def sayHello(name) {
	println("Hello $name")
}

String[] names = ["Htan", "Kaitlyn", "Keira"]

for (String name : names) {
	sayHello(name)
}

