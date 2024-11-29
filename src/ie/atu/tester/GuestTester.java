package ie.atu.tester;

import java.util.ArrayList;

import ie.atu.hotel.CreditCard;
import ie.atu.hotel.Date;
import ie.atu.hotel.Guest;
import ie.atu.hotel.Name;

public class GuestTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Name name;
		CreditCard card;
		ArrayList<Guest> guests = new ArrayList<Guest>();
		//Create Guest object no.1
		name = new Name("Mr", "Homer", "Simpson");
		card = new CreditCard(1111222233334444L,
				new Date(31, 12,2027), 111);
		
		Guest g1 = new Guest(name, "087 1234567",
				"homerSimpson@atu.ie", card);
		
		//Create Guest object no.2
		name = new Name("Mrs", "Marge", "Simpson");
		card = new CreditCard(9999888877776666L, 
				new Date(31,3,2024), 333);
		
		Guest g2 = new Guest(name, "087 9876543",
				"margeSimpson@atu.ie", card);
		
		//Create Guest object no.2
		name = new Name("Miss", "Lisa", "Simpson");
		card = new CreditCard(5555666677778888L,
				new Date(31,6,2026), 222);
		
		Guest g3 = new Guest(name, "087 431284",
				"LisaSimpson@atu.ie", card);
		
		guests.add(g1);
		guests.add(g2);
		guests.add(g3);
		
		System.out.println("LIST OF GUESTS");
		//For each loop to print out each element which is a guest in the ArrayList
		for(Guest g:guests)
			System.out.println(g);
			
		//Counting how many women are in the ArrayList
		int maleCount=0, femaleCount=0;
		for(Guest g:guests)
			if(g.getName().isFemale())
				femaleCount++;
			else
				maleCount++;
		
		System.out.println("\nMALE/FEMALE GUEST COUNT");
		System.out.print(maleCount+" MALE(S), "+femaleCount+" FEMALE(S).");
		
		//CreditCard info
		System.out.println("\nGUEST CREDIT CARD DETAILS");
		for(Guest g :guests)
			System.out.println(g.getName() +" "+ g.getCreditCard());
	}//End main

}//End Class
