package com.jayesh.model;

import java.util.Collection;
import java.util.HashSet;

/**
 * Details Bishop Piece behaviour.
 * @author jayesh
 * 
 */
final public class Bishop extends Piece {

	private Collection<KeyPadPosition> possibleMovesFromOrigin = null;

	/**
	 * Bishops can move diagonally.
	 * it is sufficient, for a 3x4 Keypad just to consider movement of upto three squares.
	 * 
	 * @param key
	 * 
	 * @return all possible positions from (0,0) a bishop can move.
	 */
	@Override
	public Collection<KeyPadPosition> getPossibleMovesFromOrigin(Key ikey) {
		if (possibleMovesFromOrigin == null) {
			possibleMovesFromOrigin = new HashSet<KeyPadPosition>();			
			possibleMovesFromOrigin.add(new KeyPadPosition(0, 0));
			possibleMovesFromOrigin.add(new KeyPadPosition(1, 1));
			possibleMovesFromOrigin.add(new KeyPadPosition(2, 2));
			possibleMovesFromOrigin.add(new KeyPadPosition(3, 3));
			possibleMovesFromOrigin.add(new KeyPadPosition(-1, -1));
			possibleMovesFromOrigin.add(new KeyPadPosition(-2, -2));
			possibleMovesFromOrigin.add(new KeyPadPosition(-3, -3));
			possibleMovesFromOrigin.add(new KeyPadPosition(1, -1));
			possibleMovesFromOrigin.add(new KeyPadPosition(2, -2));
			possibleMovesFromOrigin.add(new KeyPadPosition(3, -3));
			possibleMovesFromOrigin.add(new KeyPadPosition(-1, 1));
			possibleMovesFromOrigin.add(new KeyPadPosition(-2, 2));
			possibleMovesFromOrigin.add(new KeyPadPosition(-3, 3));

		}

		return possibleMovesFromOrigin;
	}

}
