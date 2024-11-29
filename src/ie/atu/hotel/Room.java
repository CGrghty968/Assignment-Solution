/**
 * Class: Software Implementation
 * Instructor: Maria Boyle
 * Name : Cillian Geraghty - L00181448
 * Description: Class Room - Developed for the Hotel System
 * Date: dd/mm/yyyy
 * @author Software Implementation Students
 * @version 1.0
 */
package ie.atu.hotel;

import java.text.DecimalFormat;

public class Room implements Reservable{
	private int roomNumber;
	private String roomType; //Which type of room it is, single, double or twin etc
	private double pricePerNight;
   private boolean allocated;

	public Room(int roomNumber, String roomType, double pricePerNight, boolean allocated) throws IllegalArgumentException{
		this.roomNumber=roomNumber;
		//Exception handling for the roomType
		if(!roomType.equalsIgnoreCase("king") && !roomType.equalsIgnoreCase("family") && !roomType.equalsIgnoreCase("double"))
			throw new IllegalArgumentException("Room type must be either King, Double or Family.");
		else
			this.roomType = roomType;
		//Exception handling for the price of the room
		if(pricePerNight < 100.00) //If price is less than 100
			throw new IllegalArgumentException("Price per night must be above 100.");
		else
			this.pricePerNight = pricePerNight;
		this.allocated=false;
	}//End Constructor

	@Override
	public String toString() {
		DecimalFormat df=new DecimalFormat("#.00");

		return roomNumber + " " + roomType + " ROOM @ €" + df.format(pricePerNight) + " per night " + (allocated ? "BOOKED" : "FREE");
	}//End toString()
	
	@Override
	public boolean equals(Object obj){
	   Room rObject;
	   if (obj instanceof Room)
		   rObject = (Room)obj;
	   else
	       return false;
	 
	   return this.roomNumber == (rObject.roomNumber);
	}//End equals()
	
				//Setters and getters
	public void setRoomNumber(int roomNumber){
		this.roomNumber=roomNumber;
	}//End setRoomNumber()
	
	public void setRoomType(String roomType){
		this.roomType=roomType;
	}//End setRoomType()
	
	public void setPricePerNight(double pricePerNight){
		this.pricePerNight=pricePerNight;
	}//End setPricePerNight()
	
	public void setAllocated(boolean allocated) {
		this.allocated=allocated;
	}//End setAllocated()
	
	public int getNumber() {
		return roomNumber;
	}//End getNumber()
	
	public String getRoomType() {
		return roomType;
	}//End getRoomType()
	
	public double getPricePerNight() {
		return pricePerNight;
	}//End getPricePerNight()
	
	public boolean getAllocated() {
		return allocated;
	}//End getAllocated()
	
				//Implemented interface methods
	public void reserve() { //Changing a Room's allocation to true
		if(!allocated) {
			setAllocated(true);
			System.out.print("Room "+roomNumber+" is reserved.");
		}//Setting the room as allocated, if it wasn't before
		else {
			System.out.print("Sorry, room "+roomNumber+" is already allocated/reserved.");
		}//End else
			
	}//End reserve()
	
	public void cancel() { //Changing a Room's allocation to false
		if(allocated) {
			setAllocated(false);
			System.out.print("Room "+roomNumber+" is available.");
		}//End if
	}//End cancel()
}//End class