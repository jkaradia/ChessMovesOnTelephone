
package com.jayesh.model;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.Test;


/**
 * Test Case for Bishop
 * @author jayesh
 *
 */
public class BishopTest  {
	 
	final private static int FIRST_MOVE = 1;

	@Test
	public void testBishopPostionsFromZero() {
		Piece bishop = new Bishop();
		Collection<Key> allPossibleMove  = bishop.getAllPossibleMoves(Key.ZERO, FIRST_MOVE);
		assertEquals(3,allPossibleMove.size());
	}
	
	@Test
	public void testBishopPostionsFromOne() {
		Piece bishop = new Bishop(); 
		Collection<Key> allPossibleMove  = bishop.getAllPossibleMoves(Key.ONE, FIRST_MOVE);
		assertEquals(3,allPossibleMove.size());
	}
	
	@Test
	public void testBishopPostionsFromFive() {
		Piece bishop = new Bishop(); 
		Collection<Key> allPossibleMove  = bishop.getAllPossibleMoves(Key.FIVE, FIRST_MOVE);
		assertEquals(5,allPossibleMove.size());
	}
	
	 
}
