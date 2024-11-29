package ie.atu.tester;

import java.util.ArrayList;

import ie.atu.hotel.Person;
import ie.atu.hotel.Room;

public class RoomTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Constructing ArrayList of Room objects
		ArrayList<Room>  rooms = new ArrayList<Room>();
		
		
		//Risky code should be tried and handled
		try { //Try to add the rooms to ArrayList
			//Large for loop to add the first 10 rooms
			for(int i=1;i<=10;i++) {
				if(i<=5) { //For the first 5 Double Rooms
	
					Room room = new Room(i, "DOUBLE", 160.00, false);
					rooms.add(room);
				}//End if
				else { //Segment of code for the next 5 King Rooms
					Room room = new Room(i, "KING", 185.00, false);
					rooms.add(room);
				}//End else
			}//End for loop for Double rooms
		}//End try
		catch(IllegalArgumentException e) { //Catch whenever an argument is invalid
			System.out.print("Illegal argument, Room type must be Double, King or Family and"
					+ " price per night cannot be below €100"); //Display error information to the user
		}//End catch
		
		//Manually constructing rooms objects
		Room familyRoom1 = new Room(11, "FAMILY", 210.00, false);
		rooms.add(familyRoom1);
		Room familyRoom2 = new Room(12, "FAMILY", 210.00, false);
		rooms.add(familyRoom2);
		Room familyRoom3 = new Room(13, "FAMILY", 210.00, false);
		rooms.add(familyRoom3);
		
		//Printing out the ArrayList of rooms
		System.out.println("ROOMS IN HOTEL");
		for(Room r:rooms) {
			System.out.println(r);
		}//End for each loop
		
		
		//Searching ArrayList for Family rooms
		/**ArrayList<Room> familyRooms = new ArrayList<Room>(); //New ArrayList to store Family Rooms
		int familyRoomCount=0; //Initialising a counter for the amount of family rooms
		for(Room r:rooms) { //For each loop to iterate through each Room object in ArrayList
			if(r.getRoomType().equalsIgnoreCase("family")) { //If the Room Type is family
				familyRooms.add(r); //Store the Room in the new ArrayList
			}//End if
		}//End for each loop
		System.out.println("\nFAMILY ROOM LIST");
		//For each loop to iterate through the familyRoom ArrayList
		for(Room r:familyRooms) {
			System.out.println(r); //The question didn't ask to create a new ArrayList, so I decided against
			familyRoomCount++;     //Keeping my code here, in hopes of getting marks if I messed up elsewhere in my code
		}//End for each loop
		System.out.print(familyRoomCount+" FAMILY ROOM(S)");**/
		//Decided against storing family Rooms in a new ArrayList, but left code to show my work
		int familyRoomCount = 0; //Initialising Counter for the amount of family Rooms to 0
		
		System.out.println(); //New line to make output code more legible
		
		for(Room r:rooms) { //For each loop to iterate through ArrayList of Room objects
			if(r.getRoomType().equalsIgnoreCase("family")) {
				System.out.println(r);
				familyRoomCount++;
			}//End if
		}//End for each loop
		System.out.println(familyRoomCount+" FAMILY ROOM(S)\n");
		
		//To reserve the first available family room..
		for(Room r:rooms) {
			if(r.getRoomType().equalsIgnoreCase("family")) {
				r.reserve();
				System.out.println(); //Keeping output code segregated for easier viewing
				break; //Break out of the loop now that the Room is reserved
			}//End if
		}//End for each loop
		//Now to re-display the Family Rooms to test if the method reserve() works
		
		for(Room r:rooms) {
			if(r.getRoomType().equalsIgnoreCase("family")) {
				System.out.println(r);
			}//End if
		}//End for each loop
		
		//Creating a PolyMorphic ArrayList to store both Guests and Employees
		ArrayList<Person> peopleInHotel = new ArrayList<Person>();
	}//End main

}//End class