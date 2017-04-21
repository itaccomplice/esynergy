package com.itaccomplice.esynergy.hmrc;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author Mark Ford
 */
public class CheckoutTest {

	/**
	 * Basic check out test.
	 * @throws Exception If there is a problem.
	 */
	@Test
	public void checkoutTest1() throws Exception {
		String[] items = new String[] {"Apple", "Orange"};
		int cost = Checkout.price(items);
		assertEquals("Should have cost 85p", 85, cost);
	}
	
	/** 
	 * Check out test for multiple items. 
	 * @throws Exception If there is a problem.
	 */
	@Test
	public void checkoutTest2() throws Exception {
		String[] items = new String[] {"Apple", "Apple", "Orange", "Apple"};
		int cost = Checkout.price(items);
		assertEquals("Should have cost 205p", 205, cost);
	}
	
	/** 
	 * Check out test for no items. 
	 * @throws Exception If there is a problem.
	 */
	@Test
	public void checkoutTest3() throws Exception {
		String[] items = new String[] {};
		int cost = Checkout.price(items);
		assertEquals("Should have cost 0p", 0, cost);
	}
	
	/** 
	 * Check out test for null.
	 * @throws Exception If there is a problem.
	 */
	@Test
	public void checkoutTest4() throws Exception {
		String[] items = null;
		int cost = Checkout.price(items);
		assertEquals("Should have cost 0p", 0, cost);
	}
	
	/** Check out test for unknown item.
	 * @throws Exception If there is a problem.
	 */
	@Test(expected = Exception.class)
	public void checkoutTest5() throws Exception {
		String[] items = new String[] {"UNKNOWN"};
		int cost = Checkout.price(items);
		assertEquals("Should have cost 0p", 0, cost);
	}
	
}
