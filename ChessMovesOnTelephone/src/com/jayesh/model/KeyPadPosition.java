package com.jayesh.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * X,Y Position of a keypad.
 */
public class KeyPadPosition {
	private final Integer x;
	private final Integer y;

	/**
	 * Constructor. Accepts two objects and constructs a pair. Neither can be
	 * null.
	 * 
	 */
	public KeyPadPosition(Integer left, Integer right) {
		this.x = left;
		this.y = right;
	}

	/**
	 * Returns true if the the two pairs are equal.
	 * 
	 * @param other
	 *            some other pair
	 * @return true if equal
	 */
	@Override
	public boolean equals(Object other) {
		boolean result = false;
		if (other instanceof KeyPadPosition) {
			KeyPadPosition that = (KeyPadPosition) other;
			result = new EqualsBuilder().append(this.x, that.x)
					.append(this.y, that.y).isEquals();
		}

		return result;
	}

	/**
	 * Returns a hash code for this pair
	 * 
	 * @return the hash code
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.x).append(this.y).toHashCode();
	}

	/**
	 * Returns the string form of this pair: "(left,right)"
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("(");
		sb.append(x.toString());
		sb.append(",");
		sb.append(y.toString());
		sb.append(")");
		return sb.toString();
	}

	public KeyPadPosition add(KeyPadPosition pair) {

		int newX = this.x + pair.x;
		int newY = this.y + pair.y;
		return new KeyPadPosition(newX, newY);
	}
}