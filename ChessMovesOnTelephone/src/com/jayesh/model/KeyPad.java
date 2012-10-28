package com.jayesh.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Defines positions on the keypad where pieces can move.
 *  Representation of the telephone pad.
 *  
 *  This classes manages the abstract->representation (key->key pad position) mapping
 * @author jayesh
 *
 */
final public class KeyPad {

	/**
	 * Constructor
	 * Creating a private constructor so that an instance of this class cannot be created
	 */
	private KeyPad() {
		/* Intentionally left empty */
	}

	/**
	 * All keys that exist on this Key Pad
	 */

	public static final Key ALL_KEYS[] = new Key[] { Key.ZERO, Key.ONE,
			Key.TWO, Key.THREE, Key.FOUR, Key.FIVE, Key.SIX, Key.SEVEN,
			Key.EIGHT, Key.NINE };
	
	/**
	 * Define the Key->KepPadPosition Mapping
	 */
	static private Map<Key, KeyPadPosition> KEYPAD_MAPPINGS = new HashMap<Key, KeyPadPosition>();

	public static Map<Key, KeyPadPosition> getKeyPadMappings() {
		return KEYPAD_MAPPINGS;
	}
	
	static {
		KEYPAD_MAPPINGS.put(Key.ZERO, new KeyPadPosition(2, 1));
		KEYPAD_MAPPINGS.put(Key.ONE, new KeyPadPosition(1, 4));
		KEYPAD_MAPPINGS.put(Key.TWO, new KeyPadPosition(2, 4));
		KEYPAD_MAPPINGS.put(Key.THREE, new KeyPadPosition(3, 4));
		KEYPAD_MAPPINGS.put(Key.FOUR, new KeyPadPosition(1, 3));
		KEYPAD_MAPPINGS.put(Key.FIVE, new KeyPadPosition(2, 3));
		KEYPAD_MAPPINGS.put(Key.SIX, new KeyPadPosition(3, 3));
		KEYPAD_MAPPINGS.put(Key.SEVEN, new KeyPadPosition(1, 2));
		KEYPAD_MAPPINGS.put(Key.EIGHT, new KeyPadPosition(2, 2));
		KEYPAD_MAPPINGS.put(Key.NINE, new KeyPadPosition(3, 2));
	}

	/**
	 * Gets a position from a Key.
	 * @param key
	 * @return
	 */
	public static KeyPadPosition getPosition(Key key) {
		return KEYPAD_MAPPINGS.get(key);

	}

	/**
	 * Defines a KeyPadPosition->KeyPad mapping.
	 * Rather than use a bi-directional implemented and managed an inverse map manually.
	 */
	static private Map<KeyPadPosition, Key> INVERSE_KEYPAD_MAPPINGS = new HashMap<KeyPadPosition, Key>();

	static {
		for (Key key : KEYPAD_MAPPINGS.keySet()) {
			INVERSE_KEYPAD_MAPPINGS.put(KEYPAD_MAPPINGS.get(key), key);
		}
	}

	public static Map<KeyPadPosition, Key> getInverseKeyPadMappings() {
		return INVERSE_KEYPAD_MAPPINGS;
	}

	public static Key getKey(KeyPadPosition p) {
		return INVERSE_KEYPAD_MAPPINGS.get(p);
	}

	/**
	 * Is the pair position on the key pad?
	 * @param pair
	 * @return true if it is on the keypad.
	 */
	public static boolean isValidPair(KeyPadPosition pair) {
		return KeyPad.getKey(pair) != null;
	}

	/**
	 * Some pieces behave differently on the first few rows so these need to be defined.
	 */
	static private Collection<Key> FIRST_TWO_ROWS = new HashSet<Key>();

	public static Collection<Key> getFirstTwoRows() {
		return FIRST_TWO_ROWS;
	}

	static {
		FIRST_TWO_ROWS.add(Key.ZERO);
		FIRST_TWO_ROWS.add(Key.SEVEN);
		FIRST_TWO_ROWS.add(Key.EIGHT);
		FIRST_TWO_ROWS.add(Key.NINE);
	}
	
	/**
	 * Are we on the first two rows?
	 * @param key
	 * @return true if on the first two rows.
	 */
	public static boolean isFirstTwoRows(Key key) {
		return FIRST_TWO_ROWS.contains(key);
	}

	/**
	 * Some pieces behave differently on the the last row.
	 */
	static private Collection<Key> LAST_ROW = new HashSet<Key>();

	public static Collection<Key> getLastRow() {
		return LAST_ROW;
	}

	static {
		LAST_ROW.add(Key.ONE);
		LAST_ROW.add(Key.TWO);
		LAST_ROW.add(Key.THREE);
	}

	

	/**
	 * Are we on the last row?
	 * @param key
	 * @return true if on the last row.
	 */
	public static boolean isLastRow(Key key) {
		return LAST_ROW.contains(key);
	}
}
