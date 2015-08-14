package sorting;
// write a program to bubble sort taken 6 i/p from user as bubble elements.

public class SortPhoneList_BubbleSort {
	//  Creates an array of Contact objects, sorts them, then prints them.
	public static void main (String[] args) {
		Contacts[] friends = new Contacts[6];
		friends[0] = new Contacts ("John", "Smith");
		friends[1] = new Contacts ("Sarah", "Barnes");
		friends[2] = new Contacts ("Mark", "Riley");
		friends[3] = new Contacts ("Laura", "Getz");
		friends[4] = new Contacts ("Larry", "Smith");
		friends[5] = new Contacts ("Frank", "Phelps");

		Sorting2.insertionSort(friends);

		for (Contacts friend : friends)
			System.out.println (friend);
	}
}

class Contacts implements Comparable {
	private String firstName, lastName, phone;

	public Contacts (String first, String last) 	{
		firstName = first;
		lastName = last;
	}

	public String toString () 	{
		return lastName + ", " + firstName ;
	}

	public boolean equals (Object other) 	{
		return (lastName.equals(((Contact)other).getLastName()) &&
				firstName.equals(((Contact)other).getFirstName()));
	}

	public int compareTo (Object other) 	{
		int result;

		String otherFirst = ((Contacts)other).getFirstName();
		String otherLast = ((Contacts)other).getLastName();

		if (lastName.equals(otherLast))
			result = firstName.compareTo(otherFirst);
		else
			result = lastName.compareTo(otherLast);

		return result;
	}

	public String getFirstName () {
		return firstName;
	}

	public String getLastName () {
		return lastName;
	}
}

class Sorting2 {
	public static void insertionSort (Comparable[] list) {
		for (int index = 1; index < list.length; index++) {
			Comparable key_value = list[index];
			int position = index;

			//shift greater than and less than value of zero
			//  Shift larger values to the right
			while (position > 0 && key_value.compareTo(list[position-1]) < 0) {
				list[position] = list[position-1];
				position--;
			}

			list[position] = key_value;
		}
	}
}



