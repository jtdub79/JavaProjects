/**
 * 
 */
package emailApplication;

/**
 * @author Jim
 *
 */
public class Email {
	
	private String password;
	private String email;
	private String altEmail;
	
	public String getEmail() {
		return this.email;
	}

	public String getAltEmail() {
		return this.altEmail;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String newPassword) {
		this.password = newPassword;
	}
	
	public void setEmail(String newEmail) {
		this.email = newEmail;
	}
	
	public void setAltEmail(String newEmail) {
		this.altEmail = newEmail;
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
}
