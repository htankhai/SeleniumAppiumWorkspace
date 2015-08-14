package coreJava;
/* *use two techniques- % and /  to extract the digits from the given number one by one 
 */
public class BinaryNumber {
	public static void main(String[] args){
		isBinary(128956);
		isBinary((101110));
		isBinary((42578));
		isBinary((10110101));

	}

	static void isBinary(int number) {
		boolean isBinary = true;
		int copyOfNumber = number;

		while (copyOfNumber != 0) {
			//Gives last digit of the number
			int temp = copyOfNumber%10;   
			// if check extracted digit is greater than 1, return false  
			if(temp > 1) {
				isBinary = false;
				break;
			}
			else {
				//Removes last digit from the number
				copyOfNumber = copyOfNumber/10;    
			}
		}

		if (isBinary) {
			System.out.println(number+" is a binary number");
		}
		else {
			System.out.println(number+" is not a binary number");
		}
	}
}
