import java.util.*;

public class Solution {

    public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		result.addAll(combinationSum2Core(candidates, target));
		return result;
    }

	public HashSet<ArrayList<Integer>> combinationSum2Core(int[] candidates, int target) {
		HashSet<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();

		if (target == 0) {
			ArrayList<Integer> fruit = new ArrayList<Integer>();
			result.add(fruit);
			return result; // [[]]
		}

		if (candidates == null || candidates.length == 0) {
			return result;
		}

		for (int i = 0; i < candidates.length; ++i) {
			if (candidates[i] > 0 && candidates[i] <= target) {
				int valueI = candidates[i];
				candidates[i] *= -1;
				HashSet<ArrayList<Integer>> postResult = combinationSum2Core(candidates, target - valueI);
				for (ArrayList<Integer> list : postResult) {
					list.add(valueI);
					Collections.sort(list);
					result.add(list);
				}
				candidates[i] *= -1;
			}
		}

		return result;
	}

	public static void main(String args[]) {
		int [] candidates = {6,33,9,8,16,14,6,32,16,30,15,19,20,27,33,12,14,34,27,8,12,27,12,5,20,6,16,17,21,21,25,23,11,21,26,22,22,19,19,33,15,22,17,30,14,7,29,15,7,21,18,6,5,25,29,20,18};
		System.out.println(new Solution().combinationSum2(candidates, 27));
	}
}
