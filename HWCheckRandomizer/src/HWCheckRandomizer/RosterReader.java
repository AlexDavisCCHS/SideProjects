package HWCheckRandomizer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class RosterReader {
	private String fileName;
	private String subject;
	private String period;
	private ArrayList <String> studentList = new ArrayList <String>();
	
	public RosterReader() {
		this.fileName = "test_read.txt";
		this.subject = "";
		this.period = "";
	}
	
	public RosterReader(String fileName , String subject , int period) {
		this.fileName = fileName;
		this.subject = subject;
		this.period = Integer.toString(period);
	}
	
	
	
	public ArrayList<String> getStudentList()
			  throws IOException {
			    String file = "src/" + fileName;
			    BufferedReader reader = new BufferedReader(new FileReader(file));
			    //StringBuilder builder = new StringBuilder();
			    String currentLine = reader.readLine();
			    int studentNameIndex;
			    while (currentLine != null) {
			    	if (currentLine.contains(subject) && currentLine.contains("Pd:," + period)){
			    		currentLine = reader.readLine();
			    		currentLine = reader.readLine();
			    		studentNameIndex = currentLine.indexOf("\"");
			    		while (studentNameIndex != -1) {
			    			studentList.add(currentLine.substring(studentNameIndex+1, currentLine.indexOf("\"" , studentNameIndex+1)));
			    		
			    		//builder.append(currentLine);
			    		//builder.append("\n");
			    		currentLine = reader.readLine();
			    		studentNameIndex = currentLine.indexOf("\"");
			    		}//end while studentName
			    	}//end if
			    	currentLine = reader.readLine();
			    }//end while 
			    reader.close();
			    return studentList;
			}//end method

}//end class
