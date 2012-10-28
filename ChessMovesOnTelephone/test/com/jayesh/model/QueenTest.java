package com.jayesh.model;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.Test;

/**
 * Test for Queen
 * 
 * @author jayesh
 * 
 */
public class QueenTest {

	final private static int FIRST_MOVE = 1;

	@Test
	public void testQueenPostionsFromZero() {
		Piece queen = new Queen();
		Collection<Key> allPossibleMove = queen.getAllPossibleMoves(Key.ZERO,
				FIRST_MOVE);
		assertEquals(6, allPossibleMove.size());
	}

	@Test
	public void testQueenPostionsFromSeven() {
		Piece queen = new Queen();
		Collection<Key> allPossibleMove = queen.getAllPossibleMoves(Key.SEVEN,
				FIRST_MOVE);
		assertEquals(8, allPossibleMove.size());
	}

	@Test
	public void testQueenPostionsFromFive() {
		Piece queen = new Queen();
		Collection<Key> allPossibleMove = queen.getAllPossibleMoves(Key.FIVE,
				FIRST_MOVE);
		assertEquals(10, allPossibleMove.size());
	}

}
