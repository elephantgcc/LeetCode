public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (n <= 0 || k <= 0) {
            return result;
        }
        
        if (k == 1) {
            for (int i = 1; i <= n; ++i) {
                ArrayList<Integer> cell = new ArrayList<Integer>();
                cell.add(i);
                result.add(cell);
            }
            return result;
        }
        if (k == n) {
            ArrayList<Integer> cell = new ArrayList<Integer>();
            for (int i = 1; i <=n; ++i) {
                cell.add(i);
            }
            result.add(cell);
            return result;
        }
        
        
        ArrayList<ArrayList<Integer>> subResult = combine(n - 1, k - 1);
        for (ArrayList<Integer> cell : subResult) {
            cell.add(n);
            result.add(cell);
        }
        ArrayList<ArrayList<Integer>> prefixResult = combine(n - 1, k);
        result.addAll(prefixResult);
        
        return result;
    }
}
