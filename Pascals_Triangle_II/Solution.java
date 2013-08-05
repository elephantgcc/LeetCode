public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (rowIndex < 0) {
            return result;
        }
        result.add(1);
        if (rowIndex == 0) {
            return result;
        }
        result.add(1);
        if (rowIndex == 1) {
            return result;
        }
        
        // rowIndex >= 3
        
        result.remove(1); // now result == [1]
        
        int [] col = new int[rowIndex];
        int lastElementIndex = rowIndex - 1;
        for (int j = 0; j <= lastElementIndex; ++j) {
            col[j] = j + 1;
        }
        result.add(col[lastElementIndex]);
        --lastElementIndex;
        for (int i = 2; i <= rowIndex - 1; ++i) {
            for (int j = 1; j <= lastElementIndex; ++j) {
                col[j] += col[j - 1];
            }
            result.add(col[lastElementIndex]);
            --lastElementIndex;
        }
        
        result.add(1);
        
        return result;
    }
}
