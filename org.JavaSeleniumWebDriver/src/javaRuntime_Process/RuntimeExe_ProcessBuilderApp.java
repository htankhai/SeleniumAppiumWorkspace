package javaRuntime_Process;

class RuntimeExe_ProcessBuilderApp {
	public static void main(String[] args) {
		try {
			//ProcessBuilder pro = new ProcessBuilder("mspaint");
			ProcessBuilder pro = new ProcessBuilder("mspaint","smiley.gif");
			pro.start();
		}catch(Exception e)
		{
			System.out.println("Error Execuing Program");
		}
	}

}
