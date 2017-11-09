package com.program.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

import com.program.model.ZipCodeRange;
import com.program.util.ZipCodeComparator;
import com.program.util.ZipCodeUtil;

public class ZipCodeServiceImpl implements ZipCodeService {
	private static final Logger log = Logger.getLogger(ZipCodeServiceImpl.class);

	/**
	 * Converts the input String array to list of ZipCodeRange objects
	 * 
	 * @param input
	 * @return
	 */
	@Override
	public List<ZipCodeRange> getZipCodeList(String[] input) {
		List<ZipCodeRange> result = new ArrayList<>();
		for (String data : input) {
			String[] splits = data.split(",");
			ZipCodeRange range = ZipCodeUtil.getZipCodeRange(splits);
			result.add(range);
		}
		return result;
	}

	/**
	 * Converts the input String array produces the minimum number of ranges
	 * required to represent the same restrictions as the input
	 * 
	 * @param input
	 * @return
	 */
	@Override
	public List<ZipCodeRange> processZipCodes(String[] input) {
		List<ZipCodeRange> result = this.getZipCodeList(input);
		log.debug("List of Zip codes before sorting : " + result);
		Collections.sort(result, new ZipCodeComparator());
		log.debug("Sorted Zip codes : " + result);
		return ZipCodeUtil.getRestrictedRange(result);
	}
}