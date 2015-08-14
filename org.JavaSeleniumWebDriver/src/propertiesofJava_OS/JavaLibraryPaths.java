package propertiesofJava_OS;

import java.util.StringTokenizer;

class JavaLibraryPaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringTokenizer st = new StringTokenizer(System.getProperty("java.library.path"),";");

		while(st.hasMoreTokens())
		{
			String get = st.nextToken();
			System.out.println(get);
		}

	}

}
