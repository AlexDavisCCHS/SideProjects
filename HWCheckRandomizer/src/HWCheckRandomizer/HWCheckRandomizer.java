package HWCheckRandomizer;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class HWCheckRandomizer {
	public static void main(String[] args) throws IOException {
		String nextVictim;
		boolean used = false;
		String[] possibleClasses = {"AP Comp Sci period 3" , "Ap Comp Sci period 4"};
		String className = (String) JOptionPane.showInputDialog(null,
	             "Choose one", "Input",
	             JOptionPane.QUESTION_MESSAGE, null,
	             possibleClasses, possibleClasses[0]);
		RosterReader test = new RosterReader("ClassList2018.txt" , "AP Comp Sci" , 4);
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
				System.out.println(nextVictim);
			}//end else
		}//end for

	}//end main

}//end class
