package com.jayesh.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.jayesh.model.Key;
import com.jayesh.model.Queen;

/**
 * Test Telephone generation for Queen.
 * @author jayesh
 * 
 */
public class QueenTelephoneTest {
	
	@Test
	public void testQueenStartingAtFivetoThreeDigits() {
		 

		Telephone t = new Telephone();
		t.setTargetTelephoneLength(3); 
		t.setPiece(new Queen());
		t.setCurrentPosition(Key.FIVE);

		int length = t.generateTelephoneNumbers( );
		assertEquals(76, length);
	}
	
	@Test
	public void testQueenStartingAtFivetoSixDigits() {
		 

		Telephone t = new Telephone();
		t.setTargetTelephoneLength(6);
		t.setPiece(new Queen()); 
		t.setCurrentPosition(Key.FIVE);
		int length = t.generateTelephoneNumbers( );
		assertEquals(35066, length);
	}
	
	@Test
	public void testQueenStartingAtFivetoEightDigits() {

		Telephone t = new Telephone();
		t.setTargetTelephoneLength(8);
		t.setPiece(new Queen());
		t.setCurrentPosition(Key.FIVE); 
		
		int length = t.generateTelephoneNumbers( );
		assertEquals(2091676, length);
	}
	
	@Test
	public void testQueenStartingAtFivetoTenDigits() { 

		Telephone t = new Telephone();
		t.setTargetTelephoneLength(10);
		t.setPiece(new Queen());
		t.setCurrentPosition(Key.FIVE); 
		
		int length = t.generateTelephoneNumbers( );
		assertEquals(124768940, length);
	}
	
}
