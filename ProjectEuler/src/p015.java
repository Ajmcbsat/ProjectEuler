import java.math.BigInteger;

/**
 * This class solves problem fifteen in Project Euler
 * 
 * Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.
 * 
 * How many such routes are there through a 20×20 grid?
 * 
 * @author Kamil Adem
 *
 */
public class p015 implements Euler {


	/**
	 * This method computes the number of Lattice paths.
	 * This problem can be generalized as a combinatorial problem and therefore it solution
	 * is the combination of the total number of moves to get to the end (40) and the number 
	 * of moves that are arbitrarily chosen by you (20).
	 *  
	 *  @return the number of Lattice paths
	 */
	@Override
	public String run() {
		BigInteger n = new BigInteger("40");
		BigInteger r = new BigInteger("20");

		BigInteger comb = factorial(n).divide(factorial(r).multiply(factorial(r)));
		return comb.toString();
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
