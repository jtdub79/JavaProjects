/**
 * 
 */
package studentDatabaseApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Jim Westfall
 *
 */
public class School {
	
	public enum Courses{
		Hist101("History 101"),
		Math101("Mathematics 101"),
		Eng101("English 101"),
		Chem101("Chemistry 101"),
		CS101("Computer Science 101");
		
		private String longName;
		
		Courses(String longName){
			this.longName = longName;
		}
		
		public String getLongName() {
			return this.longName;
		}
	}
	
	private static float costPerClass = 600f;
	
	private List<Student> students = new ArrayList<Student>();
	
	// Constructors
	public School() {
		this.addStudents();
	}

	/**
	 * @return the students
	 */
	public List<Student> getStudents() {
		return students;
	} 
	
	/**
	 * @return the costPerClass
	 */
	public static float getCostPerClass() {
		return costPerClass;
	}
	
	public void addStudents() {
		char ans = InputHandler.readCharLower("Would you like to add students (y/n):");
		
		if (ans != 'y') {return;}
		while (ans == 'y') {
			students.add(new Student());
			ans = InputHandler.readCharLower("Would you like to add another student (y/n):");
		}
	}
	
	public void printStudents() {
		for(Student el : students) {
			el.printStudentInfo();
		}
	}
	
	public Student findStudentById(int id) {
		for(Student el : students) {
			if(el.getStudentID() == id) {return el;}
		}
		return null;
	}
	
	public void enrollStudentCourses() {
		char ans = InputHandler.readCharLower("Would you like to enroll students in courses(y/n):");
		if (ans != 'y') {return;}
		while (ans == 'y') {
			int id = InputHandler.readInt("Enter student ID (5 digits):");
			Student theStudent = this.findStudentById(id);
			if(theStudent == null) {
				ans = InputHandler.readCharLower("Student ID not found! \nWould you like to enter another (y/n)?:");
				if (ans != 'y') {return;}
				else {continue;}
			}else {
				theStudent.enrollCourses();
			}
		}
	}

}
