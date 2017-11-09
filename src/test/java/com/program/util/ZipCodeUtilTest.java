package com.program.util;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.program.exception.InvalidInputFormat;
import com.program.model.ZipCodeRange;

public class ZipCodeUtilTest {
	@Test
	public void testGetZipCodeRangeWithValidInput() throws Exception {
		String[] splits = { "[94200", "94299]" };
		ZipCodeRange zipCodeRange = ZipCodeUtil.getZipCodeRange(splits);

		assertNotNull(zipCodeRange);
		assertThat(94200, is(zipCodeRange.getLow()));
		assertThat(94299, is(zipCodeRange.getHigh()));
	}

	@Test
	public void testGetZipCodeRangeWithInputReversed() throws Exception {
		String[] splits = { "[94299", "94200]" };
		ZipCodeRange zipCodeRange = ZipCodeUtil.getZipCodeRange(splits);

		assertNotNull(zipCodeRange);
		assertThat(94200, is(zipCodeRange.getLow()));
		assertThat(94299, is(zipCodeRange.getHigh()));
	}

	@Test(expected = InvalidInputFormat.class)
	public void testGetZipCodeRangeWithInValidInput() throws Exception {
		String[] splits = { "94200]", "[94299" };
		ZipCodeUtil.getZipCodeRange(splits);
	}

	@Test
	public void testGetValue() throws Exception {
		String input = "[94200";
		int result = ZipCodeUtil.getValue(input, 1, input.length());

		assertThat(94200, is(result));

		input = "94299]";
		result = ZipCodeUtil.getValue(input, 0, input.length() - 1);

		assertThat(94299, is(result));
	}

	@Test(expected = NumberFormatException.class)
	public void testGetValueInvalidInput() throws Exception {
		String input = "Hello";
		ZipCodeUtil.getValue(input, 1, input.length());
	}

	@Test
	public void testGetRestrictedRange() {
		List<ZipCodeRange> input = new ArrayList<>();
		input.add(new ZipCodeRange(94133, 94133));
		input.add(new ZipCodeRange(94200, 94299));
		input.add(new ZipCodeRange(94226, 94399));

		List<ZipCodeRange> result = ZipCodeUtil.getRestrictedRange(input);
		assertThat(2, is(result.size()));
		assertThat(94133, is(result.get(0).getLow()));
		assertThat(94133, is(result.get(0).getHigh()));
		assertThat(94200, is(result.get(1).getLow()));
		assertThat(94399, is(result.get(1).getHigh()));
	}

	@Test
	public void testGetRestrictedRangeWithInvalidInput() {
		List<ZipCodeRange> input = new ArrayList<>();
		List<ZipCodeRange> result = ZipCodeUtil.getRestrictedRange(input);
		assertNull(result);
	}
}