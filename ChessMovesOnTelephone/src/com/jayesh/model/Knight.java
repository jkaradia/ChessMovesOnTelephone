package com.jayesh.model;

import java.util.Collection;
import java.util.HashSet;

/**
 * Details Knight Piece Behaviour.
 * 
 * @author jayesh
 * 
 */
public class Knight extends Piece {

	protected static Collection<KeyPadPosition> possibleMovesFromOrigin = new HashSet<KeyPadPosition>();

	/**
	 * Describles a Knights L-shaped movements possible from a (0,0)
	 * 
	 * @param key
	 * 
	 * @return all possible positions from (0,0) a knight can move.
	 */
	@Override
	public Collection<KeyPadPosition> getPossibleMovesFromOrigin(Key i) {
		if (possibleMovesFromOrigin.isEmpty()) {
			possibleMovesFromOrigin.add(new KeyPadPosition(0, 0));
			possibleMovesFromOrigin.add(new KeyPadPosition(2, 1));
			possibleMovesFromOrigin.add(new KeyPadPosition(2, -1));
			possibleMovesFromOrigin.add(new KeyPadPosition(-2, 1));
			possibleMovesFromOrigin.add(new KeyPadPosition(-2, -1));
			possibleMovesFromOrigin.add(new KeyPadPosition(1, 2));
			possibleMovesFromOrigin.add(new KeyPadPosition(1, -2));
			possibleMovesFromOrigin.add(new KeyPadPosition(-1, 2));
			possibleMovesFromOrigin.add(new KeyPadPosition(-1, -2));

		}

		return possibleMovesFromOrigin;
	}

}
