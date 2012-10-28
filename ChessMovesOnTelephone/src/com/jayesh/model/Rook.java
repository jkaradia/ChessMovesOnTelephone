package com.jayesh.model;

import java.util.Collection;
import java.util.HashSet;

/**
 * Describes the movments of a Rook
 * @author jayesh
 * 
 */
public class Rook extends Piece {

	protected static Collection<KeyPadPosition> possibleMovesFromOrigin = new HashSet<KeyPadPosition>();

	/**
	 * Rook can move up and down. It is sufficient, for a 3x4 Keypad just to
	 * consider movement of up to three squares across but up to four squares up
	 * as the queen might be on a '0' key and would be able to move four squares
	 * up to a '2'
	 * 
	 * @param key
	 * 
	 * @return all possible positions from (0,0) a rook can move.
	 */
	@Override
	public Collection<KeyPadPosition> getPossibleMovesFromOrigin(Key i) {
		if (possibleMovesFromOrigin.isEmpty()) {
			possibleMovesFromOrigin.add(new KeyPadPosition(0, 0));
			possibleMovesFromOrigin.add(new KeyPadPosition(0, 1));
			possibleMovesFromOrigin.add(new KeyPadPosition(0, 2));
			possibleMovesFromOrigin.add(new KeyPadPosition(0, 3));
			possibleMovesFromOrigin.add(new KeyPadPosition(1, 0));
			possibleMovesFromOrigin.add(new KeyPadPosition(2, 0));
			possibleMovesFromOrigin.add(new KeyPadPosition(3, 0));
			possibleMovesFromOrigin.add(new KeyPadPosition(0, -1));
			possibleMovesFromOrigin.add(new KeyPadPosition(0, -2));
			possibleMovesFromOrigin.add(new KeyPadPosition(0, -3));
			possibleMovesFromOrigin.add(new KeyPadPosition(-1, 0));
			possibleMovesFromOrigin.add(new KeyPadPosition(-2, 0));
			possibleMovesFromOrigin.add(new KeyPadPosition(-3, 0));
			
			// Moving up to fours squares down which is possible from '2' to '0'
			possibleMovesFromOrigin.add(new KeyPadPosition(0, -4));

			// Moving up to fours squares down which is possible from '0' to '4'
			possibleMovesFromOrigin.add(new KeyPadPosition(0, 4));
		}

		return possibleMovesFromOrigin;
	}

}
