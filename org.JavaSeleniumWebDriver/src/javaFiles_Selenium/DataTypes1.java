package javaFiles_Selenium;
//Apply static variable and this keyword

public class DataTypes1 {
	String a = "x";
	static char t = 'x';
	String s = "x";

	class Inner{
		String a = "y";
		final static String t ="v";
		
		String get(){
			String c = "temp";

			//call x value
			//c = ""+DataTypes1.this.t;//static variable//x
			c = ""+DataTypes1.t;//static variable//x

			//c = DataTypes1.this.s;//x	
			// c = DataTypes1.this.a;//x


			//c = ""+this.t;//static variable//v
			//c = ""+t;//static variable//v


			// c = ""+a;// call y value
			//c=this.a;//y
			//c= c;//temp
			return c;
		}
	}

	DataTypes1(){
		System.out.println(new Inner().get());
	}

	public static void main(String[] args)   {
		new DataTypes1();
	}
}
