/**
 * This class solves problem seven in Project Euler.
 * 
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 * What is the 10001st prime number?
 * 
 * This solution uses a brute force algorithm
 * 
 * @author Kamil Adem
 *
 */
public class p007 implements Euler {

	
	/**
	 * This method computes the 10001st prime number
	 * This method takes advantage of the fact that all prime numbers are odd
	 * and therefore iterates only through odd numbers.
	 * 
	 * @return the 100001st prime number as a String
	 */
	@Override
	public String run() {
		int count =2;
		int num = 3;
		for (int i=3; count<10001; i+=2) {
			if (isPrime(i)) {
				count++;
				num = i;
			}
		}
		return Integer.toString(num);
	}
	
	/**
	 * This method determines if the given number is prime.
	 * Since the given input will never be an input of multiple 2, that test case is not needed.
	 * Due to the nature of the algorithm, all numbers less than 9 are prime numbers.
	 * For prime numbers greater than or equal to nine, it tests for multiples of three.
	 * All prime numbers greater than 3 can be written in the form 6k+-1 where k is 1:N.
	 * All primes numbers grater than 3 are tested by every prime number until itself.
	 * 
	 * @param num the number being tested
	 * @return	  whether the number is prime
	 */
	public boolean isPrime(int num) {
		
		if (num<9) {
			return true;
		}
		
		if (num%3 == 0) {
			return false;
		}
		
		int p = 5;
		while ((p+2)<num) {
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
