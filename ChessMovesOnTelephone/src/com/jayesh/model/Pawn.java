package com.jayesh.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Describes a Pawn movement. A pawn can only move one square forward at a time.
 * It can move two squares if it is the first move and starts on square 7,8,9 or
 * 0 On the last row the pawn is automatically promoted to a queen and so will
 * progress as if it was a queen.
 * 
 * @author jayesh
 * 
 */
public class Pawn extends Piece {

	private static KeyPadPosition STAY_STILL = new KeyPadPosition(0, 0);
	private static KeyPadPosition ONE_STEP_FORWARD = new KeyPadPosition(0, 1);
	private static KeyPadPosition TWO_STEPS_FORWARD = new KeyPadPosition(0, 2);

	private Collection<KeyPadPosition> possibleStandardMovesFromOrigin = null;

	/**
	 * Defines a standard one square at a movement from the (0,0) position
	 */
	private Collection<KeyPadPosition> getStandardPossibleMovesFromCentre() {
		if (possibleStandardMovesFromOrigin == null) {
			possibleStandardMovesFromOrigin = new HashSet<KeyPadPosition>();
			possibleStandardMovesFromOrigin.add(STAY_STILL);
			possibleStandardMovesFromOrigin.add(ONE_STEP_FORWARD);
		}

		return possibleStandardMovesFromOrigin;
	}

	/**
	 * Defines movement when pawn is promoted to queen and behaves like a queen.
	 * This is lazily instantiated because it might not be needed.
	 */
	private Collection<KeyPadPosition> possibleMovesWhenPromoted = null;

	private Collection<KeyPadPosition> getPossibleMovesWhenPromoted(
			Key currentKey) {
		if (possibleMovesWhenPromoted == null) {
			possibleMovesWhenPromoted = new HashSet<KeyPadPosition>();

			// Create a Queen so that we can use its behaviour.
			Piece queen = new Queen();
			possibleMovesWhenPromoted = queen
					.getPossibleMovesFromOrigin(currentKey);
		}

		return possibleMovesWhenPromoted;
	}

	/**
	 * If the pawn is on the last row it can be promoted to a queen?
	 * 
	 * @param currentKey
	 * @return true if is on the last row.
	 */
	private boolean isChangeToQueenOnPromotionRow(Key currentKey) {
		return KeyPad.isLastRow(currentKey);

	}

	/**
	 * As a pawn's behaviour can change depending on the state of the movement
	 * the standard method has to be to overridden.
	 * 
	 * This handles the standard one square movement and queen promotion.
	 * 
	 * @see getAllPossibleMoves which handles the first move behaviour if on the
	 *      first two rows.
	 * 
	 * @param key
	 * 
	 * @return either the movement of a queen or the single square movement.
	 * 
	 */
	@Override
	protected Collection<KeyPadPosition> getPossibleMovesFromOrigin(
			Key currentKey) {
		Collection<KeyPadPosition> possibleMovesFromOrigin = null;
		if (isChangeToQueenOnPromotionRow(currentKey)) {
			possibleMovesFromOrigin = getPossibleMovesWhenPromoted(currentKey);
		} else {
			possibleMovesFromOrigin = getStandardPossibleMovesFromCentre();
		}
		return possibleMovesFromOrigin;

	}

	/**
	 * Create a two square forward position
	 * 
	 * @param currentKey
	 * @return a Key that is two squares forward.
	 */
	private Key createTwoStepForwardFromCurrentKey(Key currentKey) {
		KeyPadPosition currentPosition = KeyPad.getPosition(currentKey);
		KeyPadPosition newPosition = currentPosition.add(TWO_STEPS_FORWARD);
		return KeyPad.getKey(newPosition);
	}

	/**
	 * Method that adds values to the position cache for the two move possible
	 * on the first move.
	 * 
	 * @param currentKey
	 *            where is the piece now
	 */

	public void addTwoStepForwardToPositionCache(Key currentKey) {

		Key newKey = createTwoStepForwardFromCurrentKey(currentKey);

		// Gets current values stored with key and adds the extra position
		Set<Key> currentKeyMapping = positionCache.get(currentKey);
		currentKeyMapping.add(newKey);
		positionCache.put(currentKey, currentKeyMapping);
	}

	/**
	 * Method that removes values from the position cache for the two move
	 * possible after the first move.
	 * 
	 * @param currentKey
	 *            where is the piece now
	 */
	private void removeTwoStepForwardFromPositionCache(Key currentKey) {

		// Create a two square forward position
		Key newKey =createTwoStepForwardFromCurrentKey(currentKey);

		// Gets current values stored with key and adds the extra position
		Set<Key> currentKeyMapping = positionCache.get(currentKey);

		// Remove key if it exists
		if (currentKeyMapping.contains(newKey)) {
			currentKeyMapping.remove(newKey);
		}

		positionCache.put(currentKey, currentKeyMapping);
	}

	/**
	 * Use the current length of the phone number to determine whether this is
	 * the first key.
	 * 
	 * @param numberGeneratedSoFarLength
	 * 
	 * @return true if it is the first move.
	 */
	private boolean isFirstMove(int numberGeneratedSoFarLength) {
		return numberGeneratedSoFarLength == 1;
	}

	/**
	 * Use the current length of the phone number to determine whether this is
	 * after the first move.
	 * 
	 * @param numberGeneratedSoFarLength
	 * 
	 * @return true if after the first move.
	 */
	private boolean isSecondMove(int numberGeneratedSoFarLength) {
		return numberGeneratedSoFarLength == 2;
	}

	/**
	 * Returns an updated position cache. If the pawn is on the first two rows
	 * and on the first move then adds a two move possibility
	 * 
	 * If on the first two rows but on the second move remove the two move
	 * choice
	 * 
	 * @returns a position cache.
	 */

	public Collection<Key> getAllPossibleMoves(Key currentKey,
			int numberGeneratedSoFarLength) {

		if (KeyPad.isFirstTwoRows(currentKey)) {
			if (isFirstMove(numberGeneratedSoFarLength)) {
				addTwoStepForwardToPositionCache(currentKey);
			} else if (isSecondMove(numberGeneratedSoFarLength)) {
				removeTwoStepForwardFromPositionCache(currentKey);
			}
		}

		return positionCache.get(currentKey);
	}
}
