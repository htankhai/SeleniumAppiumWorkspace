package org.executionProcedure_enabled;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import parameters.Logger;
//import parameters.ParameterizedTest;

public class TestngAnnotation {
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("in before Suite");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("in after Suite");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("in before Test");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("in before Class");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("in after Class");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("in after Test");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("in before Method");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("in after Method");
	}

	// test case 1
	@Test
	public void testCase1() {

		System.out.println("in test case 1");
	}

	// test case 2
	@Test
	public void testCase2() {
		System.out.println("in test case 2");
	}
	
	@Test                             
    public void defaultEnabled(){
        System.out.println("by default enabled=true");
    }
    @Test(enabled=true)
    public void trueEnabled(){
        System.out.println("hard coded enabled=true");
    }
    @Test(enabled=false)
    public void falseEnabled(){
        System.out.println("this test case will be skipped because enabled=false");
    }

}