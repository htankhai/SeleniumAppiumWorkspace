package org.groovy
// Collection.groovy
//declare Collection Data Types in Groovy

// Define a Collection called numbers holding 1, 2 and 3
def numbers = [10, 2, 33]

//Iterate over the collection and print it.
for (number in numbers){
   println number
}

// Add two more entries to the Collection.
numbers.add(14)
numbers.add(57)

// Iterate again over the Collection to see the new values.
for (number in numbers){
   println number
}