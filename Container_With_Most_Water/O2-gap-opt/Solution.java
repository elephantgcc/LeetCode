import java.util.*;

public class Solution {
	public int maxArea(int[] height) {
		if (height == null || height.length == 0 || height.length == 1) {
			return 0;
		}
		int max = 0;
		for (int i = 0; i < height.length; ++i) {
			int gap = 1;
			if (height[i] != 0) {
				gap = max / height[i];
			}
			for (int j = (int)Math.ceil(i + gap); j < height.length; ++j) {
				int area = (j - i) * Math.min(height[i], height[j]);
				max = Math.max(area, max);
			}
		}
        	return max;
	}

	public static void main(String args[]) {
		int[] list = new int[10000];
		for (int i = 10000 - 1; i >= 1; list[i] = i, --i) {}
		long t1 = System.currentTimeMillis();
		System.out.println(new Solution().maxArea(list));
		long t2 = System.currentTimeMillis();
		System.out.println(t2 - t1);
	}
}
