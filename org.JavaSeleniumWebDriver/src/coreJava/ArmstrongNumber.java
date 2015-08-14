package coreJava;

public class ArmstrongNumber {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		isArmstrongNumber(153);
		/*isArmstrongNumber(371);
		isArmstrongNumber(9474);
		isArmstrongNumber(54748);
		isArmstrongNumber(407);
		isArmstrongNumber(1674);*/
	}

	static void isArmstrongNumber(int number) {
        int copyOfNumber = number;
         int noOfDigits = String.valueOf(number).length();
 
        int sum = 0;
 
        while (copyOfNumber != 0) {
            int lastDigit = copyOfNumber % 10;
 
            int lastDigitToThePowerOfNoOfDigits = 1;
 
            for(int i = 0; i < noOfDigits; i++) {
                lastDigitToThePowerOfNoOfDigits = lastDigitToThePowerOfNoOfDigits * lastDigit;
            }
 
            sum = sum + lastDigitToThePowerOfNoOfDigits;
 
            copyOfNumber = copyOfNumber / 10;
        }
        if (sum == number)
        {
            System.out.println(number+" is an armstrong number");
        }
        else
        {
            System.out.println(number+" is not an armstrong number");
        }
    }
}
