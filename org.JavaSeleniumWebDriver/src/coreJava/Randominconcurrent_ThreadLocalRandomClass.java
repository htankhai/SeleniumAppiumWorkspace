package coreJava;
import java.util.concurrent.ThreadLocalRandom;

//generate random integers, doubles and booleans using ThreadLocalRandom class.
public class Randominconcurrent_ThreadLocalRandomClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Generating random integers using ThreadLocalRandom class

		for(int i = 0; i < 5; i++) {
			System.out.println("Random Integers : "+ThreadLocalRandom.current().nextInt());
		}

		

		//Generating random doubles using ThreadLocalRandom class
		for(int i = 0; i < 5; i++) 	{
			System.out.println("Random Doubles : "+ThreadLocalRandom.current().nextDouble());
		}

		

		//Generating random booleans using ThreadLocalRandom class
		for(int i = 0; i < 5; i++) {
			System.out.println("Random booleans : "+ThreadLocalRandom.current().nextBoolean());
		}
	}

}
