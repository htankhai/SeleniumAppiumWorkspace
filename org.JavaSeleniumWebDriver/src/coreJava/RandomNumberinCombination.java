package coreJava;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

//generates random integers in the range from 0 to 50 using all three methods – Random class, Math.random() and ThreadLocalRandom class.
public class RandomNumberinCombination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Generating random integers between 0 and 50 using Random class
		 
        System.out.println("Random integers between 0 and 50 using Random class :");
 
        Random random = new Random();
 
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(100));
        }
 
        //Generating random integers between 0 and 50 range using Math.random()
 
        System.out.println("Random integers between 0 and 50 using Math.random() :");
 
        for (int i = 0; i < 10; i++) {
            System.out.println((int)(Math.random() * 100));
        }
 
        //Generating random integers between 0 and 50 using ThreadLoclaRandom
 
        System.out.println("Random integers between 0 and 50 using ThreadLocalRandom :");
 
        for (int i = 0; i < 10; i++) {
            System.out.println(ThreadLocalRandom.current().nextInt(0, 100));
        }
        
	}

}
