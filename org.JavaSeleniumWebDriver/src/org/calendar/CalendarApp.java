package org.calendar;

import java.util.Calendar;

class CalendarApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//returns a calender object for the default locale and time zone.
		Calendar caldr = Calendar.getInstance();
		System.out.println("Current Calender");
		System.out.println("YEAR         : "+caldr.get(Calendar.YEAR));
		System.out.println("MONTH        : "+caldr.get(Calendar.MONTH));
		System.out.println("DAY_OF_MONTH : "+caldr.get(Calendar.DAY_OF_MONTH)); 
		System.out.println("HOUR         : "+caldr.get(Calendar.HOUR));
		System.out.println("MINUTE       : "+caldr.get(Calendar.MINUTE));
		System.out.println("SECOND       : "+caldr.get(Calendar.SECOND)); 


		//Update Calender
		System.out.println("\nSet the calender ");
		int year = 2014;
		int month = 5;
		int dayOfMonth = 6;
		int hour = 12;
		int minute = 45;
		int second = 55;
		
		caldr.set(year, month, dayOfMonth, hour, minute, second);
		System.out.println("YEAR         : "+caldr.get(Calendar.YEAR));
		System.out.println("MONTH        : "+caldr.get(Calendar.MONTH));
		System.out.println("DAY_OF_MONTH : "+caldr.get(Calendar.DAY_OF_MONTH)); 
		System.out.println("HOUR         : "+caldr.get(Calendar.HOUR));
		System.out.println("MINUTE       : "+caldr.get(Calendar.MINUTE));
		System.out.println("SECOND       : "+caldr.get(Calendar.SECOND)); 
	}

}
