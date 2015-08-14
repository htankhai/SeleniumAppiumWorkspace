package org.closure

//Closure100.groovy
/*def refToClosure = {
	ParameterList ->
	Set of Statements
}

refToClosure.call( argumentList )*/



//closure with no argument
def printClosure = {
	println "Hello"
}

printClosure()
printClosure.call()



//closure two parameters
def argPrintClosure = {
  String name, int age ->
  println "Printing $name and $age"
}

argPrintClosure("Jennie", 10)
argPrintClosure.call("Andrew", 20)



//it keyword
def implicitArgClosure = {
	println it
}


implicitArgClosure.call("hello")
implicitArgClosure.call()



//functional definition
class ClosureTest{
	public void printClosure(String value){
		println value
	}
}

def obj = new ClosureTest()
Closure closureObj = obj.&printClosure
closureObj.call("Test")



//methods in the Groovy Collection API accept a Closure as their argument
def oddClosure = {element ->
	Number number = Integer.parseInt(element)
	if (number%2 != 0){
		print number + " "
	}
}

def evenClosure = {element ->
	Number number = Integer.parseInt(element)
	if (number%2 == 0){
		print number + " "
	}
}

def numbers = ["1", "2", "3", "4", "5", "6", "7", "8"]
print ("Odd Numbers-->")
numbers.each(oddClosure)
println ""
print ("Even Numbers-->")
numbers.each(evenClosure)
println ""



