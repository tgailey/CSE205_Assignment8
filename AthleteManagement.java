// Assignment #: 8
// Arizona State University - CSE205
//         Name: Trenton Gailey
//    StudentID: 1211386693
//      Lecture: Monday Wednesday Friday 9:40 - 10:30
//  Description: Provides all the management options of the athletes that will be 
//				 in Assignment8 class. It creates an arrayList of athletes that will
//				 be able to be manipulated. This class can do the following:
//					Tell if the athlete already exists in the system (and return index)
//					Count the number of athletes that have a certain medal
//					Add an athlete to the list with given information
//					Remove an athlete by name provided
//					Sort the list by name and by medal count
//					List the athletes in the list
//					Clear all athletes from the list

import java.util.*;
public class AthleteManagement implements java.io.Serializable {
	private ArrayList<Athlete> athleteList;
	public AthleteManagement() {
		athleteList = new ArrayList<Athlete>();
	}
	public int athleteNameExists(String firstName, String lastName) {
		int temp = -1;
		//Transverses the arrayList checking if any index has same last + first name
		for (int i = 0; i < athleteList.size(); i++) {
			if (athleteList.get(i).getLastName().compareTo(lastName) == 0) {
				if (athleteList.get(i).getFirstName().compareTo(firstName) == 0) {
					//if both first and last names equal, return the index
					temp = i;
				}
			}
		}
		return temp;
	}
	public int countHowManyAthletesHaveMedals(int medalType) {
		int count = 0;
		//Transverse the list to check every athlete in list
		for (int i = 0; i < athleteList.size(); i++) {
			//If gold is specified, add count for every athlete that has gold medal
			if (medalType == 0) {
				if (athleteList.get(i).getGold() > 0) {
					count++;
				}
			} 
			//If silver is specified +1 count for every athlete that has silver medal
			else if (medalType == 1) {
				if (athleteList.get(i).getSilver() > 0) {
					count++;
				}
			} 
			//If bronze is specified +1 count for every athlete that has bronze medal
			else if (medalType == 2) {
				if (athleteList.get(i).getBronze() > 0) {
					count++;
				}
			}
		}
		return count;
	}
	public boolean addAthlete(String firstName, String lastName, String sport, int gold, int silver, int bronze) {
		//If the athlete doesn't already exist, create a new athlete with info given
		if (athleteNameExists(firstName, lastName) == -1) {
			Athlete temp = new Athlete();
			temp.setFirstName(firstName);
			temp.setLastName(lastName);
			temp.setSport(sport);
			temp.setGold(gold);
			temp.setSilver(silver);
			temp.setBronze(bronze);
			athleteList.add(temp);
			//return true to signify an athlete added
			return true;
		}
		else {
			//return false to signify the athlete already exists
			return false;
		}
	}
	public boolean removeAthleteByName(String firstName, String lastName) {
		//if athlete exists, remove it at the index and return true
		if (athleteNameExists(firstName, lastName) != -1) {
			athleteList.remove(athleteNameExists(firstName, lastName));
			return true;
		}
		//Else return false to signify that the athlete does not exist
		else {
			return false;
		}
	}
	public void sortByAthleteNames() {
		//Sort list with the AthleteNameComparator
		AthleteNameComparator nameComparator = new AthleteNameComparator();
		Sorts.insertionSort(athleteList, nameComparator);
	}
	public void sortByMedalCounts() {
		//Sort list with the MedalCountComparator
		MedalCountComparator medalComparator = new MedalCountComparator();
		Sorts.insertionSort(athleteList, medalComparator);
	}
	public String listAthletes() {
		//If no athletes are in the list, return no athlete
		if (athleteList.size() == 0) {
			return  "\nno athlete\n\n";
		}
		//Else, list all the athletes using athlete's toString() method
		else {
			String temp = "\n";
			for (int i = 0; i < athleteList.size(); i++) {
				temp += athleteList.get(i).toString();
			}
			temp += "\n";
			return temp;
		}
	}
	public void closeAthleteManagement() {
		//Clear the list
		athleteList.clear();
	}
}
