package com.jayesh.service;

import java.util.Collection;
import java.util.logging.Logger;

import com.jayesh.model.Key;
import com.jayesh.model.Piece;
import com.jayesh.model.Queen;

/**
 * Encapsulates algorithm that generates numbers using the pieces and key pad
 * structure defined in com.jayesh.model
 * 
 * @author jayesh
 * 
 */
public class Telephone {
	private static final Logger logger = Logger.getLogger(Telephone.class
			.getName());

	/**
	 * Values used to parameterize algorithm.
	 */
	private Piece piece = null;
	private int targetTelephoneLength;
	private Key currentPosition;
	private boolean isDisplayTelephone = false;

	private int numbersGeneratedInTotal = 0;

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public boolean isDisplayTelephone() {
		return isDisplayTelephone;
	}

	public void setDisplayTelephone(boolean isDisplayTelephone) {
		this.isDisplayTelephone = isDisplayTelephone;
	}

	public Key getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(Key currentPosition) {
		this.currentPosition = currentPosition;
	}

	public int getTargetTelephoneLength() {
		return targetTelephoneLength;
	}

	public void setTargetTelephoneLength(int telephoneLength) {
		this.targetTelephoneLength = telephoneLength;
	}

	/**
	 * Generate Telephone Number.
	 * 
	 * Implements a Depth First Search recursively §so that full numbers are generated before
	 * moving onto another branch.
	 * 
	 * @param currentKey
	 * @param telephoneNumberCreatedSoFar
	 * 
	 * @return number of telephone numbers generated.
	 */
	private int generateTelephoneNumbers(Key currentKey,
			String telephoneNumberCreatedSoFar) {

		telephoneNumberCreatedSoFar += currentKey;
		
		//Define exit condition for recursion
		// When we reach the target telephone number length
		int lengthOfNumberGeneratedSoFar = telephoneNumberCreatedSoFar.length();
		if (telephoneNumberCreatedSoFar.length() == targetTelephoneLength) {
			displayNumber(telephoneNumberCreatedSoFar.toString());
			numbersGeneratedInTotal++;
		} else {
			// Get all the number of keys possible
			Collection<Key> nextPossibleMoves = piece.getAllPossibleMoves(
					currentKey, lengthOfNumberGeneratedSoFar);

			// Find values from there
			for (Key nextKey : nextPossibleMoves) { 
				generateTelephoneNumbers(nextKey, telephoneNumberCreatedSoFar);
			}
		}

		return numbersGeneratedInTotal;
	}

	/**
	 * Should we display the number. This can be slow so by default this is
	 * switched off.
	 * 
	 * @param numbersGeneratedSoFar
	 */
	private void displayNumber(String numbersGeneratedSoFar) {
		if (isDisplayTelephone) {
			logger.info(numbersGeneratedSoFar);
		}
	}

	/**
	 * Kick off Generation with an empty number to start with.
	 * @return
	 */
	public int generateTelephoneNumbers() {
		String telephoneGeneratedSoFar = new String();
		return generateTelephoneNumbers(currentPosition, telephoneGeneratedSoFar);
	}

	
	public static void main(String... args) {

		Telephone t = new Telephone();
		t.setTargetTelephoneLength(10);
		t.setPiece(new Queen());
		t.setCurrentPosition(Key.FIVE);

		t.generateTelephoneNumbers();
	}

}
