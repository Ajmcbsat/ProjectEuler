/**
 * The following iterative sequence is defined for the set of positive integers:
 * 
 * n = n/2 (n is even)
 * n = 3n + 1 (n is odd)
 * 
 * Using the rule above and starting with 13, we generate the following sequence:
 * 13 to 40 to 20 to 10 to 5 to 16 to 8 to 4 to 2 to 1
 * 
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
 * 
 * Which starting number, under one million, produces the longest chain?
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 * 
 * @author Kamil Adem
 *
 */
public class p014 implements Euler {

		
	/**
	 * This method computes the starting number that produces the longest Collatz sequence
	 * Iterates from 2 upwards. Performance could be increased by increasing initial starting index to a more
	 * reasonable number such as 500000.
	 * 
	 * @return the starting number that produces the longest Collatz sequence as a String
	 */
	@Override
	public String run() {
		long max = 0;
		int start = 0;
		for (int i=2; i<1000000; i++) {
			int count = 0;
			long temp = i;
			while(temp!=1) {
				if (temp%2 == 0) {
					temp/=2;
				}
				else {
					temp = temp*3 +1;
				}
				count++;
			}
			if (count>max) {
				max = count;
				start = i;
			}
		}
		return Integer.toString(start);
	}


}
