public class Solution {
    public int[] plusOne(int[] digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
	if (digits == null || digits.length == 0) {
            return digits;
        }
        ++digits[digits.length - 1];
        for (int i = digits.length - 1; i >= 1; --i) {
            if (digits[i] == 10) {
                digits[i] = 0;
                ++digits[i - 1];
            }
        }
        if (digits[0] == 10) {
            int [] result = new int [digits.length + 1];
            for (int i = 0; i < digits.length; ++i) {
                result[i + 1] = digits[i];
            }
            result[0] = 1;
            result[1] = 0;
            return result;
        }

        return digits;

    }
}
