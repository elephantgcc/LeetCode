import java.util.*;

public class Solution {
	public int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];
		int patch = -1;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(numbers.length);
		for (int i = 0; i < numbers.length; ++i) {
			if (map.containsKey(numbers[i]) && numbers[i] == target / 2) {
				patch = i; // the latter one
			} else {
				map.put(numbers[i], i);
			}
		}
		for (int i : map.keySet()) {
			if (map.containsKey(target - i)) {
				if (i == target - i) {
					result[0] = map.get(i) + 1;
					result[1] = patch + 1;
				} else {
					result[0] = Math.min(map.get(i), map.get(target - i)) + 1;
					result[1] = Math.max(map.get(i), map.get(target - i)) + 1;
				}
				break;
			}
		}
		return result;
	}

	public static void main(String args[]) {
		int [] n = new int[] {1, 1, 4, 5, 6, 7, 8};
		int [] result = new Solution().twoSum(n, 2);
		System.out.println(result[0] + " " + result[1]);
	}

}
