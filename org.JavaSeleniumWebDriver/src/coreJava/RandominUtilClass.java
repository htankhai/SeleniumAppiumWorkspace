package coreJava;
// java.util.Random class can generate random integers, doubles, floats, longs and booleans.
//Integers generated are in the range of -231 and 231-1. Generated doubles are in the range from 0.0 to 1.0.
import java.util.Random;

public class RandominUtilClass {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();

		//Generating random integers using Random class

		for(int i = 0; i < 10; i++) {
			System.out.println("Random Integers : "+random.nextInt());
		}

		
		//Generating random doubles using Random class

		for(int i = 0; i < 10; i++) {
			System.out.println("Random Doubles : "+random.nextDouble());
		}

		

		//Generating random booleans using Random class

		for(int i = 0; i < 10; i++) {
			System.out.println("Random booleans : "+random.nextBoolean());
		}
	}

}
