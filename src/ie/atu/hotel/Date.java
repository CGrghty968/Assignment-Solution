package ie.atu.hotel;

import java.io.Serializable;
import java.util.Scanner;

public class Date implements Serializable {
	
	private int day, month, year;
	
	//Constructor (default)
	public Date() {
		day=month=year=0;
//		Default constructor sets all instance vars to 0
	}//End constructor
	
//	Constructor (Initiator)
	public Date(int d, int m, int y) {
		setDay(d);
		setMonth(m);
		setYear(y);
	}//End constructor 
	
//	toString() method
	@Override
	public String toString() {
		return day+"/"+month+"/"+year;
	}//Returns the date in String format
	
	@Override
	public boolean equals(Object obj) {
		Date date;
		if(obj instanceof Date)
			date = (Date)obj;
		else
			return false;
		
		return this.day == date.day
				&& this.month == date.month
				&& this.year == date.year;
	}//End equals
	
	//Getters and setters
	public void setDay(int d) throws IllegalArgumentException{
		if(d < 1 || d > 31)
			throw new IllegalArgumentException("Day must be between 1 and 31.");
		
		day = d;
	}//End setDay()
	
	public void setMonth(int m) throws IllegalArgumentException{
		if(m > 12 || m < 1)
			throw new IllegalArgumentException("Month must be between 1 and 12");
		
		month = m;
	}//End setMonth()
	
	public void setYear(int y) throws IllegalArgumentException{
		if(y < 1900)
			throw new IllegalArgumentException("Year must be greater than 1900");
		year = y;
	}//End setYear()
	
	public int getDay() {
		return day;
	}//End getDay()
	
	public int getMonth() {
		return month;
	}//End getMonth()
	
	public int getYear() {
		return year;
	}//End getYear()
	
	//read() method
	public void read() {
		Scanner kb = new Scanner(System.in);
		
		System.out.print("Day: ");
		this.day = kb.nextInt();
		System.out.print("\nMonth: ");
		this.month = kb.nextInt();
		System.out.print("\nYear: ");
		this.year = kb.nextInt();
		
	}
}//End class
