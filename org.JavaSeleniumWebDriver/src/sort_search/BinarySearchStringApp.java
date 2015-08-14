package sort_search;
// write a program for binary search. And 5 i/p has to take from user as binary elements.

public class BinarySearchStringApp {
	public static void main (String[] args) {		
		Contact[] friends = new Contact[5];
		friends[0] = new Contact ("John", "Smith");
		friends[1] = new Contact ("Sarah", "Barnes");
		friends[2] = new Contact ("Mark", "Riley");
		friends[3] = new Contact ("Laura", "Getz");
		friends[4] = new Contact ("Larry", "Smith");

		Contact test, found;
		
		test = new Contact ("Sarah", "Barnes");
		found = (Contact) binarySearch(friends, test);
		
		if (found != null)
			System.out.println ("Found: " + found);
		else
			System.out.println ("The contact was not found.");
		System.out.println ();

	}
	
	public static Comparable binarySearch (Comparable[] list, Comparable target) {
		int min=0, max=list.length, mid=0;
		boolean found = false;

		while (!found && min <= max) {
			mid = (min+max) / 2;
			if (list[mid].equals(target))
				found = true;
			else
				//lower mid point
				if (target.compareTo(list[mid]) < 0)
					max = mid-1;
				else
					//upper mid point
					min = mid+1;
		}

		if (found)
			return list[mid];
		else
			return null;
	}


}


class Contact implements Comparable {
	private String firstName, lastName;

	public Contact (String first, String last) {
		firstName = first;
		lastName = last;
	}

	public String toString () {
		return lastName + ", " + firstName ;
	}


	public boolean equals (Object other) {
		return (lastName.equals(((Contact)other).getLastName()) &&
				firstName.equals(((Contact)other).getFirstName()));
	}

	public int compareTo (Object other) {
		int result;

		String otherFirst = ((Contact)other).getFirstName();
		String otherLast = ((Contact)other).getLastName();

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

