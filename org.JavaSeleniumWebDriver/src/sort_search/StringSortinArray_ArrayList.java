package sort_search;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class StringSortinArray_ArrayList {
	public static void main(String[] args) throws Exception { 
		String[] strArray = { "Htan", "selenium", "Automation", "SELENIUM" };

		displayArray(strArray);
		Arrays.sort(strArray);
		displayArray(strArray);

		//sorted array with case insensitive
		Arrays.sort(strArray, String.CASE_INSENSITIVE_ORDER);

		displayArray(strArray);

		System.out.println();

		///sorting strings using arraylist
		List<String> strList = new ArrayList<String>();
		strList.add("Selenium");
		strList.add("Webdriver");
		strList.add("Automation");
		displayList(strList);

		Collections.sort(strList);
		displayList(strList);

		Collections.sort(strList, String.CASE_INSENSITIVE_ORDER);
		displayList(strList);
	}

	public static void displayArray(String[] array) {
		for (String str : array) {
			System.out.print(str + " ");
		}
		System.out.println();
	}

	public static void displayList(List<String> list) {
		for (String str : list) {
			System.out.print(str + " ");
		}
		System.out.println();
	}

}
