import java.util.*;

public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		result.addAll(combinationSumCore(candidates, target));
		return result;
    }

	public HashSet<ArrayList<Integer>> combinationSumCore(int[] candidates, int target) {
		HashSet<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();
		if (candidates == null || candidates.length == 0) {
			return result;
		}

		if (target == 0) {
			ArrayList<Integer> fruit = new ArrayList<Integer>();
			result.add(fruit);
			return result; // [[]]
		}

		for (int i = 0; i < candidates.length; ++i) {
			if (candidates[i] <= target) {
				HashSet<ArrayList<Integer>> postResult = combinationSumCore(candidates, target - candidates[i]);
				for (ArrayList<Integer> list : postResult) {
					list.add(candidates[i]);
					Collections.sort(list);
					result.add(list);
				}
			}
		}

		return result;
	}

	public static void main(String args[]) {
		int [] candidates = {2, 3, 6, 7};
		System.out.println(new Solution().combinationSum(candidates, 7));
	}
}
