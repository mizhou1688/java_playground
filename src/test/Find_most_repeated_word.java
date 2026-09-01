package test;

import java.util.HashMap;

public class Find_most_repeated_word {	
	public static void main(String[] args) {
		String sentence = "ServiceNow is an awesome company to work for and I like working at this company the the the";
		String [] words = sentence.split(" ");
		HashMap <String, Integer>  myMap = new HashMap<>();
		int max = 1;
		String result = words[0];
		for (int i = 0; i< words.length; i++) {
			String temp = words[i];
			if (myMap.containsKey(temp)) {
				int value = myMap.get(temp);
				if (value +1 > max) {
					result = temp;
					max = value+1;
				}
				myMap.put(temp, ++value);
			}
			else
				myMap.put(temp, 1);
		}
		System.out.println(result);
	}
}
