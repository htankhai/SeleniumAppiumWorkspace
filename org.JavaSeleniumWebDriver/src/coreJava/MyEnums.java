package coreJava;

public enum MyEnums implements MyInterface {
	A, B, C;

	@Override
	public void methodOfMyInterface() {
		// TODO Auto-generated method stub
	}

}

interface MyInterface{
	void methodOfMyInterface();
}