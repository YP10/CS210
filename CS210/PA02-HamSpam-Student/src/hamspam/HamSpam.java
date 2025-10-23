//
// Copyright (c) 2025 Tim Richards. All rights reserved.
//
/*
 * Copyright 2021 Marc Liberatore.
 */

package hamspam;

public class HamSpam {
	private final int hamNumber;
	private final int spamNumber;

	/**
	 * Construct an object that can compute hamspam values for a game of
	 * Ham and Spam.
	 * 
	 * @param hamNumber  the ham number; it must be greater than 1
	 * @param spamNumber the spam number; it must be greater
	 *                   than 1 and not equal to the ham number
	 */
	public HamSpam(int hamNumber, int spamNumber) {
		this.hamNumber = hamNumber;
		this.spamNumber = spamNumber;
	}

	/**
	 * Returns the nth hamspam value (a number, ham, spam, or hamspam)
	 * for this game of Ham and Spam.
	 * 
	 * For example, getValue(1) returns "1".
	 * 
	 * @param n
	 *          the number to consider; n > 0
	 * @return the hamspam value, as a String
	 */
	public String getValue(int n) {
		if ((n % hamNumber == 0) && (n % spamNumber == 0)) {
			return "hamspam";
		} else if (n % hamNumber == 0) {
			return "ham";
		} else if (n % spamNumber == 0) {
			return "spam";
		} else
			return Integer.toString(n);
	}

	/**
	 * Returns an array of the hamspam values from start to end, inclusive, for
	 * this game of Ham and Spam.
	 * 
	 * For example, if the ham number is 3 and the spam number is 4,
	 * getValues(2,6) should return an array of Strings:
	 * 
	 * {"2", "ham", "spam", "5", "ham"}
	 * 
	 * @param start
	 *              the number to start from; start > 0
	 * @param end
	 *              the number to end at; end >= start
	 * @return the array of hamspam values
	 */
	public String[] getValues(int start, int end) {
		if(end-start+1<0){
			return new String[0];
		}
		String[] result=new String[end-start+1];
		int j=0;
		for(int i=start; i<=end;i++){
			
			result[j]=getValue(i);
			j++;

		}
		return result;
		
		/**
		 * TODO: Complete the implementation of the getValues method to dynamically
		 * 
		 * generate an array of HamSpam values. This method should return an array
		 * of strings representing the hamspam values from 'start' to 'end',
		 * inclusive. Each element in the array should be determined by calling the
		 * 'getValue(int n)' method.
		 *
		 * Steps to follow:
		 * 1. Calculate the number of values, 'numValues', as the difference between
		 *    'end' and 'start' plus one.
		 * 2. Initialize an array of strings, 'result', with the size equal to
		 *    'numValues'.
		 * 3. Use a for loop to iterate from 0 to 'numValues' - 1. a. For each
		 *    iteration, calculate 'n' as the current loop index plus 'start'. b.
		 *    Call 'getValue(n)' and assign the result to the corresponding index in
		 *    the 'result' array.
		 * 4. Return the 'result' array containing all the hamspam values.
		 *
		 * Example: If the ham number is 3 and the spam number is 5, and the method
		 * is called with start=2 and end=6, then getValues(2, 6) should return an
		 * array {"2", "ham", "spam", "4", "hamspam"}.
		 *
		 * Note: Ensure to handle cases where 'start' is greater than 'end' by
		 * returning an empty array or by throwing an IllegalArgumentException.
		 */
	}
}