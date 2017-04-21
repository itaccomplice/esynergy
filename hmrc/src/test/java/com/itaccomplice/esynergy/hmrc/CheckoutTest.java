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
		long cost = Checkout.price(items);
		assertEquals("Should have cost 85p", 85, cost);
	}
	
	/** 
	 * Check out test for multiple items. 
	 * @throws Exception If there is a problem.
	 */
	@Test
	public void checkoutTest2() throws Exception {
		String[] items = new String[] {"Apple", "Apple", "Orange", "Apple"};
		long cost = Checkout.price(items);
		assertEquals("Should have cost 145p", 145, cost);
	}
	
	/** 
	 * Check out test for no items. 
	 * @throws Exception If there is a problem.
	 */
	@Test
	public void checkoutTest3() throws Exception {
		String[] items = new String[] {};
		long cost = Checkout.price(items);
		assertEquals("Should have cost 0p", 0, cost);
	}
	
	/** 
	 * Check out test for null.
	 * @throws Exception If there is a problem.
	 */
	@Test
	public void checkoutTest4() throws Exception {
		String[] items = null;
		long cost = Checkout.price(items);
		assertEquals("Should have cost 0p", 0, cost);
	}
	
	/** Check out test for unknown item.
	 * @throws Exception If there is a problem.
	 */
	@Test(expected = Exception.class)
	public void checkoutTest5() throws Exception {
		String[] items = new String[] {"UNKNOWN"};
		long cost = Checkout.price(items);
		assertEquals("Should have cost 0p", 0, cost);
	}
	
	/**
	 * Test apple discount applied - 2 apples purchased.
	 * @throws Exception If there is a problem.
	 */
	@Test
	public void checkoutAppleDiscountTest1() throws Exception {
		String[] items = new String[] {"Apple", "Apple"};
		long cost = Checkout.price(items);
		assertEquals("Should have cost 60p", 60, cost);
	}
	
	/**
	 * Test apple discount applied - 3 apples purchased.
	 * @throws Exception If there is a problem.
	 */
	@Test
	public void checkoutAppleDiscountTest2() throws Exception {
		String[] items = new String[] {"Apple", "Apple", "Apple"};
		long cost = Checkout.price(items);
		assertEquals("Should have cost 120p", 120, cost);
	}
	
	/**
	 * Test apple discount applied - 4 apples purchased.
	 * @throws Exception If there is a problem.
	 */
	@Test
	public void checkoutAppleDiscountTest3() throws Exception {
		String[] items = new String[] {"Apple", "Apple", "Apple", "Apple"};
		long cost = Checkout.price(items);
		assertEquals("Should have cost 120p", 120, cost);
	}
	
	/**
	 * Test apple discount not applied - 1 apple purchased.
	 * @throws Exception If there is a problem.
	 */
	@Test
	public void checkoutAppleDiscountTest4() throws Exception {
		String[] items = new String[] {"Apple"};
		long cost = Checkout.price(items);
		assertEquals("Should have cost 60p", 60, cost);
	}
	
}
