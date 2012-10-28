
package com.jayesh.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.Map;

import org.junit.Test;

/**
 * Tests for KeyPad
 * @author jayesh
 *
 */
public class KeyPadTest {
	
	@Test
	public void testKeyPadMappings() {
		Map<Key, KeyPadPosition>  keyPadMappings = KeyPad.getKeyPadMappings();  
		assertEquals(10, keyPadMappings.size());
	}
	
	@Test
	public void testInverseKeyPadMappings() {
		Map<KeyPadPosition, Key>  inverseKeyPadMappings = KeyPad.getInverseKeyPadMappings();  
		assertEquals(10, inverseKeyPadMappings.size());
	}
	
	@Test
	public void testIsFirstTwoRow() {
		Collection<Key> firstTwoRowKeys = KeyPad.getFirstTwoRows();
		assertTrue(firstTwoRowKeys.contains(Key.ZERO));
		assertFalse(firstTwoRowKeys.contains(Key.ONE));
		assertFalse(firstTwoRowKeys.contains(Key.TWO));
		assertFalse(firstTwoRowKeys.contains(Key.THREE));	
		assertFalse(firstTwoRowKeys.contains(Key.FOUR));
		assertFalse(firstTwoRowKeys.contains(Key.FIVE));
		assertFalse(firstTwoRowKeys.contains(Key.SIX));
		assertTrue(firstTwoRowKeys.contains(Key.SEVEN));
		assertTrue(firstTwoRowKeys.contains(Key.EIGHT));
		assertTrue(firstTwoRowKeys.contains(Key.NINE));
		assertEquals(4,firstTwoRowKeys.size());
		
	}
	
	@Test
	public void testIsLastRow() {
		Collection<Key> thirdRowKeys = KeyPad.getLastRow();
		assertFalse(thirdRowKeys.contains(Key.ZERO));
		assertTrue(thirdRowKeys.contains(Key.ONE));
		assertTrue(thirdRowKeys.contains(Key.TWO));
		assertTrue(thirdRowKeys.contains(Key.THREE));	
		assertFalse(thirdRowKeys.contains(Key.FOUR));
		assertFalse(thirdRowKeys.contains(Key.FIVE));
		assertFalse(thirdRowKeys.contains(Key.SIX));
		assertFalse(thirdRowKeys.contains(Key.SEVEN));
		assertFalse(thirdRowKeys.contains(Key.EIGHT));
		assertFalse(thirdRowKeys.contains(Key.NINE));
		assertEquals(3,thirdRowKeys.size());
		
	}
	
	@Test
	public void testIsSevenFirstTwoRow() {
		assertTrue(KeyPad.isFirstTwoRows(Key.SEVEN));
	}
	
	@Test
	public void testIsFiveFirstTwoRow() {
		assertFalse(KeyPad.isFirstTwoRows(Key.FIVE));
	}
	
	@Test
	public void testIsOneLastRow() {
		assertTrue(KeyPad.isLastRow(Key.ONE));
	}
	
	@Test
	public void testIsSevenLastRow() {
		assertFalse(KeyPad.isLastRow(Key.SEVEN));
	}
	
	@Test
	public void testALL_KEY_SIZE() {
		assertEquals(10, KeyPad.ALL_KEYS.length);	
	}

}
