package com.jayesh.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * A single position on the keypad.
 * Abstract view of the keypad.
 */
final public class Key {
	private final char c;

	/**
	 * Only defining valid keys.
	 */
	public static final Key ONE = new Key('1');
	public static final Key TWO = new Key('2');
	public static final Key THREE = new Key('3');
	public static final Key FOUR = new Key('4');
	public static final Key FIVE = new Key('5');
	public static final Key SIX = new Key('6');
	public static final Key SEVEN = new Key('7');
	public static final Key EIGHT = new Key('8');
	public static final Key NINE = new Key('9');
	public static final Key ZERO = new Key('0');

	/**
	 * Constructor.
	 * 
	 */
	private Key(char x) {
		this.c = x;
	}

	/**
	 * Returns true if the the two keys are equal.
	 * 
	 * @param other
	 *            some other key
	 * @return true if equal
	 */
	@Override
	public boolean equals(Object other) {
		boolean result = false;
		if (other instanceof Key) {
			Key that = (Key) other;
			result = new EqualsBuilder().append(this.c, that.c).isEquals();
		}

		return result;
	}

	/**
	 * Returns a hash code for this key
	 * 
	 * @return the hash code
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.c).toHashCode();
	}

	/**
	 * Returns the string form of this key.
	 */
	@Override
	public String toString() {
		return String.valueOf(c);
	}

}