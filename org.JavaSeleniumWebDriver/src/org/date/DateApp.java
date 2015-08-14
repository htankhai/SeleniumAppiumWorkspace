package org.date;
import java.util.Date;

public class DateApp {
	public static void main(String[] args) {

		// Instantiate a Date object 
		Date date =new Date(); 

		// display time and date using toString() 
		System.out.println(date.toString());
		System.out.println(date);
		System.out.println("Current local time : " + date.toLocaleString());
		System.out.println("Current GMT time : " +date.toGMTString());

		//the year represented by this date, since 1900
		System.out.println("getYear From 1900 : "+date.getYear());
		System.out.println("getMonth     : "+date.getMonth());
		System.out.println("getDate      : "+date.getDate());
		System.out.println("getHours()   : "+date.getHours());
		System.out.println("getMinutes   : "+date.getMinutes());
		System.out.println("getSeconds() : "+date.getSeconds());
	}

}
