package coreJava;

public class CountCharactersOccurence {
	public static void main(String[] args) {
		String s = "Java Programming World is java again java again";

		char c = 'g';
		int count = s.length() - s.replace("g", "").length();

		System.out.println("Number of occurances of 'g' in "+s+" = "+count);
	}
}
