/**
 * 
 */
package studentDatabaseApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * @author Jim
 *
 */
public class Student {
	
	public static enum Courses{
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
	private static int runningStudentID = 1000;
	
	
	private String firstName;
	private String lastName;
	private int classYear = 1;
	private int studentID;
	private float accountBalance = 0.0f;
	private List<Courses> enrolledCourses = new ArrayList<Courses>();
	
	
	// Constructors
	public Student(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		
		this.inputClassYear();
		
		this.generateStudentID();
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
		System.out.println("\t1 - Sophomore");
		System.out.println("\t1 - Junior");
		System.out.println("\t1 - Senior");
		this.classYear = in.nextInt();
	}
	private void generateStudentID() {
		this.studentID = classYear * (int)1e5 + runningStudentID;
		runningStudentID++;
	}
	
	public void enrollCourses() {
		//TODO generate enrollment code
		
	}
}
