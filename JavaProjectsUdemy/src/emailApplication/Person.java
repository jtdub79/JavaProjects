package emailApplication;

public abstract class Person {
	private String firstName;
	private String lastName;
	
	// Constructors
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	
	// Getters and Setters
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}
}
