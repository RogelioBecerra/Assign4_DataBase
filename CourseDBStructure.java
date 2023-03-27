import java.io.IOException;
import java.util.ArrayList;

/**
 * the CourseDBStructure class
 * @author rogeliobecerra
 *
 */
public class CourseDBStructure implements CourseDBStructureInterface {

	int numOfEle = 0;
	CourseDBElement[] table;
	
	
	/**
	 * testing constructor 
	 * @param string - Not specified what the use of the string is for
	 * @param size - estimated size of array
	 */
	public CourseDBStructure(String string, int size) {  // **** what is the string for?   + ++ + ++ ++ +
		//determines the size 
		int num1 = (int)(size/1.5);
		int tableSize = 0;				
		int counter = 1;
				
		while(tableSize < num1) {
			tableSize = (4*counter)+3;
			counter++;
		}
				
		while(!(primeNum(tableSize))) {
			tableSize = (4*counter)+3;
			counter++;
		}
				
		table =  new CourseDBElement[tableSize];
		
	}

	/**
	 * constructor 
	 * @param size - estimated size of array
	 */
	public CourseDBStructure(int size) {
		
		//determines the size 
		int num1 = (int)(size/1.5);
		int tableSize = 0;				
		int counter = 1;
		
		while(tableSize < num1) {
			tableSize = (4*counter)+3;
			counter++;
		}
		
		while(!(primeNum(tableSize))) {
			tableSize = (4*counter)+3;
			counter++;
		}
		
		//sets table size
		table =  new CourseDBElement[tableSize];
	}


	/**
	 * checks if a number is a prime number 
	 * @param num - value to be checked 
	 * @return true if is prime, false if not prime
	 */
	public boolean primeNum(int num) {
		
		if(num <=1)
			return false;
		
		for(int i = 2; i < num; i++) {
			if(num%i == 0)
				return false;
		}
		return true;
		
	}
	
	@Override
	public void add(CourseDBElement element) {
		//find index
		String crnVal = Integer.toString(element.crn);
		int crnHash = crnVal.hashCode();
		int eleIndex = crnHash % table.length;
		
		//if bucket is empty
		if(table[eleIndex] == null)
		{
			table[eleIndex] = element;
		}
		//if bucket is NOT empty
		else if(table[eleIndex] != null) 
		{
			CourseDBElement temp = table[eleIndex];
			while(temp!= null)
			{
				//find matching CRN
				if(temp.crn == element.crn )   
				{
					//if the same do not add 
					if(temp.compareTo(element) == 0)
						return;
					//if bit different but same CRN
					else
					{
						//Replace at Start
						if(table[eleIndex].compareTo(temp) == 0)
						{
							element.next = table[eleIndex].next;
							table[eleIndex] = element;
						}
						//Replace at End
						else if(temp.next == null)
						{
							CourseDBElement temp2 = table[eleIndex];
							while(temp2.next.next != null)
							{
								temp2 = temp2.next;
							}
							temp2.next = element;
						}
						//Replace element from in-between other elements
						else
						{
							CourseDBElement temp3 = table[eleIndex];
							while(temp3.next != temp)
							{
								temp3 = temp3.next;
							}
							element.next = temp.next;
							temp3.next = element;
						}
									
					}
				}
				temp = temp.next;
			}
			temp = element;
		}
		numOfEle++;
	}

	
	@Override
	public CourseDBElement get(int crn) throws IOException {
		
		//find index value
		String crnVal = Integer.toString(crn);
		int crnHash = crnVal.hashCode();
		int eleIndex = crnHash % table.length;
		
		CourseDBElement temp = table[eleIndex];
		while(temp!= null) 
		{
			
			if(temp.crn == crn ) 
			{
					return temp;
			}
				
			temp = temp.next;
		}
	
		throw new IOException();
	}

	
	
	

	@Override
	public ArrayList<String> showAll() {
		
		ArrayList<String> al = new ArrayList<>();
		
		for(int i =0; i < table.length;i++)
		{
			if(table[i] != null)
			{
				CourseDBElement temp = table[i];
				while(temp!= null)
				{
	
					al.add("Course:" + temp.courseID + " CRN:" + temp.crn + " Credits:" + temp.credits + " Instructor:" + temp.instructorName + " Room:" + temp.roomNum);
					temp = temp.next;
				}
			}
		}
		
		return al;
	}

	@Override
	public int getTableSize() {
		return table.length;
	}

}
