package coreJava;

public class ParameterTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 class MyClass  {
	            int myMethod(int i) {
	                i += 45;
	 
	                return i;
	            }
	        }
	 
	        System.out.println(new MyClass().myMethod(55));
	}

}
