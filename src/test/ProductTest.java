package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Test cases for 
 * 	Product
 * 	TC						Test Case				Input			Expected Result
 * 	P01	Create product with valid name and price	"Laptop", 1000	Product is created successfully
 * 	P02	Verify product name							"Laptop", 1000	getName() returns "Laptop"
 * 	P03	Verify product price						"Laptop", 1000	getPrice() returns 1000
 * 	P04	Product with zero price						"Free Item", 0	getPrice() returns 0
 * 	P05	Product with decimal price					"Mouse", 19.99	getPrice() returns 19.99
 * 	P06	Product with negative price					"Invalid", -10	Ideally rejected; current code allows it
 */

class ProductTest {

    @Test
    void shouldCreateProduct() {
        Product product = new Product("Laptop", 1000);

        assertNotNull(product);
    }

    @Test
    void shouldReturnProductName() {
        Product product = new Product("Laptop", 1000);

        assertEquals("Laptop", product.getName());
    }

    @Test
    void shouldReturnProductPrice() {
        Product product = new Product("Laptop", 1000);

        assertEquals(1000.0, product.getPrice());
    }

    @Test
    void shouldSupportZeroPrice() {
        Product product = new Product("Free Item", 0);

        assertEquals(0.0, product.getPrice());
    }

    @Test
    void shouldSupportDecimalPrice() {
        Product product = new Product("Mouse", 19.99);

        assertEquals(19.99, product.getPrice(), 0.001);
    }
}