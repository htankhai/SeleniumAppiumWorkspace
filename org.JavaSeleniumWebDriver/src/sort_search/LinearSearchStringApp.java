package sort_search;

public class LinearSearchStringApp {
	public static void main(String[] args) {
		Contact test, found;
		Contact[] friends = new Contact[5];

		friends[0] = new Contact ("John", "Smith");
		friends[1] = new Contact ("Sarah", "Barnes");
		friends[2] = new Contact ("Mark", "Riley");
		friends[3] = new Contact ("Laura", "Getz");
		friends[4] = new Contact ("Larry", "Smith");

		test = new Contact ("Larry", "Smith");
		found = (Contact)linearSearch(friends, test);
		if (found != null)
			System.out.println ("Found: " + found);
		else
			System.out.println ("The contact was not found.");
		System.out.println ();

	}


	public static Comparable linearSearch (Comparable[] list, Comparable target) {
		int index = 0;
		boolean found = false;

		while (!found && index < list.length) {
			if (list[index].equals(target))
				found = true;
			else
				index++;
		}

		if (found)
			return list[index];
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
