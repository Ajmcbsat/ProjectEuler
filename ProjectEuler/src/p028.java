/**
 * This class solves Project Euler problem 28
 * 
 * Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:
 * 21 22 23 24 25
 * 20  7  8  9 10
 * 19  6  1  2 11
 * 18  5  4  3 12
 * 17 16 15 14 13
 * 
 * It can be verified that the sum of the numbers on the diagonals is 101.
 * 
 * What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?
 * 
 * @author Kamil Adem
 *
 */
public class p028 implements Euler {

	/**
	 * This method computes the sum of the diagonals of a 1001 by 1001 spiral.
	 * For each level, the diagonals must be some factor of 2 away from each other and this factor consistently increases
	 * by a sum of 2. The maximum diagonal value is the size of the spiral squared which is 1001^2=1002001. 
	 * This method iterates until the maximum diagonal value is reached.
	 * 
	 * @return the sum of all the diagonals in a 1001 by 1001 spiral
	 */
	@Override
	public String run() {
		int sum = 1;
		int num = 1;
		int factor = 2;
		while(num!=1002001) {
			for (int i=0; i<4; i++) {
				num+=factor;
				sum +=num;
			}
			factor+=2;
		}
		return Integer.toString(sum);
	}

}
