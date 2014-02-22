package com.practicaljava.lesson7;

/**
 * This interface give the ability to increase payment.
 */
public interface Payable {
	/**
	 * The maximum percentage of payment increase.
	 */
	int INCREASE_CAP = 20;

	/**
	 * @param  percent the percentage of payment increasing
	 * @return true for successful increasing; false otherwise
	 */
	boolean increasePay(int percent);
}
