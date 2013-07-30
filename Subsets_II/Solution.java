import java.util.*;

public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> nullSet = new ArrayList<Integer>();
        result.add(nullSet);
        if (S == null || S.length == 0) {
            return result;
        }

        for (int len = 1; len <= S.length; ++len) {
            HashSet<ArrayList<Integer>> subResult = combine(S, S.length - 1, len);
            result.addAll(subResult);
        }
        
        for (ArrayList<Integer> list : result) {
            Collections.sort(list);
        }

        return result;

    }

    public HashSet<ArrayList<Integer>> combine(int[] A, int endIndex, int k) {
        HashSet<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();
        if (k == 1) {
            for (int i = 0; i <= endIndex; ++i) {
                ArrayList<Integer> cell = new ArrayList<Integer>();
                cell.add(A[i]);
                result.add(cell);
            }
            return result;
        }
        if (k == endIndex + 1) {
            ArrayList<Integer> cell = new ArrayList<Integer>();
            for (int i = 0; i <= endIndex; ++i) {
                cell.add(A[i]);
            }
			Collections.sort(cell);
            result.add(cell);
            return result;
        }
        
        HashSet<ArrayList<Integer>> subResult = combine(A, endIndex - 1, k - 1);
        for (ArrayList<Integer> cell : subResult) {
            cell.add(A[endIndex]);
			Collections.sort(cell);
            result.add(cell);
        }
        HashSet<ArrayList<Integer>> prefixResult = combine(A, endIndex - 1, k);
        result.addAll(prefixResult);

        return result;
    }

	public static void main(String args[]) {
		int [] A = new int [] {1, 2, 2, 3, 3};
		System.out.println(new Solution().subsets(A));
	}
}


