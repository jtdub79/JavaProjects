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
		Scanner in = new Scanner(System.in);
		System.out.println("Would you like to add students (y/n):");
		char ans = in.next().toLowerCase().charAt(0);
		if (ans != 'y') {return;}
		while (ans == 'y') {
			students.add(new Student());
			System.out.println("Would you like to add another student (y/n):");
			ans = in.next().toLowerCase().charAt(0);
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
		Scanner in = new Scanner(System.in);
		System.out.println("Would you like to enroll students in courses(y/n):");
		char ans = in.next().toLowerCase().charAt(0);
		if (ans != 'y') {return;}
		while (ans == 'y') {
			System.out.println("Enter student ID (5 digits):");
			int id = in.nextInt();
			Student theStudent = this.findStudentById(id);
			if(theStudent == null) {
				System.out.println("Student ID not found! \nWould you like to enter another (y/n)?:");
				ans = in.next().toLowerCase().charAt(0);
				if (ans != 'y') {return;}
				else {continue;}
			}else {
				theStudent.enrollCourses();
			}
		}
	}

}
