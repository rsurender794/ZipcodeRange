package com.program;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import com.program.model.ZipCodeRange;
import com.program.service.ZipCodeService;
import com.program.service.ZipCodeServiceImpl;

/**
 * 
 * Main program
 *
 */
public class ZipCodeProgram {
	private static final Logger log = Logger.getLogger(ZipCodeProgram.class);

	public static void main(String[] args) {
		String sampleInput = "[94133,94133] [94200,94299] [94600,94699]";
		if (args.length == 0) {
			log.error("Please provide input in the format : " + sampleInput);
		} else {
			processInput(args, sampleInput);
		}
	}

	private static void processInput(String[] args, String sampleInput) {
		String[] input = args;
		try {
			log.debug("Input is " + Arrays.toString(input));
			ZipCodeService service = new ZipCodeServiceImpl();
			List<ZipCodeRange> finalResult = service.processZipCodes(input);
			log.debug("Minimum number of ranges required to represent the same restrictions as the input : ");
			StringBuilder builder = new StringBuilder("");
			for (ZipCodeRange zipCode : finalResult) {
				builder.append("[" + zipCode.getLow() + "," + zipCode.getHigh() + "] ");
			}
			log.debug(builder);
		} catch (Exception e) {
			log.error("Input - " + input + " is not valid, please provide in the format : " + sampleInput);
		}
	}
}