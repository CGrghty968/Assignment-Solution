package ie.atu.tester;

import java.util.ArrayList;

import ie.atu.hotel.Date;
import ie.atu.hotel.Employee;
import ie.atu.hotel.Name;

public class EmployeeTester {
	public static void main(String[] args) {
		//Create ArrayList of type Employee called employees
		ArrayList<Employee> employees = new ArrayList<Employee>();
		
		//Add 3 employees to the ArrayList
		Name name = new Name("Ms", "Faye", "McGuire");
		Employee e1 = new Employee(name, "087 1234567",
				new Date(7,12,2000), new Date(12,10,2020), 24000.00);
		
		name = new Name("Mr", "Ben", "Carson");
		Employee e2 = new Employee(name, "086 1234567",
				new Date(20,10,1980), new Date(10,10,2012), 42000.00);
		
		name  = new Name("Mr", "Mark", "Logan");
		Employee e3 = new Employee(name, "087 9876543",
				new Date(1,1,1994), new Date(2,8,2018), 28000.00);
		
		employees.add(e3);
		employees.add(e2);
		employees.add(e1);
		
		for(Employee e: employees) {
			System.out.println(e);
			if(e.getSalary() < 30000)
				e.incrementSalary(1000);
			System.out.println("\n"+e);
		}
		
		
		
	}//End main
}//End class
