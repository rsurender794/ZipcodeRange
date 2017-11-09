package com.program.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.program.model.ZipCodeRange;

public class ZipCodeReaderTest {
	private ZipCodeService service;

	@Before
	public void init() {
		service = new ZipCodeServiceImpl();
	}

	@Test
	public void testReadZipCodes() throws Exception {
		String[] input = { "[94133,94133]", "[94200,94299]", "[94226,94399]" };
		List<ZipCodeRange> zipCodes = service.getZipCodeList(input);

		assertNotNull(zipCodes);
		assertThat(3, is(zipCodes.size()));
		assertThat(94226, is(zipCodes.get(2).getLow()));
		assertThat(94399, is(zipCodes.get(2).getHigh()));
	}

	@Test
	public void testGetZipCodeRangeWithValidInput() throws Exception {
		String[] input = { "[94133,94133]", "[94200,94299]", "[94226,94399]" };
		List<ZipCodeRange> zipCodes = service.processZipCodes(input);

		assertNotNull(zipCodes);
		assertThat(2, is(zipCodes.size()));
		assertThat(94200, is(zipCodes.get(1).getLow()));
		assertThat(94399, is(zipCodes.get(1).getHigh()));
	}
}