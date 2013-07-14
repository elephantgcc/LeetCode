import java.util.*;

public class Solution {
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		if (num == null) {
			return null;
		}

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (num.length < 3) {
			return result;
		}

		Arrays.sort(num);
		for (int i = 0; i < num.length && num[i] <= 0; ) {
			int twoSum = -num[i];
			int j = i + 1;
			int k = num.length - 1;
			while (j < k) {
				if (num[j] + num[k] < twoSum) {
					int temp = num[j];
					while (j < k && num[j] == temp) {
						++j;
					}
				} else if (num[j] + num[k] > twoSum) {
					int temp = num[k];
					while (j < k && num[k] == temp) {
						--k;
					}
				} else {
					ArrayList<Integer> fruit = new ArrayList<Integer>();
					fruit.add(num[i]);
					fruit.add(num[j]);
					fruit.add(num[k]);
					result.add(fruit);
					int temp = num[j];
					while (j < k && num[j] == temp) {
						++j;
					}
					temp = num[k];
					while (j < k && num[k] == temp) {
						--k;
					}
				}
			}
			int temp = num[i];
			while (i < num.length && num[i] == temp) {
				++i;
			}
		}
		return result;
	}

	public static void main(String args[]) {
		int [] num = new int [] {-1, 0, 1, 2, -1, 4};
		ArrayList<ArrayList<Integer>> result = new Solution().threeSum(num);
		System.out.println(result);
	}
}
