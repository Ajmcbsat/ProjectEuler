/**
 * @author Kamil Adem
 *
 */
public class p001 implements Euler {
	
	/**
	 * This method finds the sum of the multiples of 5 and 3
	 * The range of the values is from 1 to 999
	 * 
	 * @return the sum as a String
	 */
	@Override
	public String run() {
		
		int sum = 0;
		for (int i = 1; i<1000; i++)
		{
			if (i%3 == 0 || i%5 == 0)
			{
				sum+=i;
			}
		}
		return Integer.toString(sum);
		
	}
}
