package ie.atu.tester;

import java.util.ArrayList;

import ie.atu.hotel.Date;
import ie.atu.hotel.Name;

public class NameTester {

	public static void main(String[] args)
	{
		//Creating new Name object
		Name personA = new Name();
		//Creating Name object with overloaded constructor
		Name personB = new Name("Mrs", "Marge", "Simpson");
		
		//display personA's details
		System.out.println(personA);
		
		//Set personA's details
		personA.setTitle("Mr");
		personA.setFName("Homer");
		personA.setSName("Simpson");
		
		//Display again
		System.out.println(personA);
		
		//Display personB
		System.out.println(personB);
		
		//Test isFemale() method
		System.out.println(personB.isFemale());
		System.out.println(personA.isFemale());
		
		//Test equals() method
		System.out.println(personA.equals(personB));
		
		//Create ArrayList to store the names and one extra
		ArrayList<Name> nameList = new ArrayList<Name>();
		
		nameList.add(personA);
		nameList.add(personB);
		nameList.add(new Name("Mr", "Bart", "Simpson"));
		
		System.out.println(nameList);
		

		
	}//End main()
}//End class
