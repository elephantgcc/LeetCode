import java.util.*;

public class Solution {
	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {


		if (num.length < 4) {
			return new ArrayList<ArrayList<Integer>>();
		}
		
		HashSet<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();

        	HashMap<Integer, HashSet<ArrayList<Integer>>> sumMap = new HashMap<Integer, HashSet<ArrayList<Integer>>>();
		HashMap<Integer, Integer> counterMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < num.length; ++i) {
			if (!counterMap.containsKey(num[i])) {
				counterMap.put(num[i], 1);
			} else {
				counterMap.put(num[i], counterMap.get(num[i]) + 1);
			}
			for (int j = i + 1; j < num.length; ++j) {
				int sum = num[i] + num[j];
				HashSet<ArrayList<Integer>> pairSet = null;
				if (!sumMap.containsKey(sum)) {
					pairSet = new HashSet<ArrayList<Integer>>();
				} else {
					pairSet = sumMap.get(sum);
				}
				ArrayList<Integer> pair = new ArrayList<Integer>();
				pair.add(Math.min(num[i], num[j]));
				pair.add(Math.max(num[i], num[j]));
				pairSet.add(pair);
				sumMap.put(sum, pairSet);
			}
		}
		for (int i = 0; i < num.length; ++i) {
			for (int j = i + 1; j < num.length; ++j) {
				int twoSum = target - num[i] - num[j];
				if (sumMap.containsKey(twoSum)) {
					for (ArrayList<Integer> pair : sumMap.get(twoSum)) {
						ArrayList<Integer> tempList = new ArrayList<Integer>();
						tempList.add(num[i]);
						tempList.add(num[j]);
						tempList.addAll(pair);
						TreeMap<Integer, Integer> outMap = new TreeMap<Integer, Integer>();
						for (int k = 0; k < tempList.size(); ++k) {
							if (!outMap.containsKey(tempList.get(k))) {
								outMap.put(tempList.get(k), 1);
							} else {
								outMap.put(tempList.get(k), outMap.get(tempList.get(k)) + 1);
							}
						}
						boolean enough = true;
						for (int k : outMap.keySet()) {
							if (outMap.get(k) > counterMap.get(k)) {
								enough = false;
								break;
							}
						}
						if (enough) {
							ArrayList<Integer> fruit = new ArrayList<Integer>();
							for (int k : outMap.keySet()) {
								for(int l = 0; l < outMap.get(k); ++l) {
									fruit.add(k);
								}
							}
							result.add(fruit);
						}
					}
				}
			}
		}
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		res.addAll(result);
		return res;
	}

	public static void main(String args[]) {
		int [] array = new int [] {1, 0, -1, 0, -2, 2};
		ArrayList<ArrayList<Integer>> result = new Solution().fourSum(array, 0);
		System.out.println(result);
	}
}
