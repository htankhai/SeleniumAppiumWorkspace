package date;
/**
   This program demonstrates the DateComponent class.
 */
public class DateTester{
	public static void main(String[] args){
		String date = "10/28/2014";
		DateComponent dc =null ;
		
		try{
			dc = new DateComponent(date);
		}
		catch(IllegalArgumentException e)
		{
			System.out.println(e.getMessage());
		}


		System.out.println("Here's the date: " + date);
		System.out.println("The month is " +
				dc.getMonth());
		System.out.println("The day is " +
				dc.getDay());
		System.out.println("The year is " +
				dc.getYear());
	}
}