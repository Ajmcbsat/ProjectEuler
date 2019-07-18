/**
 * This class solves problem 17 of Project Euler
 * 
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used? 
 * 
 * @author Kamil Adem
 *
 */
public class p017 implements Euler {


	/**
	 * Array containing the letter counts of values 1-19
	 */
	private int [] ones = new int[] {0,3,3,5,4,4,3,5,5,4,3,6,6,8,8,7,7,9,8,8};
	/**
	 * Array containing the letter counts of values 20-100
	 */
	private int [] tens = new int[] {0,0,6,6,5,5,5,7,6,6,7};
			
	public static void main(String[] args) {
		System.out.println(new p017().run());
	}

	/**
	 * This method computes the number of letters required to list numbers from 1-1000
	 * This method relies heavily on branches
	 * This method first takes care of values less then 20, then values less then 100, the values less than 1000
	 * and finally 1000.
	 *  
	 * @return the number of letters
	 */
	@Override
	public String run() {
		int sum = 0;
		for (int i=1; i<=1000; i++) {
			if (i<20) {
				sum+= ones[i];
			}
			else if (i<100) {
				int temp = i;
				int count = 0;
				while (temp>=10) {
					temp-=10;
					count++;
				}
				sum+=ones[temp]+tens[count];
			}
			else if (i<1000) {
				int temp = i;
				int count_tens = 0;
				int count_hundreds = 0;
				while (temp>=100) {
					temp-=100;
					count_hundreds++;
				}
				
				if (temp == 0) {
					sum+=ones[temp]+ones[count_hundreds]+tens[count_tens]+7;
				}
				else if (temp<20) {
					sum+=ones[temp]+ones[count_hundreds]+tens[count_tens]+10;
				}
				else {	
					while (temp>=10) {
						temp-=10;
						count_tens++;
					}
					sum+=ones[temp]+ones[count_hundreds]+tens[count_tens]+10;
				}
			}
			else {
				sum+=11;
			}
		}
		return Integer.toString(sum);
	}

}
