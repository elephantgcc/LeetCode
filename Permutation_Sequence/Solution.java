public class Solution {
    public String getPermutation(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for (int i = 1; i <= n; ++i) {
            nums.add(i);
        }
        
        return getPermCore(nums, k - 1);
    }
    
    private String getPermCore(ArrayList<Integer> nums, int index) {
        
        if (nums.size() == 1) {
            return nums.get(0) + "";
        }
        
        int blockSize = 1;
        for (int i = 1; i <= nums.size() - 1; ++i) {
            blockSize *= i;
        }
        
        int blockIndex = index / blockSize;
        int newIndex = index % blockSize;
        
        int targetNum = nums.get(blockIndex);
        nums.remove(blockIndex);
        return targetNum + getPermCore(nums, newIndex);
    }
}
