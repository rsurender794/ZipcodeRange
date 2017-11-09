package com.program.service;

import java.util.List;

import com.program.model.ZipCodeRange;

/**
 * 
 * ZipCodeService to read the input string and process to get final format
 *
 */
public interface ZipCodeService {

	/**
	 * Converts the input String array to list of ZipCodeRange objects
	 * 
	 * @param input
	 * @return
	 */
	List<ZipCodeRange> getZipCodeList(String[] input);

	/**
	 * Converts the input String array produces the minimum number of ranges
	 * required to represent the same restrictions as the input
	 * 
	 * @param input
	 * @return
	 */
	List<ZipCodeRange> processZipCodes(String[] input);

}
