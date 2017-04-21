package com.itaccomplice.esynergy.hmrc;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Checkout. Takes a list of scanned items and outputs the total cost.
 * @author Mark Ford
 */
public class Checkout {

	/** Apple constant. */
	private static final String APPLE = "Apple";
	
	/** Apple price constant. */
	private static final int APPLE_PRICE = 60;
	
	/** Orange constant. */
	private static final String ORANGE = "Orange";
	
	/** Orange price constant. */
	private static final int ORANGE_PRICE = 25;
	
/** Price List.*/
	private static final Map<String, Integer> PRICE_LIST;
	static {
		Map<String, Integer> plMap = new HashMap<String, Integer>();
		plMap.put(APPLE, Integer.valueOf(60));
		plMap.put(ORANGE, Integer.valueOf(25));
		PRICE_LIST = Collections.unmodifiableMap(plMap);
    }
	/**
	 * Price the items supplied.
	 * @param items Products.
	 * @return Total cost of the items in pence.
	 */
	public static long price(String[] items) {
		long cost = 0;
/*		int apples = 0;
		int oranges = 0;*/
		if (items != null && items.length > 0) {
			Stream<String> itemStream = Arrays.stream(items);
			
	        cost = itemStream.map(item -> {
	        	return PRICE_LIST.get(item);
	        }).collect(Collectors.summingInt(Integer::intValue));
	        
	        itemStream = Arrays.stream(items);
	        
	        Map<String, Long> counters = itemStream
	        	     .collect(Collectors.groupingBy(item -> item, 
	        	         Collectors.counting()));
	        
	        if (counters.get(APPLE) != null) {
	        	cost = cost - (counters.get(APPLE) / 2 * APPLE_PRICE);
	        }
	        if (counters.get(ORANGE) != null) {
	        	cost = cost - (counters.get(ORANGE) / 3 * ORANGE_PRICE);
	        }
		}
		return cost;
	}
}
