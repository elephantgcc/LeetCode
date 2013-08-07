import java.util.*;

public class Solution {
    public int longestConsecutive(int[] num) {
        if (num.length == 0) {
			return 0;
		}

		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		for (int i = 0; i < num.length; ++i) {
			if (map.containsKey(num[i])) {
				continue;
			}
			if (map.containsKey(num[i] - 1) && !map.containsKey(num[i] + 1)) {
				map.get(num[i] - 1).add(num[i]);
				map.put(num[i], map.get(num[i] - 1));
			} else if (!map.containsKey(num[i] - 1) && map.containsKey(num[i] + 1)) {
				map.get(num[i] + 1).add(num[i]);
				map.put(num[i], map.get(num[i] + 1));
			} else if (map.containsKey(num[i] - 1) && map.containsKey(num[i] + 1)) {
				map.get(num[i] - 1).addAll(map.get(num[i] + 1));
				map.get(num[i] - 1).add(num[i]);
				map.put(num[i] + 1, map.get(num[i] - 1));
				for (int j : map.get(num[i] + 1)) {
					map.put(j, map.get(num[i] - 1));
				}
			} else {
				ArrayList<Integer> cell = new ArrayList<Integer>();
				cell.add(num[i]);
				map.put(num[i], cell);
			}
		}
		int max = 0;
		for (int i : map.keySet()) {
			max = Math.max(max, map.get(i).size());
		}
		return max;
    }

	public static void main(String args[]) {
		int[] num = new int[] {100, 4, 200, 1, 3, 2};
		new Solution().longestConsecutive(num);
	}
}
