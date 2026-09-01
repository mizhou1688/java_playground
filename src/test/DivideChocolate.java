package test;

import java.util.Arrays;
import java.util.Stack;

public class DivideChocolate {
	int counter0 = 0;
	int counter1 = 0;
	public int maxPoints(int[] schedule, int k) {
		int totalDays = 0;
		for (int i = 0; i < schedule.length; i++) {
			totalDays += schedule[i];
		}

		int[] pre_sum = new int[totalDays+1];
		int index = 0;
		for (int i = 0; i < schedule.length; i++) {
			for (int j = 0; j < schedule[i]; j++) {
				pre_sum[index+1] = pre_sum[index]+j+1;
				index++;
				counter0++;
			}
		}
		int max = 0;
		for (int i = 0; i < totalDays - k; i++) {
			max = Math.max(max, pre_sum[i+k]-pre_sum[i]);
			counter0++;
		}
		
				
		int sum = getTotalPoints(schedule, k);
		max = 0;
		for (int i = 1; i < totalDays - k; i++) {
			sum = sum - getPoints(i-1, schedule) + getPoints(i+k-1, schedule);
			counter1++;
			max = Math.max(max, sum);
		}
		return max;
	}
	private int getTotalPoints(int[] schedule, int k) {
		int points = 0;
		for (int i = 0; i < schedule.length; i++) {
			int subsum = 0;
			for (int j = 0; j < schedule[i]; j++) {
				counter1++;
				subsum += j+1;
				k--;
				if (k == 0)
					break;
			}
			points += subsum;
			if (k == 0)
				break;
		}

		return points;
	}
	private int getPoints(int index, int[] schedule) {
		for (int i = 0; i < schedule.length; i++) {
			counter1++;
			if (index < schedule[i])
				return index+1;
			else
				index -= schedule[i];
		}
		return index+1;
	}
	
	public int totalStrength1(int[] strength) {
        int length = strength.length;
        Stack <Integer> mystack = new Stack <>();
        long[] dp = new long[length];
        long total = 0;
        long sum = 0;
        for (int i = 0; i < length; i++) {
            int current = strength[i];
            sum += current;
            while (!mystack.isEmpty() && strength[mystack.peek()] >= current)
                mystack.pop();
            if (!mystack.isEmpty()) {
                int prev = mystack.peek();
                System.out.println("i="+i+" prev="+prev);
                dp[i] = dp[prev] + (i-prev)*sum * current;
            } else {
                dp[i] = (i+1)*(sum*current);
            }
            mystack.push(i);
        }
        for (long item: dp) {
            total += item;
            System.out.print(item+" ");
        }
        total %= Math.pow(10,9) + 7;

        /*
        for (int i = 0; i < length; i++) {
            int dp_min = Integer.MAX_VALUE, dp_sum = 0;
            for (int j = i; j < length; j++) {
                dp_min = Math.min(dp_min, strength[j]);
                dp_sum += strength[j];
                total += dp_min * dp_sum;
                System.out.println("dp_min="+dp_min+" dp_sum="+dp_sum);
                total %= Math.pow(10,9) + 7;
            }
        }*/

        return (int) total;
    }
	public int totalStrength(int[] strength) {
        long MOD = 1000000007;
        int n = strength.length;
        long [] prefix = new long[n+1];
        long[] prefix_sum = new long[n+2];

        for(int i = 0; i < n; i++){
            prefix[i+1] = (prefix[i] + strength[i])%MOD; 
        }

        for(int i = 0; i <= n; i++){
            prefix_sum[i+1] = (prefix_sum[i] + prefix[i]) % MOD;
        }

        Stack<Integer> st = new Stack<>();
        int[] left = new int[n];
        int[] right = new int[n];

        Arrays.fill(left, -1);
        for(int i = 0; i < n; i++){
            while(!st.empty() && strength[st.peek()] >= strength[i]){
                st.pop();
            }
            if(st.empty()) left[i] = -1;
            else left[i] = st.peek();

            st.push(i);
        }

        st.clear();
        Arrays.fill(right, n);
        for(int i = n-1; i >=0; i--){
            while(!st.empty() && strength[st.peek()] > strength[i]){
                st.pop();
            }
            if(st.empty()) right[i] = n;
            else right[i] = st.peek();

            st.push(i);
        }

        long res = 0;
        for(int i = 0; i < n; i++){
            int l = left[i];
            int r = right[i];
            System.out.println("r="+r+" i="+i+" l="+l);
            long part1 = (prefix_sum[r + 1] - prefix_sum[i + 1]) * (i - l) % MOD;
            long part2 = (prefix_sum[i + 1] - prefix_sum[l + 1]) * (r - i) % MOD;
            long product = (part1 - part2 ) % MOD ;
            if (product < 0) {
                product += MOD; 
            }   
            res = (res + (product * strength[i]) % MOD) % MOD;
            System.out.println("res="+res+" prod*str="+product * strength[i]);
        }
        if (res < 0) {
            res += MOD; 
        }
        return (int) (res % MOD);
    }
	public int sumSubarrayMins(int[] arr) {
		int[] dp = new int[arr.length];
		Stack<Integer> mystack = new Stack<>();
		for (int i=0; i<arr.length; i++) {
			int num = arr[i];
            while (!mystack.isEmpty() && arr[mystack.peek()]>= num) {
                mystack.pop();
            }
            if (mystack.isEmpty()) { // current one is smaller than anyone on the left
                dp[i] = (i + 1) * num; // the current one contribute to all the positions on the left
            } else { // found the closest one that is smaller than current one on the left
                int prev = mystack.peek();
                dp[i] = dp[prev] + (i - prev) * num; // current one only contribute up to the "prev",
                                                    // the rest are from the "prev"
            }
            mystack.push(i);
        }
        long result = 0;
        for (int val : dp) {
        	System.out.print(val+" ");
            result += val;
        }
        System.out.println("");
        return (int) (result % 1_000_000_007);
	}

	public int maximizeSweetness(int[] sweetness, int K) {
		int left = 0, right = Arrays.stream(sweetness).sum() / (K + 1);
		while (left < right) {
			int mid = left + (right - left + 1) / 2;
			int cnt = 0;
			int sum = 0;
			for (int i = 0; i < sweetness.length; i++) {
				sum += sweetness[i];
				if (sum >= mid) {
					sum = 0;
					cnt++;
				}
			}
			
			if (cnt >= K + 1) {
				left = mid;
			} else {
				right = mid - 1;            // ???
			}
		}
		return left;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DivideChocolate a = new DivideChocolate();
		/*
		int[] sweetness = {1,2,3,4,5,6,7,8,9};
		int k = 5;
		System.out.println(a.maximizeSweetness(sweetness, k));
		int[] sweetness1 = {5,6,7,8,9,1,2,3,4};
		k = 8;
		System.out.println(a.maximizeSweetness(sweetness1, k));
		int[] sweetness2 = {1,2,2,1,2,2,1,2,2};
		k = 2;
		System.out.println(a.maximizeSweetness(sweetness2, k));
		*/
		/*
		int[] arr = {3,1,2,4};
		System.out.println(a.sumSubarrayMins(arr));
		int[] arr1 = {11,81,94,43,3};
		System.out.println(a.sumSubarrayMins(arr1));
		*/
		int[] arr= {1,3,1,2};
		System.out.println(a.totalStrength(arr));
		//int[] d = {7,4,3,7,2};
		//int k = 8;
		//System.out.println(a.maxPoints(d, k));
	}

}
