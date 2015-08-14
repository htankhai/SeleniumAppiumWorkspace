package coreJava;

public class RemoveWhiteSpacesString {
	public static void main(String[] args) {
		String str = "  Core Java jsp servlets             jdbc struts hibernate spring  ";

		//Using replaceAll() Method
		String strWithoutSpace = str.replaceAll("\\s", "");
		System.out.println(strWithoutSpace);         

		//Without Using replaceAll() Method
		char[] strArray = str.toCharArray();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < strArray.length; i++) {
			if( (strArray[i] != ' ') && (strArray[i] != '\t') ) {
				sb.append(strArray[i]);
			}
		}

		System.out.println(sb);      
	}
}
