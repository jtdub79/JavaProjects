/**
 * 
 */
package studentDatabaseApp;

/**
 * @author Jim Westfall
 *
 */
public class StudentDatabaseApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		School mySchool = new School();
		
		mySchool.printStudents();
		
		mySchool.enrollStudentCourses();
		
		mySchool.printStudents();

	}

}
