/**
 * 
 */
package studentDatabaseApp;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Jim Westfall
 *
 */
public class InputHandler {
	
	private static Scanner in = new Scanner(System.in);
	
	//public static <T> T readInput(String msg, Class<T> c) throws Exception{ 
	private static <T> T readInput(String msg, Class<T> c) { 
       System.out.println(msg); 
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

       in = new Scanner(System.in);
       
       return ouput;
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
	
	
	// Wrapper methods for each data type
	
	/**
	 * @param the input message
	 * @return the integer from user input
	 */
	public static int readInt(String msg) {
		return InputHandler.readInput(msg, Integer.class);
	}
	
	/**
	 * @param the input message
	 * @param the lower acceptable bound inclusive
	 * @param the upper acceptable bound inclusive
	 * @return the integer from user input
	 */
	public static int readInt(String msg, int lowerBound, int upperBound) {
		return InputHandler.readInput(msg, Integer.class, lowerBound, upperBound);
	}
	
	/**
	 * @param the input message
	 * @return the double from user input
	 */
	public static double readDouble(String msg) {
		return InputHandler.readInput(msg, Double.class);
	}
	
	/**
	 * @param the input message
	 * @param the lower acceptable bound inclusive
	 * @param the upper acceptable bound inclusive
	 * @return the double from user input
	 */
	public static double readDouble(String msg, double lowerBound, double upperBound) {
		return InputHandler.readInput(msg, Double.class, lowerBound, upperBound);
	}


	/**
	 * @param the input message
	 * @return the float from user input
	 */
	public static float readFloat(String msg) {
		return InputHandler.readInput(msg, Float.class);
	}
	
	/**
	 * @param the input message
	 * @param the lower acceptable bound inclusive
	 * @param the upper acceptable bound inclusive
	 * @return the float from user input
	 */
	public static float readfloat(String msg, float lowerBound, float upperBound) {
		return InputHandler.readInput(msg, Float.class, lowerBound, upperBound);
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
