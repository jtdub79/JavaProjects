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
		Scanner in = new Scanner(System.in);
		System.out.println("Enter student  "+ whichName + " name:");
		return in.next();
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
		Scanner in = new Scanner(System.in);
		System.out.println("Enter student class year:");
		System.out.println("\t1 - Freshman");
		System.out.println("\t2 - Sophomore");
		System.out.println("\t3 - Junior");
		System.out.println("\t4 - Senior");
		this.classYear = in.nextInt();
	}
	private void generateStudentID() {
		this.studentID = classYear * (int)1e4 + Student.runningStudentID;
		runningStudentID++;
	}
	
	public void enrollCourses() {
		
		//TODO make  loop to add multiple courses
		System.out.println("Courses Offered:");
		for(School.Courses el : School.Courses.values()) {
			System.out.println("\t" + el.ordinal() + " - " + el.getLongName());
		}
		Scanner in = new Scanner(System.in);
		System.out.println("Enter course to enroll(negative number to finish/cancel):");
		int choice = in.nextInt();
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
		//TODO add print student info code
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
