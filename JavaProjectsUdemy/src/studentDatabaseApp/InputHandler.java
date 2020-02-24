/**
 * 
 */
package studentDatabaseApp;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * @author Jim Westfall
 *
 */
public class InputHandler {
	
	private static Scanner in = new Scanner(System.in);
	
	private static <T> T readSingleInput(String msg, Class<T> c) {
		T ouput = null;
		try { 
			if(c == Integer.class) 
				ouput = c.cast(in.nextInt()); 
           
			if(c == Double.class) 
				ouput = c.cast(in.nextDouble()); 
           
			if(c == Float.class) 
        	   	ouput = c.cast(in.nextFloat()); 
           
           	if(c == String.class) 
        	   	ouput = c.cast(in.next()); 
           
       } catch (InputMismatchException e) { 
           	System.out.println("You did not input a " + c.getSimpleName() + ". Please try again.");
           	return c.cast(InputHandler.readInput(msg,c));
       }
       
       return ouput;
	}
	
	private static <T> T readInput(String msg, Class<T> c) { 
		System.out.println(msg); 
		in = new Scanner(System.in);
       
		return InputHandler.readSingleInput(msg, c);
	}
	
	private static <T> T readInput(String msg, Class<T> c, T lowerBound, T upperBound) {
		T ans = InputHandler.readInput(msg, c);
		
		if(c == Integer.class) {
			if ((int)lowerBound <= (int)ans && (int)ans <= (int)upperBound) { return ans; }
			else {
				System.out.println("Input not in valid range. Please try again.");
				return c.cast(InputHandler.readInput(msg,c , lowerBound, upperBound));
			}
		}
		
        if(c == Double.class)  {
			if ((double)lowerBound <= (double)ans && (double)ans <= (double)upperBound) { return ans; }
			else {
				System.out.println("Input not in valid range. Please try again.");
				return c.cast(InputHandler.readInput(msg, c , lowerBound, upperBound));
			}
		}


        if(c == Float.class)  {
			if ((float)lowerBound <= (float)ans && (float)ans <= (float)upperBound) { return ans; }
			else {
				System.out.println("Input not in valid range. Please try again.");
				return c.cast(InputHandler.readInput(msg, c , lowerBound, upperBound));
			}
		}
        
        return null;
	} 
	
	private static <T> List<T> readList(String msg, Class<T> c) { 
		System.out.println(msg); 
       	in = new Scanner(System.in);
       	List<T> output = new ArrayList<T>();
       	while (in.hasNext()) {
       		output.add(InputHandler.readSingleInput(msg, c));
       	}
       
       	return output;
	} 
	
	
	// Wrapper methods for each data type
	
	/**
	 * @param the input message
	 * @return the Integer from user input
	 */
	public static Integer readInt(String msg) {
		return InputHandler.readInput(msg, Integer.class);
	}
	
	/**
	 * @param the input message
	 * @param the lower acceptable bound inclusive
	 * @param the upper acceptable bound inclusive
	 * @return the Integer from user input
	 */
	public static Integer readInt(String msg, int lowerBound, int upperBound) {
		return InputHandler.readInput(msg, Integer.class, lowerBound, upperBound);
	}
	
	/**
	 * @param the input message
	 * @return the List of Integers from user input
	 */
	public static List<Integer> readIntList(String msg) {
		return InputHandler.readList(msg, Integer.class);
	}

	
	/**
	 * @param the input message
	 * @return the Double from user input
	 */
	public static Double readDouble(String msg) {
		return InputHandler.readInput(msg, Double.class);
	}
	
	/**
	 * @param the input message
	 * @param the lower acceptable bound inclusive
	 * @param the upper acceptable bound inclusive
	 * @return the Double from user input
	 */
	public static Double readDouble(String msg, double lowerBound, double upperBound) {
		return InputHandler.readInput(msg, Double.class, lowerBound, upperBound);
	}

	/**
	 * @param the input message
	 * @return the List of Doubles from user input
	 */
	public static List<Double> readDoubleList(String msg) {
		return InputHandler.readList(msg, Double.class);
	}

	/**
	 * @param the input message
	 * @return the Float from user input
	 */
	public static Float readFloat(String msg) {
		return InputHandler.readInput(msg, Float.class);
	}
	
	/**
	 * @param the input message
	 * @param the lower acceptable bound inclusive
	 * @param the upper acceptable bound inclusive
	 * @return the Float from user input
	 */
	public static Float readfloat(String msg, float lowerBound, float upperBound) {
		return InputHandler.readInput(msg, Float.class, lowerBound, upperBound);
	}

	/**
	 * @param the input message
	 * @return the List of Floats from user input
	 */
	public static List<Float> readFloatList(String msg) {
		return InputHandler.readList(msg, Float.class);
	}

	/**
	 * @param the input message
	 * @return the string from user input
	 */
	public static String readString(String msg) {
		return InputHandler.readInput(msg, String.class);
	}
	
	/**
	 * @param the input message
	 * @return the char from user input
	 */
	public static char readChar(String msg) {
		return InputHandler.readInput(msg, String.class).charAt(0);
	}
	/**
	 * @param the input message
	 * @return the lower case char from user input
	 */
	public static char readCharLower(String msg) {
		return InputHandler.readInput(msg, String.class).toLowerCase().charAt(0);
	}
	/**
	 * @param the input message
	 * @return the upper case char from user input
	 */
	public static char readCharUpper(String msg) {
		return InputHandler.readInput(msg, String.class).toUpperCase().charAt(0);
	}

}
