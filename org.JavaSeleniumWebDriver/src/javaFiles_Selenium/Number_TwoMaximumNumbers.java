package javaFiles_Selenium;

class Number_TwoMaximumNumbers {
	public void printTwoMaximumNumbers(int[] nums){

		int maxOne = 0;
		int maxTwo = 0;
		for(int n:nums){
			if(maxOne<n){
				maxTwo = maxOne;
				maxOne = n;
			}else if(maxTwo<n){
				maxTwo = n;
			}

		}

		System.out.println("Maximum number one "+maxOne);
		System.out.println("Maximum number two "+ maxTwo);
	}


	public static void main(String []args){

		int num[] = {5,34,88,2,45,1,99,23};
		Number_TwoMaximumNumbers tmn = new Number_TwoMaximumNumbers();
		tmn.printTwoMaximumNumbers(num);
	}
}
