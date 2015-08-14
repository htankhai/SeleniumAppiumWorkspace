package commandLine;
class CommandLineArgApp {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	     if(args.length!=0)
	        {
	            System.out.println("Arguments[0] : "+args[0]);
	            System.out.println("Arguments[1] : "+args[1]);
	            System.out.println("Arguments[2] : "+args[2]);
	        }else
	            System.out.println("Arguments not found");
	}

}
