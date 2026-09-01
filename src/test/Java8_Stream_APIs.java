package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * (1) Function interface 
 * (2) Predicate interface
 * 		(2.1) Using BiPredicate in Steam
 * 			Scenario A: Matching Stream Elements Against an External Variable
 * 			Scenario B: Filtering Map Entries (Key and Value)
 * (3) Optional
 * 
 */
public class Java8_Stream_APIs {
	// Using function interface 
	public static<T, R> List<R> mapList(List<T> list, Function<T, R> mapper) {
		return list.stream()
				.map(mapper)
				.toList();
	}

	// Using predicate interface
	public static <T> List<T> filterList(List<T> list, Predicate<T> condition) {
		return list.stream()
				.filter(condition)
				.toList();
	}

	// Optional
	public static <T> Optional<T> findElement(List<T> list, Predicate<T> condition) {
		return list.stream()
				.filter(condition)
				.findFirst();
	}

	
	public static void main(String[] args) {
		// The Traditional Way (Imperative Approach)
		List<String> names = Arrays.asList("John", "Sarah", "Jack", "Emily");
		List<String> result = new ArrayList<>();
	
		for (String name : names) {
		    if (name.startsWith("J")) {
		        result.add(name.toUpperCase());
		    }
		}
		System.out.println(result); // [JOHN, JACK]
		
		
		// The Stream API Way (Functional Approach)
		List<String> result1 = names.stream()				// 1. Create Stream
			    .filter(name -> name.startsWith("J"))		// 2. Intermediate: Filter
			    .map(String::toUpperCase)					// 2. Intermediate: Transform
			    .collect(Collectors.toList());				// 3. Terminal: Gather result

		System.out.println(result1); // [JOHN, JACK]
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		//Using Stream API to filter and print even numbers
		numbers.stream()
				.filter(n-> n% 2 == 0)
				.forEach(System.out::println);
		
		
		// Function interface
		// Square each number
		List<Integer> squaredNumbers = mapList(numbers, n -> n * n);
		System.out.println(squaredNumbers);
		
		
		// 1. Define a Function instance (implements the apply() method)
        Function<String, String> toUppercase = str -> str.toUpperCase();

        // 2. Standard Way: Pass the function directly into the stream
        // Stream automatically triggers toUppercase.apply(element) internally!
        List<String> upperNames = names.stream()
                                       .map(toUppercase) 
                                       .collect(Collectors.toList());

        // 3. Explicit Way: Manually calling apply() inside a lambda
        List<String> manualUpperNames = names.stream()
                                             .map(name -> toUppercase.apply(name))
                                             .collect(Collectors.toList());

        System.out.println(upperNames);       // Output: [APPLE, BANANA, CHERRY]
        System.out.println(manualUpperNames); // Output: [APPLE, BANANA, CHERRY]
        
		
        // Predicate Interface
        List<String> filteredwords = filterList(names, word->word.startsWith("J"));
        System.out.println("Filtered Words: " + filteredwords);

        // 1. Define a Predicate using a Lambda expression
        Predicate<String> startsWithA = name -> name.startsWith("J");

        // 2. Use the predicate inside a Stream filter
        List<String> filteredNames = names.stream()
                .filter(startsWithA) 
                .collect(Collectors.toList());

        System.out.println(filteredNames); // Output: [John, Jack]
        
        
        // Combining Predicates (Logical Chaining)
        Predicate<Integer> isEven = n -> n % 2 == 0;
        Predicate<Integer> isGreaterThanTen = n -> n > 10;

        // Combine them
        Predicate<Integer> evenAndGreaterThanTen = isEven.and(isGreaterThanTen);
        Predicate<Integer> oddNumbers = isEven.negate();
        
        // BiPredicate
        // Checks if a string length matches a specific integer
        BiPredicate<String, Integer> hasLength = (str, len) -> str.length() == len;

        boolean results = hasLength.test("Java", 4); // Returns true
        
        // Scenario A: Matching Stream Elements Against an External Variable
        List<String> words = List.of("apple", "banana", "kiwi", "pear");
        int targetLength = 4;

        BiPredicate<String, Integer> isLongerThan = (word, len) -> word.length() > len;

        // Use the BiPredicate inside filter by supplying the external 'targetLength'
        words.stream()
             .filter(word -> isLongerThan.test(word, targetLength))
             .forEach(System.out::println); // Output: apple, banana
        
        // Scenario B: Filtering Map Entries (Key and Value)
        Map<String, Integer> userAges = Map.of("Alice", 25, "Bob", 17, "Charlie", 30);
        
        // BiPredicate to check if a user is an adult with a long name
        BiPredicate<String, Integer> isAdultWithLongName = (name, age) -> age >= 18 && name.length() > 5;
        
        Map<String, Integer> filteredMap = userAges.entrySet().stream()
        		.filter(entry -> isAdultWithLongName.test(entry.getKey(), entry.getValue()))
        		.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        
        System.out.println(filteredMap); // Output: {Charlie=30}
        
        // Combining Multi-Argument Logic
        BiPredicate<Integer, Integer> isSumEven = (a, b) -> (a + b) % 2 == 0;
        BiPredicate<Integer, Integer> bothPositive = (a, b) -> a > 0 && b > 0;
        
        // Combine them: Sum must be even AND both numbers must be positive
        BiPredicate<Integer, Integer> validPair = isSumEven.and(bothPositive);
        
        System.out.println(validPair.test(4, 6));  // true
        System.out.println(validPair.test(-2, 2)); // false (fails bothPositive)
        
        // Optional
        List<String> names1 = Arrays.asList("Alice", "Bob", "Charlie");
        Optional<String> result2 = findElement(names1, name->name.startsWith("B"));

        result2.ifPresent(System.out::println);
        
        names1.stream().filter(name->name.startsWith("B")).forEach(System.out::println);
	}
}


