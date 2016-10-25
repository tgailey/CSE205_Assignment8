// Assignment #: 8
// Arizona State University - CSE205
//         Name: Trenton Gailey
//    StudentID: 1211386693
//      Lecture: Monday Wednesday Friday 9:40 - 10:30
//  Description: This class is used as a Comparator that compares two athletes by
//				 their names. If the first athlete comes after the second athlete, 
//				 it returns a positive # of the letter difference using Strings 
//				 compareTo method. If the second athlete comes after the first athlete, 
//				 it returns a negative # of the letter difference using Strings 
//				 compareTo method. If the names are the same, returns 0.
//				 First compares last names, if they are =, then compares first names.


import java.util.*;
public class AthleteNameComparator implements Comparator<Athlete> {
	public int compare(Athlete first, Athlete second) {
		if (first.getLastName().compareTo(second.getLastName()) != 0) {
			return first.getLastName().compareTo(second.getLastName());
		}
		else {
			return first.getFirstName().compareTo(second.getFirstName());
		}
	}
}
