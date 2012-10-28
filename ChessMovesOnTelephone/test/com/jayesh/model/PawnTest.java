package com.jayesh.model;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.Test;


/**
 * Test for Pawn
 * @author jayesh
 *
 */
public class PawnTest {
	
	final private static int FIRST_MOVE = 1;
	
	@Test
	public void testPawnPostionsFromZero() {
		Piece pawn = new Pawn(); 
		Collection<Key> allPossibleMove  = pawn.getAllPossibleMoves(Key.ZERO, FIRST_MOVE);
		assertEquals(3,allPossibleMove.size());
	}
	
	@Test
	public void testPawnPostionsFromSeven() {
		Piece pawn = new Pawn();  
		Collection<Key> allPossibleMove  = pawn.getAllPossibleMoves(Key.SEVEN, FIRST_MOVE);
		assertEquals(3,allPossibleMove.size());
	}
	
	@Test
	public void testPawnPostionsFromEight() {
		Piece pawn = new Pawn();  
		Collection<Key> allPossibleMove  = pawn.getAllPossibleMoves(Key.EIGHT, FIRST_MOVE);
		assertEquals(3,allPossibleMove.size());
	}
	@Test
	public void testPawnPostionsFromFive() {
		Piece pawn = new Pawn(); 
		Collection<Key> allPossibleMove  = pawn.getAllPossibleMoves(Key.FIVE, FIRST_MOVE);
		assertEquals(2,allPossibleMove.size());
	}
	
	@Test
	public void testPawnPostionsFromOne() {
		Piece pawn = new Pawn(); 
		Collection<Key> allPossibleMove  = pawn.getAllPossibleMoves(Key.ONE, FIRST_MOVE);
		assertEquals(7,allPossibleMove.size());
	}
	
	 
}
