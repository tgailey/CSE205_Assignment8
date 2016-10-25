// Assignment #: 8
// Arizona State University - CSE205
//         Name: Trenton Gailey
//    StudentID: 1211386693
//      Lecture: Monday Wednesday Friday 9:40 - 10:30
//  Description: Provides a static void that sorts an arraylist of athletes with the 
//				 given comparator using the insertion sort method.


import java.util.*;
public class Sorts {
	public static void insertionSort(ArrayList<Athlete> athletes, Comparator<Athlete> comparator) {
		for (int index = 1; index < athletes.size(); index++)
	      {
	         Athlete keyAthlete = athletes.get(index);
	         int position = index;
	         // shift larger values to the right
	         while (position > 0 && comparator.compare(athletes.get(position - 1), keyAthlete)	> 0)
	         {
		         athletes.set(position,athletes.get(position-1));
	           position--;
	         }

	         athletes.set(position, keyAthlete);
	         
	 	}
	}

}