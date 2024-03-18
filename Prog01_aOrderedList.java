import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;
/**
* <The purpose of this class to act as the driver class for the other 
* two classes and take in user input for the input file to read from 
* and the output file to write into>
*
* CSC 1351 Programming Project No <1>
7
* Section <002>
*
* @author <Nguyen Vu>
* @since <3/17/2024>
*
*/
public class Prog01_aOrderedList {
/**
* <This method is the main method of the program where it scan the input file, instantiating
* the aOrderList, and sets up a Printwriter to populate the output file. Each line in the input
* file becomes a string where it then splits into substrings by the comma delimiter where we can
* then add or delete a car object based on the first substring.>
*
* CSC 1351 Programming Project No <1>
* Section <002>
*
* @author <Nguyen Vu>
* @since <3/17/2024>
*
*/
	public static void main(String[] args) throws FileNotFoundException {
			Scanner scanner = GetInputFile("Enter input filename: ");
			aOrderedList aOrderedList = new aOrderedList();
			while(scanner.hasNextLine()) {
				String CarInfo = scanner.nextLine(); 
				String[] CarString = CarInfo.split(",");
				if (CarString[0].equals("A")) {
					String make = CarString[1]; //This variable represents the make taken 
												//from the substring
					int year = Integer.parseInt(CarString[2]);//This variable represents the year taken 
															  //from the substring
					int price = Integer.parseInt(CarString[3]);//This variable represents the price taken 
															   //from the substring
					Car carobject = new Car(make, year, price);
					aOrderedList.add(carobject);
					}
				else if (CarString[0].equals("D")) {
					if (isInteger(CarString[1])) {
						int index = Integer.parseInt(CarString[1]); //This variable represents the index taken 
																	//from the substring
						aOrderedList.remove(index);
						}
					else {
						String make = CarString[1];	//This variable represents the make taken 
													//from the substring
						int year = Integer.parseInt(CarString[2]);  //This variable represents the year taken 
																	//from the substring
						aOrderedList.remove(make, year);
						}
					}
				}
			scanner.close();
			PrintWriter write = GetOutputFile("Enter output filename: ");
			write.println("Number of cars: " + aOrderedList.size());
			for(int i = 0; i < aOrderedList.size();i++) {
				write.println("\n");
				Comparable carInfo = aOrderedList.get(i); 
				if (carInfo != null) {
				Car car = (Car) carInfo;
				write.printf("Make:\t%s\nYear:\t%d\nPrice:\t$%,d", car.getMake(), car.getYear(), car.getPrice());	
					}
				}
	        write.close();	
			}
/**
* <This method checks if the string can be turn into an integer or not 
* and return a true or false accordingly>
*
* CSC 1351 Programming Project No <1>
* Section <002>
*
* @author <Nguyen Vu>
* @since <3/17/2024>
* 
*/
public static boolean isInteger(String str) {
	try {
		 	Integer.parseInt(str); 
		 	return true; 
			}
	catch (NumberFormatException e) {
			return false;
			}
	}
/**
* <This method ask the user for the name of the input file, instantiating the file, 
* and then checks if the input file exist or not. It will then notify the user if the 
* they want to try again or cancel. Once a valid input file is given, it return a scanner
* that reads the input file.>
*
* CSC 1351 Programming Project No <1>
* Section <002>
*
* @author <Nguyen Vu>
* @since <3/17/2024>
* 
*/
public static Scanner GetInputFile(String UserPrompt) throws FileNotFoundException {
	Scanner input = new Scanner(System.in);
	while (true) {
			System.out.println(UserPrompt);
			String filename = input.nextLine();
			File inputFile = new File(filename);
			if (!inputFile.exists()) {
				System.out.println("File specified <" + filename + "> does not exist. Would you like to continue? <Y/N>");
				String YN = input.nextLine(); 
				if (YN.equals("N")) {
					input.close();
					throw new FileNotFoundException();
					}
				else if (YN.equals("Y")) {
					continue; 
					}
				}
			else {
				return new Scanner(inputFile);
				}
			}
	}
/**
* <This method ask the user for the name of the output file, instantiating the file, 
* and then checks if the output file exist or not. It will then notify the user if the 
* they want to try again or cancel. Once a valid output file is given, it return a Printwriter
* that will populate the output file.>
*
* CSC 1351 Programming Project No <1>
* Section <002>
*
* @author <Nguyen Vu>
* @since <3/17/2024>
* 
*/
public static PrintWriter GetOutputFile(String UserPrompt) throws FileNotFoundException {
	Scanner output = new Scanner(System.in);
	while (true) {
			System.out.println(UserPrompt);
			String outfilename = output.nextLine();
			File outFile = new File(outfilename);
			if (!outFile.exists()) {
				System.out.println("File specified <" + outFile + "> does not exist. Would you like to continue? <Y/N>");
				String YN2 = output.nextLine();
				if (YN2.equals("N")) {
					output.close();
					throw new FileNotFoundException();
					}
				else if (YN2.equals("Y")) {
					continue; 
					}
				}
			else {
				return new PrintWriter(outFile);
				}
			}
	}
}