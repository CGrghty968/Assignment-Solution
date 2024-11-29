package ie.atu.serialize;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ie.atu.hotel.Employee;

public class EmployeeSerializer{
	//Declaring the ArrayList of Employee objects employees
	private ArrayList<Employee> employees;
	
	//Creating a constant variable for the file name
	private final String FILENAME = "employees.bin";
	//Declaring the File object
	private File employeesFile;	
	//Declaring the index of the last Employee object in the ArrayList employees
	int empIndex;
	
	// Default Constructor
	public EmployeeSerializer(){
		// Construct EmployeeList ArrayList
		employees = new ArrayList<Employee>();
		
		// Construct Employee File
		employeesFile = new File(FILENAME);
		try {
			//Creating new file in try block
			employeesFile.createNewFile();
		}// End try
		catch (IOException e) {
			//Catching input/output error
			System.out.println("Error");
			e.printStackTrace();
		}// End catch

	}	//End default constructor

	/////////////////////////////////////////////////////////////
	// Method Name : add()								              //
	// Return Type : void								              //
	// Parameters : None								                 //
	// Purpose : Reads one Employee record from the user       //
	//           and adds it to the ArrayList called employees //
	/////////////////////////////////////////////////////////////
	public void add(){ 
	    // Create an Employee object
		 Employee employee = new Employee();
       
		 
		 try {
			// Read its details
			 if(employee.read()) //If the read is true
				 employees.add(employee); //Add the employee object to the Employee list
			 else //If employee isn't true
				 Employee.decrementNextxNumber(); //Decrement the employee number
		 }//End try
		 catch(NumberFormatException e) {
			 JOptionPane.showMessageDialog(null,"Error, invalid entry.\nYou entered invalid entries into the fields,\nplease try again.", "Error",JOptionPane.ERROR_MESSAGE);
		 }//End catch
	}//End add()

	///////////////////////////////////////////////////////
	// Method Name : list()						              //
	// Return Type : void					   	           //
	// Parameters : None						                 //
	// Purpose : Lists all Employee records in employees //
	///////////////////////////////////////////////////////		
	public void list(){
		String employeesToList="";
		//If the ArrayList is not empty
		if(!employees.isEmpty()) {
			// for every Employee object in employees
			for(Employee tmpEmployee : employees) {
				// add it to employeesToList and
				employeesToList+=tmpEmployee;
				// add a newline
				employeesToList+="\n";
			}//End for each loop
			
			// Display employeesToList in a messageDialog
		   JOptionPane.showMessageDialog(null, employeesToList, "EMPLOYEE LIST", JOptionPane.INFORMATION_MESSAGE);	
		}//End if
		else
			// Display "No Employees stored..." in messageDialog
		   JOptionPane.showMessageDialog(null, "No Employees to list.", "EMPLOYEE LIST", JOptionPane.INFORMATION_MESSAGE);	
	}//End else

	////////////////////////////////////////////////////////////////
	// Method Name : view()									              //
	// Return Type : Employee								              //
	// Parameters : None								                    //
	// Purpose : Displays the required Employee record on screen  //
	//         : And returns it, or null if not found             //   
	////////////////////////////////////////////////////////////////	
	public Employee view(){
		//Constructing new JTextField to take in an Employee number
		JTextField empNumber = new JTextField();
		//Constructing new dialog box
		JDialog dialog = new JDialog();
		dialog.setAlwaysOnTop(true);
		//Creating boolean flag for if the Employee is found
		boolean found = false;
		
		//Creating the message of the dialogue box, including the prompt and text field for the Employee number
		Object[] message = {
				"Enter your employee number:",
				empNumber
				 };
		
		//Storing the option in an integer
		int option = JOptionPane.showConfirmDialog(dialog, message,
				 "Search employee number", JOptionPane.OK_CANCEL_OPTION);
		//Constructing temporary Employee object to store the Employee (if found)
		Employee employeeFound = null;
		if(option == JOptionPane.OK_OPTION) {
			try {
				//Parsing the entered Employee number to an int
				int empNumberInt = Integer.parseInt(empNumber.getText());
				//For each loop to iterate through the ArrayList
				for(Employee e:employees) {
					//If the number of the current Employee is equal to the entered integer
					if(e.getNumber() == empNumberInt) {
						//The Employee is found and stored in the temp Object
						found=true;
						employeeFound = e;
						break;
					}// End if
				}// End for loop
				if(found) {
					//Dialogue box to inform user of successful search, returning the employee
					JOptionPane.showMessageDialog(dialog, employeeFound, " Employee Found",JOptionPane.PLAIN_MESSAGE);
					return employeeFound;
				}// End if
				else {
					//Dialogue box to inform user of unsuccesful search,
					JOptionPane.showMessageDialog(null,"Employee Number: "+empNumberInt+" not found.", "Error",JOptionPane.ERROR_MESSAGE);
				}// End else
			}//End try
			//Catch block to catch any erroneous inputs to the textfield
			catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null,"Error, invalid entry.", "Error",JOptionPane.ERROR_MESSAGE);
			}//End catch
		}// End if
	    //Return null if Employee hasn't been found, they are not present
	    return null;		
	}// End view()
	
	///////////////////////////////////////////////////////////////////
	// Method Name : delete()							        	           //
	// Return Type : void								        	           //
	// Parameters : None									                    //
	// Purpose : Deletes the required Employee record from employees //
	///////////////////////////////////////////////////////////////////	
	public void delete(){
		//Calling view() to find the employee to delete
		Employee empDelete = view();
		if(empDelete != null) { //If the employee returned is not null, they will be in the ArrayList as the view() method returns Employee if they are in the ArrayList
			//Store the index of the found employee in an int
			int empDeleteIndex = employees.indexOf(empDelete);
			//Remove the Employee from the ArrayList
			employees.remove(empDeleteIndex);
			//Displaying a dialogue box to inform the user that the employee was successfully deleted
			JOptionPane.showMessageDialog(null, "Employee number: "+empDelete.getNumber()+"\nDeleted successfully.");
			//We also don't need to reallocate deleted employee numbers so no need to affect nextNumber
		}// End if
	}// End delete()

	///////////////////////////////////////////////////////////////
	// Method Name : edit()			  					                //
	// Return Type : void								    	          //
	// Parameters : None								     	             //
	// Purpose : Edits the required Employee record in employees //
	///////////////////////////////////////////////////////////////	
	public void edit(){
		//Calling the view() to find the employee to edit
		Employee empEdit = view();
		//Creating boolean flag for the do while loop
		boolean goodInput = false;
		if(empEdit != null) { //If the employee is found
			//Do while loop to ensure user enters correct information
			do {
				//Surround risky code in try block
				try {
					empEdit.read(); //Read in new data for that found employee
					goodInput = true;
				}//End try
				//Catch block to handle user entering invalid inputs into the fields
				catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null,"Error, invalid entry.\nYou entered invalid entries into the fields,\nplease try again.", "Error",JOptionPane.ERROR_MESSAGE);
				}//End catch
			}while(!goodInput);
		}//End if
	}// End edit()
	
	
	// This method will serialize the employees ArrayList when called, 
	// i.e. it will write employees to a file called employees.bin
	public void serializeEmployees(){
		//Surrounding risky code in try/catch block
		try {
			//Creating new output stream to store the data in
			FileOutputStream fS = new FileOutputStream(employeesFile);
			
			//Outputting data as object (ArrayList of type employee)
			ObjectOutputStream os = new ObjectOutputStream(fS);
			
			//Writing the object to the employees ArrayList
			os.writeObject(employees);
			
			//Closing the file
			os.close();
		}// End try
		
		//Caught exception for when the file is not found or created
		catch(FileNotFoundException fNFE) {
			System.out.println("File cannot be found.");
		}// End catch
		
		//Caught exception for any input/output exceptions
		catch(IOException ioE) {
			System.out.println("Error inut");
		}// End catch
		
		//Caught exception for all other exceptions
		catch(Exception e){
			System.out.println(e.getMessage());
		}// End catch
	}// End serializeEmployees()

	// This method will deserialize the Employees ArrayList when called, 
	// i.e. it will restore the employees ArrayList from the file employees.bin
	public void deserializeEmployees(){
		try {
			// Deserialize the ArrayList...
			FileInputStream fileStream = new FileInputStream(employeesFile);
		
			ObjectInputStream is = new ObjectInputStream(fileStream);
			
			//Storing the read in objects in the employees ArrayList
			employees = (ArrayList<Employee>)is.readObject();
			
			//Closing the file
			is.close();
			
			//Store the index of the last Employee object
			empIndex = employees.size() -1; 
			//If the index is less than 0, the ArrayList is empty
			if(empIndex < 0)
				System.out.println("Employee arraylist is empty.");
			else
				//Sets the employee number to the last employee number+1
				Employee.setNextNumber(employees.get(empIndex).getNumber());
		}// End try
		
		//Caught exception for file not being created or found
		catch(FileNotFoundException fNFE){
			System.out.println("Cannot create file to store books.");
		}// End catch
		
		//Caught exception for any input/output errors
		catch(IOException ioE){
			 System.out.println("Cannot read from " + FILENAME + ".");
		}// End catch
		
		//Caught exception for all other exceptions
		catch(Exception e){
			System.out.println(e.getMessage());
		}// End catch
	}// End deserializeEmployees()
}// End class
