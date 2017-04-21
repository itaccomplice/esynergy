package com.itaccomplice.esynergy.hmrc;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Checkout. Takes a list of scanned items and outputs the total cost.
 * @author Mark Ford
 */
public class Checkout {

	/** Price List.*/
	private static final Map<String, Integer> PRICE_LIST;
	static {
		Map<String, Integer> plMap = new HashMap<String, Integer>();
		plMap.put("Apple", Integer.valueOf(60));
		plMap.put("Orange", Integer.valueOf(25));
		PRICE_LIST = Collections.unmodifiableMap(plMap);
    }
	/**
	 * Price the items supplied.
	 * @param items Products.
	 * @return Total cost of the items in pence.
	 */
	public static int price(String[] items) {
		int cost = 0;
		if (items != null) {
	        cost = Arrays.stream(items).map(item -> {
	        	return PRICE_LIST.get(item);
	        }).collect(Collectors.summingInt(Integer::intValue));
		}
		return cost;
	}
}
