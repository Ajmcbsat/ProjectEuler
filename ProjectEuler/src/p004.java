/**
 * This class solves problem four in Project Euler.
 * 
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
 * 
 * This solution uses a brute force algorithm 
 */

/**
 * @author Kamil Adem
 *
 */
public class p004 implements Euler {
	
	/**
	 * This method computes the largest palindrome product of 3 digit numbers.
	 * This method performs all possible products of 3 digit numbers and checks
	 * if the product is a palindrome using the isPal method. The max of the 
	 * palindrome products is stored and then returned.
	 * 
	 * @return largest palindrome product as a String
	 */
	@Override
	public String run() {
		// TODO Auto-generated method stub
		int val = 0;
		for (int i=100; i<1000; i++) 
		{
			for (int w=100; w<1000; w++)
			{
				int temp = w*i;
				if (isPal(temp) && temp>val)
				{
					val = temp;
				}
			}
		}
		return Integer.toString(val);
	}

	/**
	 * This method returns whether the given integer is a Palindrome
	 * This method converts the given integer into a String, reverses
	 * the string and then performs an equality check on the two 
	 * Strings.
	 * 
	 * @param num integer to be tested
	 * @return	  if integer is a palindrome
	 */
	public boolean isPal(int num) {
		String s = Integer.toString(num);
		if (s.equals(reverse(s))) {

			return true;
		}
		return false;
		
	}
	
	
	/**
	 * This method reverses the given String s
	 * 
	 * @param s integer as a String
	 * @return  the reversed String
	 */
	public String reverse(String s) {
		return new StringBuilder(s).reverse().toString();
	}

}
