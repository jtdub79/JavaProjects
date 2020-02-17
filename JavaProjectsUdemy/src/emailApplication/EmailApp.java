/**
 * 
 */
package emailApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jim Westfall
 *
 */
public class EmailApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<Email> emails = new ArrayList<Email>();
		
		emails.add(new Email("Jim","Westfall"));
		emails.add(new Email("John","Doe"));
		
		for(Email el : emails) {
			System.out.println(el.getPerson().getFullName() + " - " + el.getPerson().getDepartment().name());
		}
		
	}

}
