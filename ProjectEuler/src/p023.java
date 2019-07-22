/**
 * This class solves Problem 23 in Project Euler.
 * 
 * A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
 * 
 * A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers. However, this upper limit cannot be reduced any further by analysis even though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.
 * 
 * Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
 * 
 * @author Kamil Adem
 *
 */
public class p023 implements Euler {

	
	/**
	 * Array which contains boolean values, denoting whether the index value is an abundant number.
	 * 0th index is unused.
	 */
	private boolean [] table = new boolean[28124];
	
	/**
	 * This method computes the sum of integers which can't be written as the sum of two abundant numbers.
	 * Initially computes an array of booleans which stores if a value is an abundant integer in the range 1:28123.
	 * This saves us computation time for recomputing the same values over and over.
	 * Iterates over all values 1:28123 and brute force searches for a solution. 
	 * If no solution is found, then that value is added into the final sum.
	 * 
	 * @return the sum of positive integers which can't be written as the sum of two abundant numbers.
	 */
	@Override
	public String run() {
		
		for (int i=1; i<28124; i++) {
			table[i] = isAbundant(i);
		}
		
		int sum = 0;
		for (int i=1; i<28123; i++) {
			boolean flag = false;
			for (int w=1; w<=i; w++) {
				if (table[w] && table[i-w]) {
					flag = true;
					break;
				}
			}
			if (flag == false) {
				sum+=i;
			}
		}
		return Integer.toString(sum);
	}

	/**
	 * This method tests if the given integer is an abundant number.
	 * Iterates through all values and returns whether the given number has divisor sum greater than its own value.
	 * 
	 * @param n the given integer
	 * @return  value denoting if the given integer is an abundant value
	 */
	public boolean isAbundant(int n) {
		int sum = 0;
		for (int i=1; i<n; i++) {
			if (n%i ==0) {
				sum+=i;
			}
		}
		return sum>n;
	}
	

}
