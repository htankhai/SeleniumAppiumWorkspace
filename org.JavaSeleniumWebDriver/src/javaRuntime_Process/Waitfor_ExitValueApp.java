package javaRuntime_Process;

class Waitfor_ExitValueApp {
	public static void main(String[] args) {
		//Create runtime object
		Runtime rt = Runtime.getRuntime();
		Process pr = null;

		try {
			//create process object
			pr = rt.exec("notepad");

			pr.waitFor();

		}catch (Exception e)
		{
			System.out.println("Error Executing Programs");
		}

		if(pr.exitValue()==0)
		{
			System.out.println("Program Exit Successfully");
		}else
			System.out.println("An Error Occured");
	}

}
