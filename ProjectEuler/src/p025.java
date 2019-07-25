import java.math.BigInteger;

/**
 * This class solves Problem 25 in Project Euler
 * 
 * The Fibonacci sequence is defined by the recurrence relation:
 * Fn = Fn-1 + Fn-2, where F1 = 1 and F2 = 1.
 * 
 * Hence the first 12 terms will be:
 * F1 = 1
 * F2 = 1
 * F3 = 2
 * F4 = 3
 * F5 = 5
 * F6 = 8
 * F7 = 13
 * F8 = 21
 * F9 = 34
 * F10 = 55
 * F11 = 89
 * F12 = 144
 * 
 * The 12th term, F12, is the first term to contain three digits.
 * 
 * What is the index of the first term in the Fibonacci sequence to contain 1000 digits?
 * 
 * @author Kamil Adem
 *
 */
public class p025 implements Euler {

	
	/**
	 * This method computes Fibonacci numbers until a number with 1000 or more digits is reached
	 * Iteratively adds Fibanacci sequence values
	 * 
	 * @return The index of the Fibonnaci number which produces 1000 digits
	 */
	@Override
	public String run() {
		BigInteger Fp = new BigInteger("1");
		BigInteger Fc = new BigInteger("1");
		int index = 2;
		while(numDigits(Fc)<1000) {
			BigInteger temp = Fc;
			Fc = Fp.add(Fc);
			Fp = temp;
			index++;
		}
		return Integer.toString(index);
	}


	/**
	 * This method computes the number of digits a number has.
	 * Converts BigInteger into a string and returns count of characters.
	 * 
	 * @param n the given BigInteger
	 * @return  the number of digits of the BigInteger value
	 */
	public int numDigits(BigInteger n) {
		return n.toString().length();
	}
}
