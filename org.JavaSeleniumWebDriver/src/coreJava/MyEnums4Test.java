package coreJava;

public class MyEnums4Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyEnums4[] myEnums = new MyEnums4[4];
		 
	       for (int i = 0; i < myEnums.length; i++)
	       {
	           System.out.println(myEnums[i]);
	       }
	}

}


enum MyEnums4 {
	FIRST, SECOND, THIRD, FOURTH;
}
