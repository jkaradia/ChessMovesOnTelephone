package com.jayesh.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Super class for all pieces.
 * Generates cache of all possible keys from a particular square.
 * by mapping the movement from the origin (0,0) onto the keypad.
 * 
 * @author jayesh
 *
 */
public abstract class Piece {

	/**
	 * Cache of all possible positions from a particular key.
	 */
	protected Map<Key, Set<Key>> positionCache = new HashMap<Key, Set<Key>>();

	/**
	 * Constructor loads up cache.
	 */
	public Piece() {
		super();
		populateAllPossibleMovesIntoCache();
	}

	/**
	 * Loads up cache
	 */
	private void populateAllPossibleMovesIntoCache() {
		
		//Populate all keys one at a time.
		for (Key key : KeyPad.ALL_KEYS) {
			KeyPadPosition currentPosition = KeyPad.getPosition(key);
			Set<Key> results = new HashSet<Key>();
			for (KeyPadPosition keyMove : getPossibleMovesFromOrigin(key)) {		
				KeyPadPosition newPosition = currentPosition.add(keyMove);				
				//newPair might be off the keypad so we need to know whether we can use it
				if (KeyPad.isValidPair(newPosition)) {
					Key newKey = KeyPad.getKey(newPosition);
					results.add(newKey);
				}
			}
			positionCache.put(key, results);
		}
	}


	/**
	 * Gets the possible translations from the origin which can be added to the key position 
	 * to get a new key position.
	 * 
	 * @param currentKey
	 * 
	 * @return a Collection of translations from (0,0)
	 */
	abstract protected Collection<KeyPadPosition> getPossibleMovesFromOrigin(
			Key currentKey);
	
	/**
	 * Uses position cache to return all possible choices from a particular key for this piece.
	 * 
	 * @param currentKey
	 * @param numberGeneatedSoFarLength
	 * 
	 * @return The cached value for the key.
	 */
	public Collection<Key> getAllPossibleMoves(Key currentKey,
			int numberGeneatedSoFarLength) {
		//There is no need to do a null check as the cache should be populated.
		return positionCache.get(currentKey);
	}

}
