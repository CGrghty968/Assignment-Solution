package ie.atu.hotel;

import java.awt.Dimension;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

//Employee inherits Serializable from Person class
public class Employee extends Person implements Payable, Serializable { 
	//Inherits the phone number and name from Person class
//	private Date dob; //Composition, Employee HAS-A "Date" of birth
	private Date startDate;
	private double salary;
	private int number;
	
	final double MAXSALARY = 150000;
	
	public static void setNextNumber(int newNumber) {
		nextNumber=(newNumber+1);
	}//end setNextNumber
	
	public static void decrementNextxNumber() {
		nextNumber--;
	}//Method to allow the decrementing of the employee number in case of false read()
	
	private static int nextNumber = 10000; //Our incremental number
	
	public Employee() {
		super();
//		dob = new Date();
//		startDate = new Date();
		salary = 0.0;
		number = nextNumber++;
	}//End default constructor
	
	public Employee(Name name, String phN, Date dob, Date startDate, double salary) {
		super(name, phN);
//		this.dob = dob;
		this.startDate = startDate;
		this.salary = salary;
		this.number = nextNumber++;
	}//End overloaded constructor
	
	
	//Accessors and Mutators
//	public Date getDob() {
//		return dob;
//	}//End getDob()

//	public void setDob(Date dob) {
//		this.dob = dob;
//	}//End setDob()

	public Date getStartDate() {
		return startDate;
	}//End getStartDate()

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}//End setStartDate()

	public double getSalary() {
		return salary;
	}//End getSalary()

	public void setSalary(double salary) {
		this.salary = salary;
	}//End setSalary()

	public int getNumber() {
		return number;
	}//End getNumber()

	@Override
	public String toString() {
		return number+"\t"+ name+"\t€"+String.format("%.2f", salary); 
	}//End toString()
	
	@Override
	public boolean equals(Object obj) {
		Employee e;
		if(obj instanceof Employee)
			e = (Employee)obj;
		else
			return false;
		
		return this.number == e.number; //Both employee numbers will have to be the same for them to equal
	}// End equals()	
	
	
	@Override
	public double calculatePay(double taxPercentage) {
		//salary/12 less taxPercentage
		double pay = salary/12;
		pay -= (pay * (taxPercentage/100));
		return pay;
	}// End calculatePay()

	@Override
	public double incrementSalary(double incrementAmount) {
		salary+=incrementAmount;
		
		if(salary > MAXSALARY)
			salary=MAXSALARY; //Salary can't be above 150000 so cap it at that
		
		return salary;
	}// End incrementSalary()
	
	
	public boolean read() {
		//Constructing a ComboBox object of String objects
	JComboBox<String> cbTitle = new JComboBox<String>();
		//Adding all the titles for the ComboBox
	cbTitle.addItem("Mr");
	cbTitle.addItem("Ms");
	cbTitle.addItem("Mrs");
	cbTitle.addItem("Miss");
	JTextField txtFirstName = new JTextField();
	JTextField txtSurname = new JTextField();
	JTextField txtPhoneNumber = new JTextField();
	JTextField txtEmpNo = new JTextField();
	txtEmpNo.setText(Integer.toString(number));
	txtEmpNo.setEditable(false);
	JTextField txtSalary = new JTextField();
	 
	
	 
	 Object[] message = {
	 "EmpNo:", txtEmpNo,
	 "Title:", cbTitle,
	 "First Name:", txtFirstName,
	 "Surname", txtSurname,
	 "Phone Number:", txtPhoneNumber,
	 "Salary:", txtSalary
	 };
	 
	 JDialog dialog = new JDialog();
	 dialog.setAlwaysOnTop(true);
	 int option = JOptionPane.showConfirmDialog(dialog, message,
	 "ENTER EMPLOYEE DETAILS", JOptionPane.OK_CANCEL_OPTION);
	 if (option == JOptionPane.OK_OPTION){
		 //Casting the selected ComboBox item to String
	this.name.setTitle((String) cbTitle.getSelectedItem());
	this.name.setFName(txtFirstName.getText());
	this.name.setSName(txtSurname.getText());
	this.phoneNumber=txtPhoneNumber.getText();
	this.salary=Double.parseDouble(txtSalary.getText());
	return true;
	 }// End if
	 else // CANCEL_OPTION
	return false;
	}// End else

}//End class