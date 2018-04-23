package com.program.model;

/**
 * 
 * ZipCodeRange to store the lower and higher range
 *
 */
public class ZipCodeRange {
	private int low;
	private int high;

	public ZipCodeRange(int low, int high) {
		this.low = low;
		this.high = high;
	}
































	public int getLow() {
		return low;
	}





	public void setLow(int low) {
		this.low = low;
	}

	public int getHigh() {
		return high;
	}

	public void setHigh(int high) {
		this.high = high;
	}

	@Override
	public String toString() {
		return "[" + low + ", " + high + "]";
	}
}