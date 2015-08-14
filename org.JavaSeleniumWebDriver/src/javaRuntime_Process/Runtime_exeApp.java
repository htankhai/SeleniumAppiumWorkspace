package javaRuntime_Process;

class Runtime_exeApp {
	public static void main(String[] args) {
		//Runtime object 
		Runtime rt = Runtime.getRuntime();

		Process pr = null;

		try {
			//create an object of type Process
			pr = rt.exec("mspaint");

			try{
				Thread.sleep(5000);
			}catch(InterruptedException ie)
			{
				System.out.println("Thread Interrupted");
			}
			//terminate the process
			pr.destroy();
		}catch (Exception e)	{
			System.out.println("Error Executing Programs");
		}

	}

}
