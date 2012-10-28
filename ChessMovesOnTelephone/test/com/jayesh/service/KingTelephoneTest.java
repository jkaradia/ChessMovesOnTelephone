package com.jayesh.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.jayesh.model.Key;
import com.jayesh.model.King;

/**
 * Test Telephone Generation for King
 * @author jayesh
 * 
 */
public class KingTelephoneTest {

 

	@Test
	public void testKingStartingZeroToThreeDigits() {
	 

		Telephone t = new Telephone(); 
		
		t.setTargetTelephoneLength(3);
		t.setPiece(new King());
		t.setCurrentPosition(Key.ZERO);

		int length = t.generateTelephoneNumbers( );
		assertEquals(21, length);
	}
	
	@Test
	public void testKingStartingZeroToTenDigits() {
	 

		Telephone t = new Telephone();
		t.setTargetTelephoneLength(10); 
		t.setPiece(new King());
		t.setCurrentPosition(Key.ZERO);

		int length = t.generateTelephoneNumbers( );
		assertEquals(5697655, length);
	}
	
}
