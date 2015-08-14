package coreJava;
/*used HashMap with character as a key and it’s occurrences as a value. First, we convert the given string 
 * to char array and check each character one by one. And update it’s count in HashMap.used HashMap with 
 * character as a key and it’s occurrences as a value. First, we convert the given string to char array 
 * and check each character one by one. And update it’s count in HashMap.
 * */
import java.util.HashMap;

public class CharCountInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		characterCount("Java J2EE Java JSP J2EE");
		characterCount("All Is Well");
		characterCount("Done And Gone");
	}

	static void characterCount(String inputString) {
		//Creating a HashMap containing char as a key and occurrences as  a value

		HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();

		//Converting given string to char array

		char[] strArray = inputString.toCharArray();

		//checking each char of strArray

		for (char c : strArray) {
			if(charCountMap.containsKey(c)) {
				//If char is present in charCountMap, incrementing it's count by 1

				charCountMap.put(c, charCountMap.get(c)+1);
			}
			else {
				//If char is not present in charCountMap,
				//putting this char to charCountMap with 1 as it's value

				charCountMap.put(c, 1);
			}
		}

		//Printing the charCountMap

		System.out.println(charCountMap);
	}
}
