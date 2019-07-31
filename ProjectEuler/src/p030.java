/**
 * This class solves Project Euler problem 30
 * 
 * Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:
 * 	
 * 	1634 = 14 + 64 + 34 + 44
 * 	8208 = 84 + 24 + 04 + 84
 * 	9474 = 94 + 44 + 74 + 44
 * 
 * As 1 = 14 is not a sum it is not included.
 * 
 * The sum of these numbers is 1634 + 8208 + 9474 = 19316.
 * 
 * Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
 * 
 * @author Kamil Adem
 *
 */
public class p030 implements Euler {

	/**
	 * This method computes the sum of numbers that can be written as the sum of fifth powers of their digits.
	 * This problem has an upper limit of 6 digits, where its max value in less than the sum its fifth powers of their digits.
	 * Iterates until 999999 and checks if the digit sums are equal to its values.
	 * 
	 * @return the sum of all the numbers that can be written as the sum of fifth powers of their digits.
	 */
	@Override
	public String run() {
		int sum = 0;
		for (int i=2; i<999999; i++) {
			if (i == digitSum(i)) {
				sum +=i;
			}
		}
		return Integer.toString(sum);
	}

	/**
	 * This method computes the sum of fifth powers of the digits of a number.
	 * Iterates over an integer be extracting the last digit by dividing by 10 and extracting the remainder.
	 * This process repeats until all digits have been processed.
	 *  
	 * @param n the given integer
	 * @return the sum of the fifth powers of its digits
	 */
	public int digitSum(int n) {
		int sum = 0;
		while(n!=0) {
			int temp = n%10;
			sum+=Math.pow(temp, 5);
			n/=10;
		}
		return sum;
	}

}
