import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.PrintWriter;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CourseDBManager_STUDENT_Test {
	private CourseDBManagerInterface Mgr = new CourseDBManager();
	
	@BeforeEach
	void setUp() throws Exception {
		Mgr = new CourseDBManager();
	}

	@AfterEach
	void tearDown() throws Exception {
		Mgr = null;
	}

	
	
	@Test
	public void testRead() {
		try {
			File inputFile = new File("Test.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("CMSC222 12345 2 SC450 bob Donuts");
			inFile.print("LOL204 54321 3 OK777 jelly butter");
			
			inFile.close();
			Mgr.readFile(inputFile);
			assertEquals("CMSC222",Mgr.get(12345).getID());
			assertEquals("LOL204",Mgr.get(54321).getID());
			assertEquals("OK777",Mgr.get(54321).getRoomNum());
		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}
	
	
	@Test
	public void testAddToDB() {
		try {
			Mgr.add("FFF240",22222,4,"LP450","Joe Diax");
			Mgr.add("GG240",99999,4,"RG000","shake shack");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}

}




