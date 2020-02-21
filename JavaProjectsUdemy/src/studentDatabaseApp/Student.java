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
public class Student {
	
	
	private static int runningStudentID = 1000;
		
	private String firstName;
	private String lastName;
	private int classYear = 1;
	private int studentID;
	private float accountBalance = 0.0f;
	private List<School.Courses> enrolledCourses = new ArrayList<School.Courses>();
	
	
	// Constructors
	public Student() {
		this(Student.inputName("first"), Student.inputName("last"));
	}
	
	public Student(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		
		this.inputClassYear();
		
		this.generateStudentID();
	}	
	
	// Methods to aid constructors
	private static String inputName(String whichName) {
		return InputHandler.readString("Enter student  "+ whichName + " name:");
	}
	
	
	// Getters and Setters
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}
	/**
	 * @return the classYear
	 */
	public int getClassYear() {
		return classYear;
	}
	/**
	 * @param classYear the classYear to set
	 */
	public void setClassYear(int classYear) {
		this.classYear = classYear;
	}
	/**
	 * @return the studentID
	 */
	public int getStudentID() {
		return studentID;
	}
	/**
	 * @return the accountBalance
	 */
	public float getAccountBalance() {
		return accountBalance;
	}
	/**
	 * @param accountBalance the accountBalance to set
	 */
	public void setAccountBalance(float accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	// other methods
	public void payOnBalance(float payment) {
		this.accountBalance -= payment;
	}
	public void addToBalance(float debt) {
		this.accountBalance += debt;
	}
	private void inputClassYear() {
		String msg = "Enter student class year:\n" + 
						"\t1 - Freshman\n" + 
						"\t2 - Sophomore\n" + 
						"\t3 - Junior\n" + 
						"\t4 - Senior\n";
		this.classYear = InputHandler.readInt(msg, 1, 4);
	}
	private void generateStudentID() {
		this.studentID = classYear * (int)1e4 + Student.runningStudentID;
		runningStudentID++;
	}
	
	public void enrollCourses() {
		
		//TODO make  loop to add multiple courses
		
		String msg = "Courses Offered:\n";
		for(School.Courses el : School.Courses.values()) {
			msg += "\t" + el.ordinal() + " - " + el.getLongName() + "\n";
		}
		msg += "Enter course to enroll(enter -1 to finish/cancel):\n";
		
		int choice = InputHandler.readInt(msg,-1,School.Courses.values().length);
		
		assert(choice < School.Courses.values().length);
		
		if(choice < 0) {
			System.out.println("Finished enrolling.");
			return;
		}else {
			this.enrolledCourses.add(School.Courses.values()[choice]);
			this.addToBalance(School.getCostPerClass());
		}
	}
	
	public void printStudentInfo() {
		System.out.println(this.getFullName());
		System.out.println("\tStudent ID        : " + this.studentID);
		System.out.println("\tStudent Class Year: " + this.classYear);
		System.out.println("\tAccount Balance   : " + this.accountBalance);
		System.out.println("\tCourses currently enrolled:");
		for(School.Courses el : enrolledCourses) {
			System.out.println("\t" + el.getLongName());
		}
	}
}
