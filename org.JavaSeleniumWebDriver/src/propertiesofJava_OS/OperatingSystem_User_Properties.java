package propertiesofJava_OS;

class OperatingSystem_User_Properties {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Os Name    : "+System.getProperty("os.name"));
		System.out.println("Os Version : "+System.getProperty("os.version"));
		System.out.println("Os Architecture : "+System.getProperty("os.arch"));
		System.out.println("User Directory : "+System.getProperty("user.dir"));
		System.out.println("User Home  : "+System.getProperty("user.home"));
		System.out.println("User Name  : "+System.getProperty("user.name"));
	}

}
