package test;

import java.util.ArrayList;
import java.util.List;

public class Java8_Lambda_Expressions {
	public static void main(String[] args) {
		// Before Java 8 (Anonymous Inner Class)
		Runnable r = new Runnable() {
		    @Override
		    public void run() {
		        System.out.println("Running old way...");
		    }
		};
		r.run();
		
		// Java 8 Lambdas
		// 1. Zero Parameters (Using a Custom Interface)
		Runnable r1 = () -> System.out.println("Running with lambda!");
		r1.run();
		
		// 2. Single Parameter (Iterating a Collection)
		List<String> names = new ArrayList<>(List.of("Alice", "Bob", "Charlie"));
        // Single parameter lambda (parentheses around 'name' are optional)
        names.forEach(name -> System.out.println("Name: " + name));
		
        // 3. Multiple Parameters & Return Statement
        List<String> cities = new ArrayList<>(List.of("Berlin", "Paris", "Amsterdam"));
        // Multi-parameter lambda with a single expression (implicit return)
        cities.sort((c1, c2) -> c1.compareTo(c2));
        // Multi-line block lambda requiring explicit 'return' and curly braces
        cities.sort((c1, c2) -> {
            System.out.println("Comparing " + c1 + " and " + c2);
            return c1.compareTo(c2);
        });
        
	}

}
