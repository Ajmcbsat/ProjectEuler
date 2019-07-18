import java.math.BigInteger;

/**
 * This class solves problem sixteen in Project Euler
 * 
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * 
 * What is the sum of the digits of the number 2^1000?
 * 
 * @author Kamil Adem
 *
 */
public class p016 implements Euler {


	/**
	 * This method computes the sum of the digits of 2^1000
	 * Works by first storing the value 2^1000 as a BigInteger,
	 * converting BigInteger to a String and adding the digits of 
	 * the product one by one
	 * 
	 * @return the sum of the digits of 2^1000
	 */
	@Override
	public String run() {
		BigInteger b = new BigInteger("2").pow(1000);
		String s = b.toString();
		long sum = 0;
		for (int i=0; i<s.length(); i++) {
			sum += Character.getNumericValue(s.charAt(i));
		}
		return Long.toString(sum);
	}


}
