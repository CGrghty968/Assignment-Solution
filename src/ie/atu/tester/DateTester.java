/**
 * Class: B.Sc. in Computing
 * Instructor: Maria Boyle
 * Description: Tester for the Date class
 * Date: dd/mm/yyyy
 * @author Maria Boyle
 * @version 1.0
**/
package ie.atu.tester;

import java.util.Scanner;

import ie.atu.hotel.Date;

public class DateTester{
	public static void main(String[] args) {
		Date d1 = new Date();
      System.out.println(d1);      

	   d1.setDay(4);
	   d1.setMonth(6);
	   d1.setYear(1941);
		
	   System.out.println(d1);
      
	   Date d2 = new Date(28, 12, 1982);
       System.out.println(d2);
      
	   if(d1.equals(d2))
	      System.out.println("Date's are equal.");
	   else
	   	  System.out.println("Date's are not equal.");
	   
	   int day = 55, month = 13, year =-2009;
	   Date myDate = new Date();
	   boolean goodInput = false;
	   do {
		   try {
				myDate = new Date();
				myDate.setDay(day);
				myDate.setMonth(month);
				myDate.setYear(year);
				goodInput = true;
				System.out.println("\n"+myDate);
		   }//End try
		   
		   catch(IllegalArgumentException e) {
			   System.out.print("Day, month and year must be a valid value. Re-enter Date.");
				Scanner kb = new Scanner(System.in);
				
				System.out.print("Day: ");
				day = kb.nextInt();
				System.out.print("\nMonth: ");
				month = kb.nextInt();
				System.out.print("\nYear: ");
				year = kb.nextInt();
		   }//End catch
	   }while(!goodInput);
	   Date myDate2 = new Date();
	   goodInput = false;
	   day = 55;
	   month = 16;
	   year = 12;
	   do {
		   try {
			   myDate2 = new Date(day, month, year);
			   goodInput = true;
		   }//End try
		   catch(IllegalArgumentException e) {
			   System.out.print("Invalid Date");
				Scanner kb = new Scanner(System.in);
				
				System.out.print("Day: ");
				day = kb.nextInt();
				System.out.print("\nMonth: ");
				month = kb.nextInt();
				System.out.print("\nYear: ");
				year = kb.nextInt();
		   }//End catch
	   }while(!goodInput);
   }//End main
}//End class