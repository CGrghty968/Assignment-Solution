package ie.atu.hotel;

//Interface has abstract methods, methods without a body
//Doesn't have constructors or instance variables
//It can have constants
public interface Payable {
	//What employee CAN DO
	double calculatePay(double taxPercentage);
	double incrementSalary(double incrementAmount);
}//End interface
