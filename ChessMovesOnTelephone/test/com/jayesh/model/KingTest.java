/**
 * 
 */
package com.jayesh.model;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.Test;


/**
 * Tests for King
 * @author jayesh
 *
 */
public class KingTest {
	final private static int FIRST_MOVE = 1;

	@Test
	public void testKingPostionsFromZero() {
		Piece king = new King(); 
		Collection<Key> allPossibleMove  = king.getAllPossibleMoves(Key.ZERO, FIRST_MOVE);
		assertEquals(4,allPossibleMove.size());
	}
	
	@Test
	public void testKingPostionsFromSeven() {
		Piece king = new King(); 
		Collection<Key> allPossibleMove  = king.getAllPossibleMoves(Key.SEVEN,FIRST_MOVE);
		assertEquals(5,allPossibleMove.size());
	}
	
	@Test
	public void testKingPostionsFromFive() {
		Piece king = new King(); 
		Collection<Key> allPossibleMove  = king.getAllPossibleMoves(Key.FIVE,FIRST_MOVE);
		assertEquals(9,allPossibleMove.size());
	}
	
	 
}
