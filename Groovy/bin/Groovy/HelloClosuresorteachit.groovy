package Groovy
//closures. each()
// closures similiar to method pointers

def sayHello(name) {
	println("Hello $name")
}

def names = ["Htan", "Kaitlyn", "Keira"]

	names += 'Jim'
	names -= 'Kaitlyn'

names.sort()

//defines a single parameter that the closure takes
//Using the Closure with the each Method
def clos = {name -> sayHello(name)}
names.each(clos)


names.each {name -> sayHello(name)}

//
def names2 = ["respond 100", "respond 101", "respond 102"]
names2 += 'respond 104'
names2 -= 'respond 100'

names2.each {sayHello(it)}

//
def clos2 = {name -> sayHello(name)}
clos2.call('respond1000')