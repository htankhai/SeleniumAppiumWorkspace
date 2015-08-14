package performanceTesting;

import org.testng.annotations.Test;

public class PerformanceTesting {
	//Start a thread pool, which contains 4 threads, and run the test method 12 times.
  //  @Test  (invocationCount=12, threadPoolSize=4)
    public void runTest(){
        System.out.println("Thread Id: "+Thread.currentThread().getId());
              
    }
    
    //execute test case 5 times.
    @Test(invocationCount=5)
    public void runMultipleTimes(){
        System.out.println("run this test");
    }
    
    @Test(timeOut=3000) //time is in milliseconds, here this test case will execute for max 3sec if it will not complete in 3sec then it will be failed.
    public void thisTestShouldPass() throws InterruptedException{
        System.out.println("This test case should pass");
        Thread.sleep(1000); //wait for 1 sec
    }
    
    @Test(timeOut=5000)  //here this test case will execute for max 5sec if it will not complete in 5sec then it will be failed.
    public void thisTestShouldFail(){
        System.out.println("This test case should fail");
        while(true); //this loop is never going to end as condition is always true
    }
}
/* Use threadPoolSize and invocationCount attribute.
The threadPoolSize attribute tells TestNG to create a thread pool to run the test method via multiple threads.
 With thread pool, it will greatly decrease the running time of the test method.
*/