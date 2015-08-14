package javaFiles_Selenium;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class DuplicateNumbers {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String>list = new ArrayList<String>();

		//list of numbers added in from 0-9
		for (int i = 0; i < 15; i++) {
			list.add(String.valueOf(i));
		}

		//Add another set of numbers from 0-5
		for (int i = 0; i < 7; i++) {
			list.add(String.valueOf(i));
		}

		System.out.println("My List : " + list);

		System.out.println("The duplicate elements from both list : " + findDuplicates(list));
	}

	public static Set<String> findDuplicates(List<String> listDuplicates) {
		final Set<String> set1 = new HashSet<String>();
		final Set<String> set2 = new HashSet<String>();

		for (String in : listDuplicates) {
			//Add numbers into two storage and get duplicate numbers
			if (!set1.add(in)) {
				set2.add(in);
			}
		}
		return set2;
	}

}
