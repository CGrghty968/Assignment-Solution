package ie.atu.tester;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import ie.atu.hotel.CreditCard;
import ie.atu.hotel.Date;
import ie.atu.hotel.Guest;
import ie.atu.hotel.Name;

public class ExceptionHandlerDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Name name;
		CreditCard card;
		ArrayList<Guest> hotelGuests = new ArrayList<Guest>();
		//Create Guest object no.1
		name = new Name("Mr", "Homer", "Simpson");
		card = new CreditCard(1111222233334444L,
				new Date(31, 12,2027), 111);
		
		Guest guest = new Guest(name, "087 1234567",
				"homerSimpson@atu.ie", card);
		hotelGuests.add(guest);
		
		//Create Guest object no.2
		name = new Name("Mrs", "Marge", "Simpson");
		card = new CreditCard(9999888877776666L, 
				new Date(31,3,2024), 333);
		
		guest = new Guest(name, "087 9876543",
				"margeSimpson@atu.ie", card);
		hotelGuests.add(guest);
		
		//Create Guest object no.2
		name = new Name("Miss", "Lisa", "Simpson");
		card = new CreditCard(5555666677778888L,
				new Date(31,6,2026), 222);
		
		guest = new Guest(name, "087 431284",
				"LisaSimpson@atu.ie", card);
		hotelGuests.add(guest);
		
		
		//Entomb the risky code in a try block
		//Boolean flag to enable loop
		boolean goodInput = false;
		do {
			//Declare String in the loop to allow try and catch to use it
			String guestNumberToViewAsString ="";
			try {
				guestNumberToViewAsString 
				= JOptionPane.showInputDialog(null, "Enter guest to view ("+1+" to "+hotelGuests.size()+")");
				int guestToView = Integer.parseInt(guestNumberToViewAsString); /**Prompt the user to enter which
				guest they want to view**/
				System.out.println(hotelGuests.get(guestToView-1));
				//flag is changed to true, as flow of control was maintained
				goodInput = true;
				}//End try
			
			//Catch for whenever the input is not an integer
			catch(NumberFormatException e) {
				//If the user clicks the X or the cancel button, allow the program to return
				if(guestNumberToViewAsString == null)
					break;
				//Handling for when the user enters an empty String
				else if(guestNumberToViewAsString.equals(""))
					JOptionPane.showMessageDialog(null, "You must enter an integer value 1 - "+hotelGuests.size()+".", "Error", JOptionPane.ERROR_MESSAGE);
				//Else, return to the normal handling
				else
					JOptionPane.showMessageDialog(null,guestNumberToViewAsString + " is not a valid option.\nYou must choose an employee from 1 - "
							+ hotelGuests.size()+".\nPlease re-enter.", "Error", JOptionPane.ERROR_MESSAGE);
			}//End Catch1
			
			//Catch for whenever the integer entered is out of range of hotelGuests.size()
			catch(IndexOutOfBoundsException e) {
				JOptionPane.showMessageDialog(null,guestNumberToViewAsString + " is out of range.\nYou must choose an employee from 1 - " + hotelGuests.size()
				+ ".\nPlease re-enter.", "Error", JOptionPane.ERROR_MESSAGE);
			}//End Catch2
			
		//Loop continues until the user can input value without error
		}while(!goodInput);
		
		//Display the guest
		
	}//End main

}//End Class
