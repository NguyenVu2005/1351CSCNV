import java.util.Arrays;
import java.util.NoSuchElementException;
/**
* <The purpose of this class is to create an array to store car objects 
* received from the input file by either adding or deleting them from the 
* array list>
*
* CSC 1351 Programming Project No <1>
7
* Section <002>
*
* @author <Nguyen Vu>
* @since <3/17/2024>
*
*/
public class aOrderedList {
	final int SIZEINCREMENTS = 20;	//This variable is used to increase the size of the array 
	private Comparable [] oList;   //This variable sets up the array called oList
	private int listSize; 		   //This variable is initialize to represent the size of the oList
	private int numObjects; 	   //This variable is initialized to represent the number 
								   //of existing objects in the array
	private int curr; 			   //This variable is initialized to represent the current 
								   //iteration value
	private Comparable Element;	   //This variable is initialized to represent the current 
								   //element in the iteration after the next() method
/**
* <This method is the constructor for the class and initialized the class 
* variables>
*
* CSC 1351 Programming Project No <1>
* Section <002>
*
* @author <Nguyen Vu>
* @since <3/17/2024>
*
*/
	public aOrderedList() {
			this.numObjects = 0;
			this.listSize = this.SIZEINCREMENTS;
			this.oList = new Comparable[this.listSize];
			this.curr = -1;
			this.Element = null;
			}
/**
* <This method is how we can add an object received from the input file to
* the array. Here, the object is added by comparing the objects within the 
* array to the new object until the method come across the index that an object is 
* greater than the new object. Then the method shift all the objects greater than 
* the new object to the right and insert the new object, increasing array 
* size accordingly if needed>
*
* CSC 1351 Programming Project No <1>
* Section <002>
*
* @author <Nguyen Vu>
* @since <3/17/2024>
*
*/
	public void add(Comparable newObject) {
			if (this.numObjects == this.listSize) {
				this.listSize += this.SIZEINCREMENTS;
				Comparable[] newoList = Arrays.copyOf(oList, this.listSize);
				this.oList = newoList;
				}
			int found = this.numObjects; //This variable is used so that it first represent the 
										//number of objects in the array so that the for loop 
										//can start at numbObjects - 1 and later represent the 
										//index to insert the new object
			for (int i = found - 1; i >= 0; i--) {
				if(oList[i] != null && (this.oList[i].compareTo(newObject)>=0)) {	
					this.oList[i+1] = oList [i];
					found = i;
				}
			}
			this.oList[found] = newObject;
			this.numObjects++;
		}
/**
* <This method creates the structure to display the object information
* from the array by calling upon the StringBuilder object.>
*
* CSC 1351 Programming Project No <1>
* Section <002>
*
* @author <Nguyen Vu>
* @since <3/17/2024>
*
*/
	public String toString() {
			StringBuilder format = new StringBuilder();
			format.append("[");
			for (int i = 0; i < this.numObjects;i++) {
				format.append(this.oList[i].toString());
				if (i< this.numObjects - 1) {
					format.append(", ");
				}
			}
			format.append("]");
			return format.toString();
		}
/**
* <This method returns the number of elements in the array>
*
* CSC 1351 Programming Project No <1>
* Section <002>
*
* @author <Nguyen Vu>
* @since <3/17/2024>
*
*/
	public int size() {
			return this.numObjects;
		}
/**
* <This method return the element at the specifically
* provided index in the array>
*
* CSC 1351 Programming Project No <1>
* Section <002>
*
* @author <Nguyen Vu>
* @since <3/17/2024>
*
*/
	public Comparable get(int index) {
			return this.oList[index];
		}
/**
* <This method checks if the array has any element in it or not 
* and return a true or false>
*
* CSC 1351 Programming Project No <1>
* Section <002>
*
* @author <Nguyen Vu>
* @since <3/17/2024>
*
*/
	public boolean isEmpty() {
			if (this.numObjects == 0) {
				return true;
			}
			else {
				return false;
			}
		}
/**
* <This method removes an element from the array at the given index provided 
* from the input file by moving the elements to the right of the given index 
* over to the left. Then the method resize the array so that the array has as 
* much space as the number of objects that exist. Throw an out of bound exception
* if the provided index is invalid.>
*
* CSC 1351 Programming Project No <1>
* Section <002>
*
* @author <Nguyen Vu>
* @since <3/17/2024>
*
*/
	public void remove(int index) {
			if(index<0||index >=numObjects) {
				throw new IndexOutOfBoundsException();
			}
			else {
				for (int i = index; i < this.numObjects-1;i++) {
					this.oList[i] = this.oList[i+1];
					}
				this.numObjects--;
				this.listSize = this.numObjects;
				Comparable[]dinewoList = Arrays.copyOf(oList, this.listSize);
				this.oList = dinewoList;
			}
		}
/**
* <This method is almost exactly like the last method but with an extra step 
* where the method takes in the make and year of the car object and searches 
* the array until it finds an object that matches the information to take its
* index from. From there, the method use that index to shift elements to the 
* left and resize the array afterward>
*
* CSC 1351 Programming Project No <1>
* Section <002>
*
* @author <Nguyen Vu>
* @since <3/17/2024>
*
*/
	public void remove(String make, int year) {
		 	int index = -1; //This variable initialize the index to be updated and used to remove 
		 					//the object in the array at that index
			for (int i = 0; i < numObjects; i++) {	
				if (oList[i] != null && ((Car) this.oList[i]).getMake().equals(make) && ((Car) this.oList[i]).getYear()== year ) {
		 			index = i;
		 			break;
					}
			 }
				if(index !=-1) {
			 		for (int j = index; j < this.numObjects-1;j++) {
			 			this.oList[j] = this.oList[j+1];
					 }
			 	this.numObjects--;
			 	this.listSize = this.numObjects;
			 	Comparable[]dnewoList = Arrays.copyOf(oList, this.listSize);
			 	this.oList = dnewoList;
				}
	 	}
/**
* <This method basically just reset the iterator so that it starts right
* before the first element>
*
* CSC 1351 Programming Project No <1>
* Section <002>
*
* @author <Nguyen Vu>
* @since <3/17/2024>
*
*/
	 public void reset() {
		 	this.curr = -1;
	 	}
/**	
* <This method the next element in the iteration and increment the value.
* Throw a No such element exception if there is no more element that is next.>
*
* CSC 1351 Programming Project No <1>
* Section <002>
*
* @author <Nguyen Vu>
* @since <3/17/2024>
*
*/
	 public Comparable next() {
		 	if (!hasNext()) {
		 		throw new NoSuchElementException(); 
		 	}
		 	else {
		 		this.Element = this.oList[this.curr++];
		 		return this.Element;
		 	}
	 	}
/**
* <This method checks if there is a next element in the array by comparing
* iteration to the number of available objects and return a true or false>
*
* CSC 1351 Programming Project No <1>
* Section <002>
*
* @author <Nguyen Vu>
* @since <3/17/2024>
*
*/
	 public boolean hasNext() {
		 if (this.curr < this.numObjects) {
				return true;
			}
			else {
				return false;
			}
	 	}
/**
* <This method works the same as the other remove method but in the case
* that it searches the index of the current iteration element. Then it
* starts at that index to move the rest of the elements to left and resize
* the array. At the end, it change the value of the of the last returned 
* element from the next() method to nothing again.>
*
* CSC 1351 Programming Project No <1>
* Section <002>
*
* @author <Nguyen Vu>
* @since <3/17/2024>
*
*/
	 public void remove() {
		 int index = -1;   //This variable initialize the index to be updated and used to remove 
						   //the object in the array at that index
			for (int i = 0; i < numObjects; i++) {	
				if (oList[i] != null && oList[i].equals(this.Element)) {
		 			index = i;
		 			break;
					}
			 }
				if(index !=-1) {
			 		for (int j = index; j < this.numObjects-1;j++) {
			 			this.oList[j] = this.oList[j+1];
			 		}
			 	this.numObjects--;
			 	this.curr--;
		 		this.listSize = this.numObjects;
		 		Comparable[]inewoList = Arrays.copyOf(oList, this.listSize);
		 		this.oList = inewoList;
		 		this.Element = null;
				}
	 	}
}
