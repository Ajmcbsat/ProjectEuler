import java.math.BigInteger;

/**
 * This class solves Project Euler Problem 20.
 * 
 * n! means n × (n - 1) x ... x 3 x 2 x 1
 * 
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 * 
 * Find the sum of the digits in the number 100!
 * 
 * @author Kamil Adem
 *
 */
public class p020 implements Euler {

	
	/**
	 * This method computes 100! and then sums all of its digits.
	 * Converts factorial value to string, converted string chars
	 * into digits and adds said digits together.
	 * 
	 * @return the sum of the digits of 100!
	 */
	@Override
	public String run() {
		String s = "";
		int sum = 0;
		BigInteger b = new BigInteger("100");
		b = factorial(b);
		s = b.toString();
		for (int i=0; i<s.length(); i++) {
			sum+=Character.getNumericValue(s.charAt(i));
		}
		return Integer.toString(sum);
	}


	/**
	 * This method return the factorial of the given number.
	 * BigInteger is used to store values greater than the max long integer value
	 * Factorial is recursively computed
	 * 
	 * @param s the BigInteger whose factorial value is being determined
	 * @return  the factorial value
	 */
	public BigInteger factorial(BigInteger s) {
		if (s.equals(BigInteger.ONE)) {
			return s;
		}
		return s.multiply(factorial(s.subtract(BigInteger.ONE)));
	}
	
}
