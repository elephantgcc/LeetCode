import java.util.*;

public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		result.addAll(permuteUniqueCore(num, 0));
		return result;
    }

	public HashSet<ArrayList<Integer>> permuteUniqueCore(int[] num, int start) {
		HashSet<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();
		if (num == null || num.length == 0) {
			return result;
		}

		if (start == num.length - 1) {
			ArrayList<Integer> cell = new ArrayList<Integer>();
			cell.add(num[start]);
            result.add(cell);
            return result;
        }
		
		for (int i= start; i < num.length; ++i) {
				int temp = num[start];
				num[start] = num[i];
				num[i] = temp;		

				HashSet<ArrayList<Integer>> postResult = permuteUniqueCore(num, start + 1);
				for (ArrayList<Integer> list : postResult) {
					list.add(num[start]);
					result.add(list);
				} 

				temp = num[start];
				num[start] = num[i];
				num[i] = temp;
		}
		
		return result;
	}

	public static void main(String args[]) {
		long t1 = System.currentTimeMillis();
		System.out.println(new Solution().permuteUnique(new int [] {3,3,1,2,3,2,3}));
		long t2 = System.currentTimeMillis();
		System.out.println(t2 - t1);
	}
}
