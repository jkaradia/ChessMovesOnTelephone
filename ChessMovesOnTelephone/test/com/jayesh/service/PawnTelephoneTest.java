package com.jayesh.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
 
import com.jayesh.model.Key;
import com.jayesh.model.Pawn; 

/**
 * Test Telephone Generation for Pawn
 * @author jayesh
 * 
 */
public class PawnTelephoneTest {

	
	@Test
	public void testPawnStartingAtZerotoThreeDigits() { 

		Telephone t = new Telephone();
		t.setTargetTelephoneLength(3);
		t.setPiece(new Pawn());
		t.setCurrentPosition(Key.ZERO);
		t.setDisplayTelephone(true);

		int length = t.generateTelephoneNumbers( );
		assertEquals(6, length);
	}
	
	@Test
	public void testPawnStartingAtZerotoTenDigits() { 

		Telephone t = new Telephone();
		t.setTargetTelephoneLength(10);
		t.setPiece(new Pawn());
		t.setCurrentPosition(Key.ZERO);

		int length = t.generateTelephoneNumbers( );
		assertEquals(65266, length);
	}

	@Test
	public void testPawnStartingAtZerotoTwoDigits() { 

		Telephone t = new Telephone();
		t.setTargetTelephoneLength(2);
		t.setPiece(new Pawn());
		t.setCurrentPosition(Key.ZERO);

		int length = t.generateTelephoneNumbers( );
		assertEquals(3, length);
	}
	
	@Test
	public void testPawnStartingAtSevenToTwoDigits() { 

		Telephone t = new Telephone();
		t.setTargetTelephoneLength(2);
		t.setPiece(new Pawn());
		t.setCurrentPosition(Key.SEVEN);

		int length = t.generateTelephoneNumbers( );
		assertEquals(3, length);
	}
	
	@Test
	public void testPawnStartingAtNineToTwoDigits() { 

		Telephone t = new Telephone();
		t.setTargetTelephoneLength(2);
		t.setPiece(new Pawn());
		t.setCurrentPosition(Key.NINE);

		int length = t.generateTelephoneNumbers( );
		assertEquals(3, length);
	}
	
	@Test
	public void testPawnStartingAtEightToTwoDigits() { 

		Telephone t = new Telephone();
		t.setTargetTelephoneLength(2);
		t.setPiece(new Pawn());
		t.setCurrentPosition(Key.EIGHT);

		int length = t.generateTelephoneNumbers( );
		assertEquals(3, length);
	}
}
