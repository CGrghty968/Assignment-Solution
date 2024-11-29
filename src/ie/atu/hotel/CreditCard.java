package ie.atu.hotel;

import java.util.Scanner;
public class CreditCard {
	private long number;
	private Date expiryDate;
	private int securityCode;

	
	//Constructor
	public CreditCard(long n, Date eD, int sC) {
		number=n;
		expiryDate=eD;
		securityCode=sC;
	}//End Constructor
	
	@Override
	public String toString() {
		return ""+number;
	}//End toString()
	
	@Override
	public boolean equals(Object o) {
		CreditCard c;
		if(o instanceof CreditCard)
			c = (CreditCard)o; //Casted to credit card
		else
			return false; //Won't be equal since it's not a credit card
		
		return this.number == c.number; //The number is unique, therefore it's the only thing that matters
											//and needs to be compared
	}//End equals()
	
	//Accessor
	public long getNumber() {
		return number;
	}//End getNumber()
	
	public Date getExpiryDate() {
		return expiryDate;
	}//End getExpiryDate()
	
	public int getSecurityCode() {
		return securityCode;
	}//End getSecurityCode()
	
	public void read() {
		Scanner keyIn = new Scanner(System.in);
		System.out.print("Enter your Credit Card number: ");
		number = keyIn.nextLong();
		System.out.print("\nEnter your expiry date: ");
		int d = keyIn.nextInt();
		int m = keyIn.nextInt();
		int y = keyIn.nextInt();
		expiryDate = new Date(d,m,y); //Constructing new Date object from the read-in ints
		System.out.print("\nEnter your security code: ");
		securityCode = keyIn.nextInt();
		
	}//End read()
}//End class
