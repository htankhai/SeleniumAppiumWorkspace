package coreJava;
//compilation error
//Members of inner class of super class are not inherited to sub class.
public class C extends A {
    void methodOfC() {
        System.out.println(i);
    }

}

class A {
    class B {
        int i;
    }
}