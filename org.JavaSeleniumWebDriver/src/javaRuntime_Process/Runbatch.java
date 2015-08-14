package javaRuntime_Process;

import java.io.IOException;

class Runbatch {
	public static void main(String[] args) throws IOException, InterruptedException{
		Runtime runtime = Runtime.getRuntime();
		Process process = runtime.exec("cmd /c C:\\Users\\htan\\workspace1\\Org.JavaAutomatedSeleniumWebDriver\\src\\javaFiles_Selenium\\Letters.dat");
		
		process.waitFor();
		
		Thread.sleep(3000);
		process.destroy();
	}
}
