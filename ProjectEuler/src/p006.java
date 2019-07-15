/**
 * This class solves problem six in Project Euler.
 * 
 * The sum of the squares of the first ten natural numbers is,
 * 1^2 + 2^2 + ... + 10^2 = 385
 * The square of the sum of the first ten natural numbers is,
 * (1 + 2 + ... + 10)^2 = 552 = 3025
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 - 385 = 2640.
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 * 
 * This solution uses a brute force algorithm
 * 
 * @author Kamil Adem
 *
 */
public class p006 implements Euler {


	/**
	 * @return the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum
	 */
	@Override
	public String run() {
		return Long.toString(squareOfSum()-sumOfSquares());
	}
	
	/**
	 * This method computes the sum of the square of each number 1-100
	 * 
	 * @return the sum
	 */
	public long sumOfSquares() {
		long sum =0;
		for (int i=1; i<101; i++) {
			sum+=Math.pow(i, 2);
		}
		return sum;
	}

	/**
	 * This method computes the square of the sums of values 1-100
	 * 
	 * @return the sum
	 */
	public long squareOfSum() {
		long sum = 0;
		for (int i=1; i<101; i++) {
			sum+=i;
		}
		
		return (long) Math.pow(sum, 2);
	}
}
