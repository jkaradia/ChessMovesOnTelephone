package com.jayesh.model;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.Test;


/**
 * Test for Rook.
 * @author jayesh
 *
 */
public class RookTest {
	final private static int FIRST_MOVE = 1;


	@Test
	public void testRookPostionsFromZero() {
		Piece rook = new Rook(); 
		Collection<Key> allPossibleMove  = rook.getAllPossibleMoves(Key.ZERO, FIRST_MOVE);
		assertEquals(4,allPossibleMove.size());
	}
	
	@Test
	public void testRookPostionsFromOne() {
		Piece rook = new Rook(); 
		Collection<Key> allPossibleMove  = rook.getAllPossibleMoves(Key.ONE, FIRST_MOVE);
		assertEquals(5,allPossibleMove.size());
	}
	
	@Test
	public void testRookPostionsFromFive() {
		Piece rook = new Rook(); 
		Collection<Key> allPossibleMove  = rook.getAllPossibleMoves(Key.FIVE, FIRST_MOVE);
		assertEquals(6,allPossibleMove.size());
	}
	
	 
}
