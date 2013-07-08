public class Solution {
	public int maxArea(int[] height) {
		if (height == null || height.length == 0 || height.length == 1) {
			return 0;
		}
		int i = 0, j = height.length - 1;
		int max = 0;
		while (i < j) {
			int area = 0;
			if (height[i] <= height[j]) {
				area = Math.min(height[i], height[j]) * (j - i);
				++i;
			} else {
				area = Math.min(height[i], height[j]) * (j - i);
				--j;
			}
			max = Math.max(max, area);
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
