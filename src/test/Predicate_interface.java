package test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Predicate_interface {
	public static void main(String args[]) {
		
		// create a list of strings
		List<String> names = Arrays.asList(
				"Geek", "GeeksQuiz", "g1", "QA", "Geek2");
		
		/**
		 * Declare the predicate type as string and use
		 * lambda expression to create object
		 */

		Predicate<String> p = (s) -> s.startsWith("G");
		
		// Iterate through the list
		for (String st : names) {
			// call the test method
			if (p.test(st))
				System.out.println(st);
        }
		
		// The Stream API Way 
		names.stream()								// 1. Create Stream
			.filter(name -> name.startsWith("G"))	// 2. Intermediate: Filter (predicate)
			.forEach(System.out::println);			// 3. Consume

    }

}
