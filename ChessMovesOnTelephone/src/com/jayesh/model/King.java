package com.jayesh.model;

import java.util.Collection;
import java.util.HashSet;

/**
 * Details Kings Piece Behaviour.
 * 
 * @author jayesh
 * 
 */
public class King extends Piece {

	private static Collection<KeyPadPosition> possibleMovesFromOrigin = null;

	/**
	 * Kings can move only one square in all direction. 
	 * 
	 * @param key
	 * 
	 * @return all possible positions from (0,0) a king can move.
	 */
	@Override
	public Collection<KeyPadPosition> getPossibleMovesFromOrigin(Key i) {
		if (possibleMovesFromOrigin == null) {
			possibleMovesFromOrigin = new HashSet<KeyPadPosition>();
			possibleMovesFromOrigin.add(new KeyPadPosition(0, 0));
			possibleMovesFromOrigin.add(new KeyPadPosition(1, 1));
			possibleMovesFromOrigin.add(new KeyPadPosition(-1, -1));
			possibleMovesFromOrigin.add(new KeyPadPosition(1, -1));
			possibleMovesFromOrigin.add(new KeyPadPosition(-1, 1));
			possibleMovesFromOrigin.add(new KeyPadPosition(0, 1));
			possibleMovesFromOrigin.add(new KeyPadPosition(1, 0));
			possibleMovesFromOrigin.add(new KeyPadPosition(0, -1));
			possibleMovesFromOrigin.add(new KeyPadPosition(-1, 0));
		}

		return possibleMovesFromOrigin;
	}

}
