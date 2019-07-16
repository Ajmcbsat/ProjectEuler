/**
 * This class solves problem ten in Project Euler
 * 
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * Find the sum of all the primes below two million.
 * 
 * @author Kamil Adem
 *
 */
public class p010 implements Euler {


	/**
	 * This method computes the sum of all prime numbers less than 2 million
	 * Iteratively goes through all odd values and determines if the number is prime.
	 * 
	 * @return the sum as a String
	 */
	@Override
	public String run() {
		long sum = 5;
		for (int i=3; i<2000000; i+=2) {
			if (isPrime(i)) {
				sum+=i;
			}
		}
		return Long.toString(sum);
	}


	/**
	 * This method determines if the given number is prime.
	 * If the input is a multiple 2 or 3, false.
	 * After first two test cases, all numbers less than 9 are prime numbers.
	 * All prime numbers greater than 3 can be written in the form 6k+-1 where k is 1:sqrt(num).
	 * All primes numbers grater than 3 are tested by every prime number until the square of itself.
	 * 
	 * @param num the number being tested
	 * @return	  whether the number is prime
	 */
	public boolean isPrime(int num) {
			
			if (num%3 == 0) {
				return false;
			}
			if (num<9) {
				return true;
			}
	
			int p = 5;
			while (p<=Math.sqrt(num)) {
				if (num%p == 0) {
					return false;
				}
				if (num%(p+2) == 0) {
					return false;
				}
				p+=6;
			}
			return true;
			
		}
}
