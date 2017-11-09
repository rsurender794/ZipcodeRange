package com.program.util;

import java.util.Comparator;

import com.program.model.ZipCodeRange;


/**
 * 
 * ZipCodeComparator to sort the ZipCodeRange based on its lower and upper
 * bounds
 *
 */
public class ZipCodeComparator implements Comparator<ZipCodeRange> {
	@Override
	public int compare(ZipCodeRange o1, ZipCodeRange o2) {
		// Check if both the zip codes have same lower and upper bounds
		if (o1.getLow() == o2.getLow() && o1.getHigh() == o2.getHigh()) {
			return 0;
		}
		// Check if the 1st zip code lower bound is less than the 2nd zip code
		if (o1.getLow() < o2.getLow()) {
			return -1;
		}
		// Check if the 1st zip code higher bound is less than the 2nd zip code
		else if (o1.getLow() == o2.getLow() && o1.getHigh() < o2.getHigh()) {
			return -1;
		}
		// Default case - 2nd zip code is less than the 1st zip code
		return 1;
	}
}