package coreJava;

public class Null {
	public static void main(String[] args){
		methodOfA();

	}

	static int methodOfA() {
		return (true ? null : 0);
	}
}
