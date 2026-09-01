package test;

import java.util.Arrays;
import java.util.List;

public class Generic_Methods {
	
	// Type Inference
	public <T> void printArray(T[] array) {
		for (T element : array) {
			System.out.print(element);
		}
		System.out.println();
	}
	
	// Bounded type parameters
	// T must be a subclass of Number (e.g., Integer, Double)
	public <T extends Number> double sumOfList(List<T> list) {
		double sum = 0.0;
		for (T number : list) {
			sum += number.doubleValue(); 
		}
		return sum;
	}

	// Multiple Type Parameters
	// Simple nested class to hold two different types of data
	public static class Pair<K, V> {
		private final K key;
		private final V value;
		
		public Pair(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		public K getKey() { return key; }
		public V getValue() { return value; }
    }

    /**
     * A generic method with TWO type parameters: K and V.
     * The type parameters <K, V> are declared BEFORE the return type.
     */
	public static <K, V> Pair<K, V> createPair(K key, V value) {
		System.out.println("Processing key type: " + key.getClass().getSimpleName());
		System.out.println("Processing value type: " + value.getClass().getSimpleName());
		
		return new Pair<>(key, value);
	}
    
	public static <K, V> boolean comparePairs(Pair<K, V> p1, Pair<K, V> p2) {
		return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());
	}
	
	public static void main(String[] args) {

		Integer[] intArray = {1, 2, 3};
		String[] stringArray = {"A", "B", "C"};
		List<Integer> intList = Arrays.asList(intArray);
		Generic_Methods gM = new Generic_Methods();
		
		// Type inference handles both automatically
		gM.printArray(intArray);    // T is inferred as Integer
		gM.printArray(stringArray); // T is inferred as String
		System.out.println(gM.sumOfList(intList));
		
		
		// Multiple Type Parameters
		
		 // Example 1: Passing a String and an Integer
        // Java 8 type inference automatically deduces K as String and V as Integer
        Pair<String, Integer> userAge = createPair("Alice", 30);
        System.out.println("User: " + userAge.getKey() + " | Age: " + userAge.getValue());
        
        System.out.println("--------------------------------");

        // Example 2: Passing an Integer and a Boolean
        Pair<Integer, Boolean> statusCheck = createPair(101, true);
        System.out.println("ID: " + statusCheck.getKey() + " | Active: " + statusCheck.getValue());
        
        System.out.println(comparePairs(userAge, userAge));
	}

}
