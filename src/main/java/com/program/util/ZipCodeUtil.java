package com.program.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.program.exception.InvalidInputFormat;
import com.program.model.ZipCodeRange;

/**
 * 
 * Utility class
 *
 */
public class ZipCodeUtil {

	/**
	 * Returns the ZipCodeRange object for the given input {"[94200","94299]"}
	 * 
	 * @param splits
	 * @return
	 */
	public static ZipCodeRange getZipCodeRange(String[] splits) {
		try {
			int low = ZipCodeUtil.getValue(splits[0], 1, splits[0].length());
			int high = ZipCodeUtil.getValue(splits[1], 0, splits[1].length() - 1);
			if (low <= high) {
				return new ZipCodeRange(low, high);
			} else {
				return new ZipCodeRange(high, low);
			}
		} catch (Exception ex) {
			throw new InvalidInputFormat("Invalid input format", ex);
		}
	}

	/**
	 * Returns the zip code value for the given input String <br/>
	 * <br/>
	 * Example:<br/>
	 * Calling method with parameters "[94200",1,6 returns 94200 <br/>
	 * Calling method with parameters "94200]",0,5 returns 94200
	 * 
	 * @param input
	 * @param lowIdx
	 * @param highIdx
	 * @return
	 */
	public static int getValue(String input, int lowIdx, int highIdx) {
		return Integer.parseInt(input.substring(lowIdx, highIdx));
	}

	/**
	 * This method takes the list of ZipCodeRange objects and produces the
	 * minimum number of ranges required to represent the same restrictions as
	 * the input.
	 * 
	 * @param input
	 * @return
	 */
	public static List<ZipCodeRange> getRestrictedRange(List<ZipCodeRange> input) {
		List<ZipCodeRange> result = new ArrayList<>();
		if (input == null || input.size() == 0) {
			return null;
		}
		Iterator<ZipCodeRange> iterator = input.iterator();
		result.add(iterator.next());
		while (iterator.hasNext()) {
			ZipCodeRange current = iterator.next();
			ZipCodeRange previous = result.get(result.size() - 1);
			if (previous.getHigh() < current.getLow()) {
				result.add(current);
			} else {
				if(current.getHigh() > previous.getHigh()) {
					previous.setHigh(current.getHigh());	
				}
			}
		}
		return result;
	}
}




