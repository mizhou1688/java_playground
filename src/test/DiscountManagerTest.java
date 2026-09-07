package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Test cases for
 * DiscountManager
 * TC	Test Case				Input		Expected Result
 * D01	No discount				$100, 0%	$100
 * D02	10% discount			$100, 10%	$90
 * D03	20% discount			$100, 20%	$80
 * D04	50% discount			$100, 50%	$50
 * D05	100% discount			$100, 100%	$0
 * D06	Decimal discount		$99.99, 10%	$89.991
 * D07	Empty cart discount		$0, 10%	$0
 * D08	Zero discount			$100, 0%	$100
 * D09	Negative discount		$100, -10%	Ideally rejected; current code returns $110
 * D10	Discount > 100%	$100, 	110%		Ideally rejected; current code returns -$10
 * D11	Null cart				null, 10%	Ideally rejected; current code throws NullPointerException
 * 
 */

class DiscountManagerTest {

    @Test
    void shouldApplyNoDiscount() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new Product("Laptop", 100));

        DiscountManager manager = new DiscountManager();

        double result = manager.applyDiscount(cart, 0.0);

        assertEquals(100.0, result);
    }

    @Test
    void shouldApplyTenPercentDiscount() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new Product("Laptop", 100));

        DiscountManager manager = new DiscountManager();

        double result = manager.applyDiscount(cart, 0.10);

        assertEquals(90.0, result);
    }

    @Test
    void shouldApplyTwentyPercentDiscount() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new Product("Laptop", 100));

        DiscountManager manager = new DiscountManager();

        double result = manager.applyDiscount(cart, 0.20);

        assertEquals(80.0, result);
    }

    @Test
    void shouldApplyFiftyPercentDiscount() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new Product("Laptop", 100));

        DiscountManager manager = new DiscountManager();

        double result = manager.applyDiscount(cart, 0.50);

        assertEquals(50.0, result);
    }

    @Test
    void shouldApplyFullDiscount() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new Product("Laptop", 100));

        DiscountManager manager = new DiscountManager();

        double result = manager.applyDiscount(cart, 1.0);

        assertEquals(0.0, result);
    }

    @Test
    void shouldReturnZeroForEmptyCart() {
        ShoppingCart cart = new ShoppingCart();

        DiscountManager manager = new DiscountManager();

        double result = manager.applyDiscount(cart, 0.10);

        assertEquals(0.0, result);
    }

    @Test
    void shouldCalculateDiscountForMultipleItems() {
        ShoppingCart cart = new ShoppingCart();

        cart.addItem(new Product("Laptop", 1000));
        cart.addItem(new Product("Mouse", 20));

        DiscountManager manager = new DiscountManager();

        double result = manager.applyDiscount(cart, 0.10);

        assertEquals(918.0, result);
    }
}
