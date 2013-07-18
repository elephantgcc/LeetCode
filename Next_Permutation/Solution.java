import java.util.*;

public class Solution {
    public void nextPermutation(int[] num) {
        if (num == null || num.length == 0 || num.length == 1) {
			return;
		}
		int N = num.length;
		int leftMost = N - 2;
		ArrayList<Integer> candidates = new ArrayList<Integer>();
		for (; leftMost >= 0; --leftMost) {
			candidates.clear();
			for (int j = leftMost; j < N; ++j) {
				candidates.add(num[j]);
			}
			Collections.sort(candidates);
			if (num[leftMost] != candidates.get(candidates.size() - 1)) {
				break;
			}
		}
		if (leftMost == -1) {
			Arrays.sort(num);
			return;
		} else {
			int biggerIndex = candidates.indexOf(num[leftMost]) + 1;
			while (candidates.get(biggerIndex) == num[leftMost]) {
				biggerIndex++;
			}
			num[leftMost] = candidates.get(biggerIndex);
			candidates.remove(biggerIndex);
			for (int i = 0; i < candidates.size(); ++i) {
				num[leftMost + 1 + i] = candidates.get(i);
			}
			return;
		}
    }

	public static void main(String args[]) {
		int [] num = new int [] {1, 1, 2, 1, 1, 1};
		new Solution().nextPermutation(num);
		for (int i = 0; i < num.length; ++i) {
			System.out.println(num[i]);
		}
	}
}
