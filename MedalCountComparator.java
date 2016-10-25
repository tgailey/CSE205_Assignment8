// Assignment #: 8
// Arizona State University - CSE205
//         Name: Trenton Gailey
//    StudentID: 1211386693
//      Lecture: Monday Wednesday Friday 9:40 - 10:30
//  Description: This class is used as a Comparator that compares two athletes by
//				 their medal count. First it compares their gold medals, then silver,
//				 then bronze. If all medals are equal, it returns 0. If the first 
//				 athlete has less than the second athlete, returns positive. If the
//				 first athlete has more than the second athlete, returns negative.
import java.util.*;
public class MedalCountComparator implements Comparator<Athlete> {
	public int compare(Athlete first, Athlete second) {
		int temp = 0;
		if (first.getGold() != second.getGold()) {
			//Return the difference
			temp = second.getGold() - first.getGold();
		}
		else if (first.getSilver() != second.getSilver()) {
				//Return the difference
				temp = second.getSilver() - first.getSilver();
		}
		else if (first.getBronze() > second.getBronze()) {
					//Return the difference
					temp = second.getBronze() - first.getBronze();
		}
		return temp;
	}
}
