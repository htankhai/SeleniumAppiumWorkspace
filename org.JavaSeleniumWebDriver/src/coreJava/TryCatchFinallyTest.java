package coreJava;

public class TryCatchFinallyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			throw new Exception("Exception");
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		finally
		{
			return;
		}
		
		//unreachable return statement
		return;
	}

}
