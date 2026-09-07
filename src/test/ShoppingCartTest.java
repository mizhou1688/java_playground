package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Test cases for 
 * ShoppingCart
 * TC		Test Case						Input						Expected Result
 * C01	Create empty cart					New ShoppingCart()			Cart contains 0 items
 * C02	Add one product						Laptop $1000				Cart contains 1 item
 * C03	Add multiple products				Laptop $1000, Mouse $20		Cart contains 2 items
 * C04	Verify added product				Laptop						Retrieved product is Laptop
 * C05	Calculate total for empty cart		No items					Total = 0.0
 * C06	Calculate total for one item		Laptop $1000				Total = 1000.0
 * C07	Calculate total for multiple items	$1000 + $20					Total = 1020.0
 * C08	Calculate total with decimal prices	$10.50 + $5.25				Total = 15.75
 * C09	Add same product twice				Laptop + Laptop				Total = 2000.0
 * C10	Add zero-price product				Free item $0				Total unchanged
 * C11	Add null product					null						Ideally rejected; current code accepts it but calculateTotal() will fail
 */

class ShoppingCartTest {

    @Test
    void shouldCreateEmptyCart() {
        ShoppingCart cart = new ShoppingCart();

        assertNotNull(cart.getItems());
        assertTrue(cart.getItems().isEmpty());
    }

    @Test
    void shouldAddOneItem() {
        ShoppingCart cart = new ShoppingCart();
        Product laptop = new Product("Laptop", 1000);

        cart.addItem(laptop);

        assertEquals(1, cart.getItems().size());
    }

    @Test
    void shouldAddMultipleItems() {
        ShoppingCart cart = new ShoppingCart();

        Product laptop = new Product("Laptop", 1000);
        Product mouse = new Product("Mouse", 20);

        cart.addItem(laptop);
        cart.addItem(mouse);

        assertEquals(2, cart.getItems().size());
    }

    @Test
    void shouldReturnAddedProduct() {
        ShoppingCart cart = new ShoppingCart();
        Product laptop = new Product("Laptop", 1000);

        cart.addItem(laptop);

        assertSame(laptop, cart.getItems().get(0));
    }

    @Test
    void shouldCalculateZeroForEmptyCart() {
        ShoppingCart cart = new ShoppingCart();

        assertEquals(0.0, cart.calculateTotal());
    }

    @Test
    void shouldCalculateTotalForOneItem() {
        ShoppingCart cart = new ShoppingCart();

        cart.addItem(new Product("Laptop", 1000));

        assertEquals(1000.0, cart.calculateTotal());
    }

    @Test
    void shouldCalculateTotalForMultipleItems() {
        ShoppingCart cart = new ShoppingCart();

        cart.addItem(new Product("Laptop", 1000));
        cart.addItem(new Product("Mouse", 20));

        assertEquals(1020.0, cart.calculateTotal());
    }

    @Test
    void shouldCalculateTotalWithDecimalPrices() {
        ShoppingCart cart = new ShoppingCart();

        cart.addItem(new Product("Item 1", 10.50));
        cart.addItem(new Product("Item 2", 5.25));

        assertEquals(15.75, cart.calculateTotal(), 0.001);
    }

    @Test
    void shouldCountDuplicateProducts() {
        ShoppingCart cart = new ShoppingCart();

        Product laptop = new Product("Laptop", 1000);

        cart.addItem(laptop);
        cart.addItem(laptop);

        assertEquals(2, cart.getItems().size());
        assertEquals(2000.0, cart.calculateTotal());
    }
}
