/**
 * This class solves problem nine in Project Euler.

 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * a2 + b2 = c2
 * For example, 32 + 42 = 9 + 16 = 25 = 52.
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * 
 * Find the product abc.
 * 
 * @author Kamil Adem
 *
 */
public class p009 implements Euler {


	/**
	 * This method computes the product of the Pythagorean triplet which adds to 1000.
	 * Iterates through all possible values and guarantees that a<b<c always holds true.
	 * 
	 * @return the product as a String
	 */
	@Override
	public String run() {
		int prod = 1;
		for (int a=1; a<500; a++) {
			if (prod>1) {
				break;
			}
			for (int b=(a+1); b<500; b++) {
				double c = Math.sqrt(a*a + b*b);
				if (a+b+c ==1000) {
					prod = (int) (a*b*c);
					break;
				}
			}
		}
		return Integer.toString(prod);
	}
}
