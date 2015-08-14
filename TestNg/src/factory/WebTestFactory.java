package factory;
//test the web application with 10 users,
public class WebTestFactory {
	 @Factory

     public Object[] createInstances() {

      Object[] obj = new Object[10];

      for (int i = 0; i < 10; i++) {

         obj[i] = new TestClass1();

       }

       return obj;

     }
}
