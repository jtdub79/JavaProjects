/**
 * 
 */
package emailApplication;

import java.util.Scanner;


/**
 * @author Jim
 *
 */
public class Employee extends Person{
	
	private Departments department;
	
	public Employee(String firstName, String lastName) {
		super(firstName, lastName);
		this.inputDepartment();
	}


	public enum Departments{
		SALES, DEVELOPMENT, ACCOUNTING, NONE
	}


	// Getters and Setters
	/**
	 * @return the department
	 */
	public Departments getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(Departments department) {
		this.department = department;
	}
	
	public void inputDepartment() {
		System.out.println("\nEnter the department for " + this.getFullName() + ":");
		System.out.println("1 - Sales\n2 - Development\n3 - Accounting\n0 - None\n");
		Scanner in = new Scanner(System.in);
		int dept = in.nextInt();
		switch (dept) {
			case 1 : 
				this.setDepartment(Departments.SALES);
				break;
			case 2 :
				this.setDepartment(Departments.DEVELOPMENT);
				break;
			case 3 :
				this.setDepartment(Departments.ACCOUNTING);
				break;
			default:
				this.setDepartment(Departments.NONE);
		}
		//in.close();
	}
}
