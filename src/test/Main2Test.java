package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Since this is a small Java shopping-cart example, I would test it at 
 * unit-test level and cover the three classes independently: Product, 
 * ShoppingCart, and DiscountManager.
 * 
 */
/**
 * I would not blindly test only the current implementation. A good QA/SDET answer should identify the missing business rules.
 *
 *For example, this code currently allows:
 * 		new Product("Invalid Product", -100);
 *and:
 *		manager.applyDiscount(cart, -0.10);
 *which effectively increases the price.
 *It also allows:
 *	manager.applyDiscount(cart, 1.5);
 *which produces a negative price.
 *
 *So I would raise requirements questions such as:
 *Should product price be greater than or equal to zero?
 *Should null products be allowed?
 *Should discount rate be restricted to 0.0–1.0?
 *What should happen when the cart is null?
 *Should prices use BigDecimal instead of double for currency?
 *Should getItems() expose the internal mutable list?
 *Should duplicate products be combined into quantities?
 */





class Main2Test {

	@Test
	void testObject() {
		fail("Not yet implemented");
	}

}
