package sorting;
//  Creates an array of Contact objects, sorts them applying insertionSort method, then prints them.
public class PhoneList {

	public static void main (String[] args) {
		Contact[] friends = new Contact[6];
		friends[0] = new Contact ("Htan", "Khai", "415-555-7384");
		friends[1] = new Contact ("Sarah", "Barnes", "215-555-3827");
		friends[2] = new Contact ("Mark", "Riley", "733-555-2969");
		friends[3] = new Contact ("Laura", "Getz", "663-555-3984");
		friends[4] = new Contact ("Larry", "Smith", "464-555-3489");
		friends[5] = new Contact ("Frank", "Phelps", "322-555-2284");

		Sorting.insertionSort(friends);

		System.out.println();
		
		for (Contact friend : friends)
			System.out.println (friend);
	}
}
