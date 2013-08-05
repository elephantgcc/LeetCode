public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int M = triangle.size();
        if (M == 0) {
            return 0;
        }
        
        int[] slot = new int[M];
        slot[0] = triangle.get(0).get(0);
        int lastColIndex = 0;
        
        for (int row = 1; row <= M - 1; ++row) {
            ++lastColIndex;
            for (int col = lastColIndex; col >= 0; --col) {
                if (col == lastColIndex) {
                    slot[col] = triangle.get(row).get(col) + slot[col - 1];
                } else if (col == 0) {
                    slot[col] = triangle.get(row).get(col) + slot[col];
                } else {
                    slot[col] = Math.min(slot[col - 1], slot[col]) + triangle.get(row).get(col);
                }
            }
        }
        int min = slot[0];
        for (int col = 1; col < slot.length; ++col) {
            min = Math.min(min, slot[col]);
        }
        return min;
    }
}
