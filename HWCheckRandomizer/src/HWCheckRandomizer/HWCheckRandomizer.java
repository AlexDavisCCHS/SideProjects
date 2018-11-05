package HWCheckRandomizer;

import java.io.IOException;
import java.util.ArrayList;

public class HWCheckRandomizer {
	public static void main(String[] args) throws IOException {
		String nextVictim;
		boolean used = false;
		RosterReader test = new RosterReader("ClassList2018.txt" , "Prin" , 2);
		ArrayList <String> list = test.getStudentList();
		int[] nextVictimIndexRecord = new int[list.size()];
		for (int index = 0; index < list.size(); index++) {
			nextVictimIndexRecord[index] = (int)(Math.random()*(list.size()));
			for (int checker = index-1; checker >= 0; checker--) {
				if (nextVictimIndexRecord[index] == nextVictimIndexRecord[checker]) {
					used = true;
					break;
				}//end if
			}//end for checker
			if (used) {
				index--;
				used = false;
			}//end if used
			else {
				nextVictim = ((index+1) + " " + list.get(nextVictimIndexRecord[index]));
				if (list.get(nextVictimIndexRecord[index]).equals("Berliner, Isabel") || list.get(nextVictimIndexRecord[index]).equals("Marcus, Oliver") || list.get(nextVictimIndexRecord[index]).equals("Hernandez, Marilyn")) {
					nextVictim += " completed!";
				}//end if done
				System.out.println(nextVictim);
			}//end else
		}//end for

	}//end main

}//end class
