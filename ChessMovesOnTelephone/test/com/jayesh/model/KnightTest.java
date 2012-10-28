
package com.jayesh.model;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.Test;


/**
 * Tests for Knight
 * @author jayesh
 *
 */
public class KnightTest {
	final private static int FIRST_MOVE = 1;


	@Test
	public void testKnightPostionsFromZero() {
		Piece knight = new Knight(); 
		Collection<Key> allPossibleMove  = knight.getAllPossibleMoves(Key.ZERO, FIRST_MOVE);
		assertEquals(3,allPossibleMove.size());
	}
	
	@Test
	public void testKnightPostionsFromOne() {
		Piece knight = new Knight(); 
		Collection<Key> allPossibleMove  = knight.getAllPossibleMoves(Key.ONE, FIRST_MOVE);
		assertEquals(3,allPossibleMove.size());
	}
	
	@Test
	public void testKnightPostionsFromFive() {
		Piece knight = new Knight(); 
		Collection<Key> allPossibleMove  = knight.getAllPossibleMoves(Key.FIVE, FIRST_MOVE);
		assertEquals(1,allPossibleMove.size());
	}
	
	@Test
	public void testKnightPostionsFromNine() {
		Piece knight = new Knight(); 
		Collection<Key> allPossibleMove  = knight.getAllPossibleMoves(Key.NINE, FIRST_MOVE);
		assertEquals(3,allPossibleMove.size());
	}
	
	@Test
	public void testKnightPostionsFromEight() {
		Piece knight = new Knight(); 
		Collection<Key> allPossibleMove  = knight.getAllPossibleMoves(Key.EIGHT, FIRST_MOVE);
		assertEquals(3,allPossibleMove.size());
	}
	 
}
