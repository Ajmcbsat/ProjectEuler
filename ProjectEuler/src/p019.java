/**
 * This class solves Project Euler Problem 19
 * 
 * You are given the following information, but you may prefer to do some research for yourself.
 * 
 * 1 Jan 1900 was a Monday.
 * Thirty days has September,
 * April, June and November.
 * All the rest have thirty-one,
 * Saving February alone,
 * Which has twenty-eight, rain or shine.
 * And on leap years, twenty-nine.
 * A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
 * 
 * How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 * 
 * @author Kamil Adem
 *
 */
public class p019 implements Euler {

	
	/**
	 * Array which contains the number of days per month, functions as a circular array
	 */
	private int [] daysamonth = new int [] {31,28,31,30,31,30,31,31,30,31,30,31};
	

	/**
	 * This method computes the number of Sundays that fall on the first of the month.
	 * Iterates over all Sunday values from 1901 to 2000 and updates month and year values accordingly.
	 * 
	 * @return the number of days where Sunday is first day of the month
	 */
	@Override
	public String run() {
		int count = 0;
		int year = 1901;
		int indexm = 0;
		int day = 6;
		while(year!=2001 ) {
			if (day == 1) {
				count++;
			}
			
			if (indexm == 1) {
				if (year%4 == 0 ) {
					daysamonth[1] = 29;
				}
				else {
					daysamonth[1] = 28;
				}
			}
			
			if (day+7 > daysamonth[indexm]) {
				day = 7 - (daysamonth[indexm]-day);
				indexm++;
			}
			
			else {
				day+=7;
			}
			
			if (indexm >daysamonth.length-1) {
				indexm = 0;
				year++;
			}
		}
		return Integer.toString(count);
	}


}
