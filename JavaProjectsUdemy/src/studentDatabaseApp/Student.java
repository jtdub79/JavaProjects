/**
 * 
 */
package studentDatabaseApp;

/**
 * @author Jim
 *
 */
public class Student {
	
	private String firstName;
	private String lastName;
	private int classYear = 1;
	private int studentID;
	private float accountBalance = 0.0f;
	//TODO add list of classes enrolled
	
	// Constructors
	public Student(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		
		//TODO input class year
		
		//TODO generate unique student ID
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
	 * @param studentID the studentID to set
	 */
	public void setStudentID(int studentID) {
		this.studentID = studentID;
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
	
}
