package coreJava;
//give compile time error.
public enum MyEnums2 {
	FIRST
	{
		int i;
	},

	SECOND
	{
		void methodOfSecond()
		{
			//Because, i is local to FIRST constant. It is invisible to SECOND constant
			System.out.println(i);
		}
	},
}
