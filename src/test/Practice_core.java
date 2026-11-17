package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Practice_core {

	// Count failures per test
	public static Map<String, Integer> countFailures(String[] results) {
		Map<String, Integer> failures = new HashMap<>();
		
		for (String result : results) {
			if (result == null)
				continue;
			failures.put(result, failures.getOrDefault(result, 0) + 1);
		}
			
		return failures;
	}
	
	// Find 1st duplicates
	public static String find1stDuplicates(String[] results) {
		Set<String> setValues = new HashSet<>();
		for (String result: results) {
			if (setValues.contains(result)) {
				return result;
			}
			else
				setValues.add(result);
		}
		return null;
	}
	
	// Find all duplicates
	public static List <String> findRepeatedFailures(String[] results) {
		Map<String, Integer> failures = new HashMap<>();
		List <String> dups = new ArrayList<String>();
		
		if (results == null)
			return dups;
		
		for (String result: results) {
			int count = 0;
			if (result == null)
				continue;
			count = failures.getOrDefault(result, 0);
			if (count == 1) { // only need to print once
				dups.add(result);
			}
			failures.put(result, count + 1);
		}
		return dups;
	}
	
	
	// solve the same problem using 2 sets
	public static Set <String> findRepeatedFailures2Sets(String[] results) {
		Set<String> seen = new HashSet<>();
		Set<String> repeated = new HashSet<>();
		
		if (results == null)
			return repeated;
		
		for (String result: results) {
			if (result == null)
				continue;
			if (seen.contains(result))
				repeated.add(result);
			else
				seen.add(result);
		}
		return repeated;
	}
	
	
	// Find the first non-repeating character.
	public static int  firstUniqChar(String s) {
		int result = -1;
		if ((s == null) || (s.equalsIgnoreCase("")))
			return result;
		Map<Character, Integer> mapCounts = new HashMap<>();
		for (char ch: s.toCharArray()) {
			mapCounts.put(ch, mapCounts.getOrDefault(ch, 0) + 1);
		}
		for (int i = 0; i < s.length(); i++) {
			char[] chars = s.toCharArray();
			if (mapCounts.get(chars[i]) == 1)
				return i;
		}
		return result;
	}
	
	public static int firstUniqCharFast(String s) {
		int result = -1;
		if ((s == null) || (s.equalsIgnoreCase("")))
			return result;
		
		int[] counts = new int[26];
		for (int i = 0; i <  s.length(); i++) {
			counts[s.charAt(i) - 'a']++;
		}
		for (int i = 0; i < s.length(); i++) {
			if (counts[s.charAt(i) - 'a'] == 1)
				return i;
		}
		return result;
	}
	
	// 2 pointers - remove duplicate values in place so that each distinct value 
	// appears only once, and return the number of unique values k. The 
	// first k positions of the original array must contain the unique values in 
	// sorted order. You don't need to clear the remaining positions.
	public static int distinctValues(int[] intValues) {
		int current = 0;
		int next = current + 1;
		
		if ((intValues == null) || (intValues.length == 0))
			return 0;
		
		while (next < intValues.length) {
			if (intValues[current] == intValues[next])
				next++;
			else {
				current++;
				intValues[current] = intValues[next];
				next++;
			}
		}
		return current+1;
	}
	
	// Sliding window
	public static int slidingWindow(int[] intValues, int k) {
		int maxTtotal = 0;
		if (intValues == null || intValues.length == 0)
			return 0;
		if (k <= 0)
			return 0;
		if (intValues.length <= k) {
			for (int value: intValues)
				maxTtotal += value;
			return maxTtotal;
		}
		// calculate the total of the 1st subarray
		int pointer = 0;
		int sum = 0;
		for (int i = 0; i < k; i++)
			sum +=  intValues[i];
		maxTtotal = sum;
		
		pointer++;
		while (pointer <= (intValues.length - k)) {
			 sum += intValues[pointer+k-1] - intValues[pointer-1];
			 maxTtotal = Math.max(maxTtotal, sum);
			 pointer++;
		}
		return maxTtotal;
	}
	
	// API response validation
	public static int[] longestConsecutiveSeq(int[] resTimes, int threshold) {
		if ((resTimes == null) || (resTimes.length == 0))
			 return new int[0];
		
		int maxLength = 0;
		int maxLengthPtr = 0;
		int currentLength = 0;
		int currentPtr = 0;
		for (int i = 0; i < resTimes.length; i++) {
			if (resTimes[i] >= threshold) { // end of the sequence
				if (currentLength > maxLength) {
					maxLength = currentLength;
					maxLengthPtr = currentPtr;
				}
				currentLength = 0;
			}
			else {
				if ((i > 0) && (resTimes[i-1] >= threshold)) { // begin of the sequence
					currentPtr = i;
				}
				currentLength++;
			}
		}
		
	    // Record a sequence that reaches the end of the array
	    if (currentLength > maxLength) {
	        maxLength = currentLength;
	        maxLengthPtr = currentPtr;
	    }
	    
		int[] result = Arrays.copyOfRange(resTimes, maxLengthPtr, maxLengthPtr+maxLength);
		return result;
	}
	
	// return length only
	public static int longestConsecutiveSeq1(int[] resTimes, int threshold) {
	    if (resTimes == null || resTimes.length == 0) {
	        return 0;
	    }

	    int maxLength = 0;
	    int currentLength = 0;

	    for (int time : resTimes) {
	        if (time < threshold) {
	            currentLength++;
	            maxLength = Math.max(maxLength, currentLength);
	        } else {
	            currentLength = 0;
	        }
	    }

	    return maxLength;
	}
	
	// failure rate
	public static double failureRate(int[] statusCodes) {
		if ((statusCodes == null) || (statusCodes.length == 0))
			return 0.0;
		int failureCounts = 0;
		for (int statusCode: statusCodes) {
			if (statusCode >= 500)
				failureCounts++;
		}
		return 100.0 * failureCounts/statusCodes.length;
	}
	/**
	 * It will return 0.0 when statusCodes is empty
	 * @param statusCodes
	 * @param failureThreshold
	 * @return
	 */
	public static double failureRate(int[] statusCodes, int failureThreshold) {
		if ((statusCodes == null) || (statusCodes.length == 0))
			return 0.0;
		int failureCounts = 0;
		for (int statusCode: statusCodes) {
			if (statusCode >= failureThreshold)
				failureCounts++;
		}
		return 100.0 * failureCounts/statusCodes.length;
	}
	
	// Test-result aggregation
	
	/**
	 * 
	 * @param statusCodes
	 * @return -1 if statusCodes empty or the smallest most frequent status code
	 */
	public static int mostFrequentStatusCode(int[] statusCodes) {
		if ((statusCodes == null) || (statusCodes.length== 0))
			return -1;
		Map <Integer, Integer> statusMap = new HashMap<>();
		Set <Integer> statusCodeSet = new HashSet<>();
		
		for (int statusCode: statusCodes) {
			statusMap.put(statusCode, statusMap.getOrDefault(statusCode, 0) + 1);
			statusCodeSet.add(statusCode);
		}
		
		int maxCount = 0;
		int maxCountCode = statusCodes[0];
		for (int statusCode: statusCodeSet) {
			int count = statusMap.get(statusCode);
			if (count > maxCount) {
				maxCount = count;
				maxCountCode = statusCode;
			}
			else if ((count == maxCount) && (statusCode < maxCountCode)) {
				maxCount = count;
				maxCountCode = statusCode;
			}
		}
		return maxCountCode;
	}
	
	public static void main(String[] args) {
		String[] failedTests = {
			    "testLogin",
			    "testPayment",
			    "testLogin",
			    "testSearch",
			    "testPayment",
			    "testLogin"
		};
		
		// Count failures per test
		// {testPayment=2, testSearch=1, testLogin=3}
		System.out.println(countFailures(failedTests));
		
		// Find 1st duplicates
		// testLogin
		System.out.println(find1stDuplicates(failedTests));
		
		// Find all duplicates
		// [testLogin, testPayment]
		System.out.println(findRepeatedFailures(failedTests));
		System.out.println(findRepeatedFailures2Sets(failedTests));
		
		// Find 1st unique character
		// 0
		System.out.println(firstUniqChar("leetcode"));
		// 2
		System.out.println(firstUniqChar("loveleetcode"));
		// -1
		System.out.println(firstUniqChar("aabb"));
		
		// Sort objects using Comparator.
		// [testLogin, testLogin, testLogin, testPayment, testPayment, testSearch]
		List<String> stringList = new ArrayList<>(Arrays.asList(failedTests));
		stringList.sort((a, b) -> a.compareTo(b));
		System.out.println(stringList);
		
		stringList.sort(Comparator.reverseOrder());
		System.out.println(stringList);
		
		
		// 2 pointers
		// 4
		int [] data = {1, 1, 2, 2, 3, 4, 4};
		System.out.println(distinctValues(data));
		
		// Sliding window
		int[] nums = {2, 1, 5, 1, 3, 2};
		int k = 3;
		System.out.println(slidingWindow(nums, k));
		
		//API response validation
		// [70, 60, 50]
		int[] responseTimes = {120, 80, 90, 150, 70, 60, 50, 200};
		int threshold = 100;
		System.out.println(Arrays.toString(longestConsecutiveSeq(responseTimes, threshold)));
		// length: 3
		System.out.println(longestConsecutiveSeq1(responseTimes, threshold));
		
		// API test-result analysis, failure rate
		// 42.857143%
		int[] statusCodes = {200, 201, 500, 404, 503, 200, 502};
		System.out.printf("%f%%", failureRate(statusCodes));
		System.out.println();
		
		// Test-result aggregation
		// 404
		int[] codes = {200, 500, 404, 200, 500, 404, 404};
		System.out.println(mostFrequentStatusCode(codes));
	}
}
