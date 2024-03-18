/**
* <The purpose of this class is to process the 
* information of the car received from the input file>
*
* CSC 1351 Programming Project No <1>
7
* Section <002>
*
* @author <Nguyen Vu>
* @since <3/17/2024>
*
*/
public class Car implements Comparable<Car> {
	private String make; //this variable will be initialize to represent the make of a car object
	private int year; 	//this variable will be initialize to represent the year of a car object
	private int price; 	//this variable will be initialize to represent the price of a car object
/**
* <This method is the constructor that takes in the make, year, and price of the car
* and then initializing those variables.>
*
* CSC 1351 Programming Project No <1>
* Section <002>
*
* @author <Nguyen Vu>
* @since <3/17/2024>
*
*/
	public Car(String Make, int Year, int Price) {
			this.make = Make;
			this.year = Year;
			this.price = Price;
		}
/**
* <This method is a getter method that return the make of the car object>
*
* CSC 1351 Programming Project No <1>
* Section <002>
*
* @author <Nguyen Vu>
* @since <3/17/2024>
*
*/
	public String getMake() {
			return make;
		}
/**
* <This method is a getter method that return the year of the car object>
*
* CSC 1351 Programming Project No <1>
* Section <002>
*
* @author <Nguyen Vu>
* @since <3/17/2024>
*
*/
	public int getYear() {
			return year;
		}
/**
* <This method is a getter method that return the price of the car object>
*
* CSC 1351 Programming Project No <1>
* Section <002>
*
* @author <Nguyen Vu>
* @since <3/17/2024>
*
*/
	public int getPrice() {
			return price;
		}
/**
* <This method sets up a comparison between two car objects where
* it compares the car's make first and if the make are the same then 
* it compares the car's year.>
*
* CSC 1351 Programming Project No <1>
* Section <002>
*
* @author <Nguyen Vu>
* @since <3/17/2024>
*
*/
	public int compareTo(Car other) {
			if (this.make.equals(other.make)) {
				return Integer.compare(this.price, other.price);
				} 
			else {
				return this.make.compareTo(other.make);
				}
		}
/**
* <This method return a string with the make, year, and price of the car object>
*
* CSC 1351 Programming Project No <1>
* Section <002>
*
* @author <Nguyen Vu>
* @since <3/17/2024>
*
*/
	public String toString() {
			return ("Make: " + this.make + ", Year : " + this.year + ", Price: " + this.price + ";");
		}
}
