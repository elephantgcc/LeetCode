public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (numRows <= 0) {
            return result;
        }
        ArrayList<Integer> cell = new ArrayList<Integer>();
        cell.add(1);
        result.add(cell);
        if (numRows == 1) {
            return result;
        }
        cell = new ArrayList<Integer>();
        cell.add(1);
        cell.add(1);
        result.add(cell);
        if (numRows == 2) {
            return result;
        }
        for (int row = 2; row <= numRows - 1; ++row) { // row starting from 0, to (nunRows-1)
            cell = new ArrayList<Integer>();
            cell.add(1);
            for (int j = 1; j < result.get(row - 1).size(); ++j) {
                cell.add(result.get(row - 1).get(j - 1) + result.get(row - 1).get(j));
            }
            cell.add(1);
            result.add(cell);
        }
        return result;
    }
}
