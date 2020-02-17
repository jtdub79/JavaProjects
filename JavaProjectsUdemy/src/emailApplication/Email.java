/**
 * 
 */
package emailApplication;

/**
 * @author Jim
 *
 */
public class Email {
	
	private Employee person;
	private String password;
	private String email;
	private String altEmail;
	private int capacity;

	// Constructors
	public Email(Employee person) {
		this.person = person;
		this.password = this.generatePassword(12);
	}
	
	public Email(String firstName, String lastName) {
		this(new Employee(firstName, lastName));
	}
	
	// Getters and Setters
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String newPassword) {
		this.password = newPassword;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAltEmail() {
		return this.altEmail;
	}
	
	public void setAltEmail(String altEmail) {
		this.altEmail = altEmail;
	}

	public Employee getPerson() {
		return person;
	}

	public void setPerson(Employee person) {
		this.person = person;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public void setProperty(String property, String newValue) {
		switch (property) {
			case "email" :
				this.setEmail(newValue);
				break;
			case "password" :
				this.setPassword(newValue);
				break;
			case "altEmail" :
				this.setAltEmail(newValue);
				break;
			default :
				int callersLineNumber = Thread.currentThread().getStackTrace()[1].getLineNumber();
				String className = Thread.currentThread().getStackTrace()[1].getClassName();
				System.out.println("Problem in " +  className + " at line " + callersLineNumber);
		}
	}
	
	public String getProperty(String property) {
		switch (property) {
			case "email" :
				return this.getEmail();
			case "password" :
				return this.getPassword();
			case "altEmail" :
				return this.getAltEmail();
			default :
				int callersLineNumber = Thread.currentThread().getStackTrace()[1].getLineNumber();
				String className = Thread.currentThread().getStackTrace()[1].getClassName();
				System.out.println("Problem in " +  className + " at line " + callersLineNumber);
				return null;
		}
	}
	
	public String generatePassword(int length) {
		
		String passwordSet = "ABCDEFGHIJKLMONPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!#$&%";
		char[] password = new char[length];
		for(int i=0; i < length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			System.out.println(rand);
			password[i] = passwordSet.charAt(rand);
		}
		
		return new String(password);
	}
}
