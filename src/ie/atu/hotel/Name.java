package ie.atu.hotel;

import java.io.Serializable;

// Name class for Package Hotel
public class Name implements Serializable {
	// Instance Variables for Name class
	private String title;
	private String firstName;
	private String surName;
	
	// Class Constructor (Default):
	public Name() 
	{
		// Initialises all instance variables to empty String
		title=firstName=surName = "";
	}//End Constructor (Default)
	
	// Class Constructor (initialisation):
	public Name(String t, String fN, String sN)
	{
		// Creates a Name object with values passed through parameters
		title = t;
		firstName = fN;
		surName = sN;
	}//End Constructor (initialisation)
	
	// toString() method:
	@Override //Must override the toString method
	public String toString()
	{
		// Returns the instance variables in String format
		return title + " " + firstName + " " + surName;
	}//End toString() method
	
	// equals() method:
	@Override //Must override the method
	public boolean equals(Object obj)
	{
		//Creates Name object to convert the object
		Name name;
		if (obj instanceof Name) //If it is a Name object, convert it	
			name = (Name)obj;
		else
			return false; //Isn't equal as they aren't the same object
		
		// Returns whether or not all the instance variables are the same between the two name Objects
		return this.title.equals(name.title)
				&& this.firstName.equals(name.firstName)
				&& this.surName.equals(name.surName);
	}//End equals() method
	
	
	// Accessor Methods:
	// getTitle() method:
	public String getTitle()
	{
		// Returns the String title
		return title;
	}//End getTitle() method
	
	// getFirstName() method:
	public String getFirstName()
	{
		// Returns the instance variable firstName
		return firstName;
	}//End getFirstName() method
	
	//getSurName() method:
	public String getSurName()
	{
		// Returns the instance variable surname
		return surName;
	}//End getSurName() method
	
	
	// Mutator Methods:
	// setTitle(t) method:
	public void setTitle(String title)
	{
		this.title = title;
	}//End setTitle(t) method
	
	// setFName(f) method:
	public void setFName(String firstName)
	{
		this.firstName = firstName;
	}//End setFName(f)
	
	// setSName(s) method:
	public void setSName(String surName)
	{
		this.surName = surName;
	}//End setSName(s) method
	
	// isFemale() method:
	public boolean isFemale()
	{
		// If the title is ms, mrs or miss the client is female return true
		if(title.equalsIgnoreCase("miss") || 
			title.equalsIgnoreCase("mrs") ||
			title.equalsIgnoreCase("ms")) //Ignores whether or not its capital or whatever
			return true;
		else
			return false;
	}//End isFemale()
	
}//End Class




