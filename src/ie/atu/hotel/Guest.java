package ie.atu.hotel;

import java.util.Scanner;

public class Guest extends Person {
	//Guest has Name and PhoneNumber from Person class
	private String emailAddress;
	private CreditCard creditCard;
	
	//Constructor(Default)
	public Guest() {
		super();
		emailAddress = "";
	}//End Constructor(Default)
	
	//Constructor(Initiator)
	public Guest(Name n, String pN, String email, CreditCard cc) {
		super(n, pN); //Construct Person part using the superclass constructor
		this.emailAddress = email;
		this.creditCard = cc; //Initialise 2 additional fields
	}//End Constructor(Default)
	
	@Override
	public String toString() {
		return super.toString()+"\t"+emailAddress;
	}//End toString()
	
 //Can use the super equals, as it's not likely that a guest will have the same phone number AND name
 //Superclass's equals() method will be sufficient
	
	//Accessors and Mutators
	public void setEmailAddress(String eA) {
		emailAddress = eA;
	}//End setEmailAddress()
	public String getEmailAddress() {
		return emailAddress;
	}//End getEmailAddress()
	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}//End setCreditCard()
	public CreditCard getCreditCard() {
		return creditCard;
	}//End getCreditCard()
	
	//Read a Guest's details
	public boolean read() {
		//Call Person's read() to read name and phoneNumber
		super.read();
		
		//Then read emailAddress and creditCard
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter email address: ");
		emailAddress = kb.nextLine();
		
		creditCard.read(); //Use the read method from CreditCard class
		return true;
	}//End read()
	
	
}//End class
