/**
 * The CourseDBElement class
 * @author rogeliobecerra
 *
 */
public class CourseDBElement implements Comparable<CourseDBElement> {
	
	//Fields
	String courseID;
	int crn;
	int credits;
	String roomNum;
	String instructorName;
	
	CourseDBElement next = null; 
	
	/**
	 * constructor
	 * @param courseID - the course ID
	 * @param crn - the course CRN
	 * @param credit - the course credit
	 * @param room - the course room
	 * @param instructor - the course instructor
	 */
	public CourseDBElement(String courseID, int crn, int credit, String room, String instructor) {
		this.courseID = courseID;
		this.crn = crn;
		this.credits = credit;
		this.roomNum = room;
		this.instructorName = instructor;
	}

	/**
	 * Default constructor
	 */
	public CourseDBElement() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Compare CourseDBElement objects
	 */
	@Override
	public int compareTo(CourseDBElement obj) {
		
		if(courseID.equals(obj.courseID) && (crn == obj.crn) && (credits == obj.credits) && roomNum.equals(obj.roomNum) && instructorName.equals(obj.instructorName) )
		{
			return 0;
		}
		
		return 1;
	}

	/**
	 * returns course CRN
	 * @return crn
	 */
	public int getCRN() {
		return crn;
	}

	/**
	 * returns course id
	 * @return courseID
	 */
	public Object getID() {
		return courseID;
	}

	/**
	 * returns room 
	 * @return room number 
	 */
	public Object getRoomNum() {
		
		return roomNum;
	}

	/**
	 * From FXMainPane 
	 * @param parseInt set CRN
	 */
	public void setCRN(int parseInt) {
		
		
	}
	
	

}
