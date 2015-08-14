package coreJava;

public enum MyEnums3 {
	FIRST;
	 
    class InnerClass {
        int i;
    }
}

//access “i” of InnerClass
//MyEnums3.FIRST.new InnerClass().i;