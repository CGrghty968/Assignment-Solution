package ie.atu.hotel;

import java.io.Serializable;
import java.util.Scanner;

public abstract class Person implements Serializable {
	protected Name name;
	protected String phoneNumber;
	
	//Constructor (default)
	public Person() {
		name=new Name();
		phoneNumber="";
	}//End Constructor
	
	
	//Constructor (initialisation)
	public Person(Name n, String pN) {
		name = n;
		phoneNumber = pN;
	}//End constructor
	
	//Accessors and Mutators
	public Name getName() {
		return name;
	}//End getName()
	public void setName(Name name) {
		this.name=name;
	}//End setName()
	public String getPhoneNumber() {
		return phoneNumber;
	}//End getPhoneNumber()
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber=phoneNumber;
	}//End setPhoneNumber()
	
	@Override
	public String toString() {
		return name+"\t"+phoneNumber;
	}//End toString()
	
	@Override
	public boolean equals(Object o) {
		Person p;
		if(o instanceof Person)
			p = (Person)o; //Object must be casted to a Person object
		else
			return false; //Else not an object and cannot be converted
		
		return this.name.equals(p.name) 
				&& this.phoneNumber.equals(p.phoneNumber);
	}//End equals()
	
	public boolean read() {
		Scanner kb = new Scanner(System.in);
		
		System.out.print("Enter your title: ");
		String t = kb.nextLine();
		System.out.print("\nEnter your first name: ");
		String fn = kb.nextLine();
		System.out.print("\nEnter your surname: ");
		String ln = kb.nextLine();
		this.name = new Name(t, fn, ln);
		
		System.out.print("\nEnter your phone number: ");
		this.phoneNumber = kb.nextLine();
		return true;
	}//End read()
}//End class
