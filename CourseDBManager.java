import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * The CourseDBManagerInterface class
 * @author rogeliobecerra
 *
 */
public class CourseDBManager implements CourseDBManagerInterface {

	CourseDBStructure dbs = new CourseDBStructure(20);
	
	
	
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
        dbs.add(new CourseDBElement(id,crn,credits,roomNum,instructor));
	}
	
	
	@Override
	public CourseDBElement get(int crn) throws IOException {
		return dbs.get(crn);
	}

	@Override
	public void readFile(File input) throws FileNotFoundException {
		
		//Reads the information of courses from a test file and adds them to the CourseDBStructure data structure
	
		try {
			FileReader reader = new FileReader(input);
			
			Scanner sc = new Scanner(reader);
			
			while(sc.hasNextLine()) {
				
				String id = sc.next();
				
				int crn = Integer.parseInt(sc.next());
				
				int cred = Integer.parseInt(sc.next());
				
				String room = sc.next();
				
				String tempInst = sc.nextLine();
				String inst = "";
				for(int i = 0; i < tempInst.length()-1;i++)
				{
					inst += tempInst.charAt(i+1);
				}
				
				dbs.add(new CourseDBElement(id,crn,cred,room,inst));
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}

	@Override
	public ArrayList<String> showAll() {
		
		return dbs.showAll();
	}

}
