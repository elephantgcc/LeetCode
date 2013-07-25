public class Solution {
    public int lengthOfLastWord(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int lastStart = s.length() - 1;
        while (lastStart >= 0 && !isAlpha(s.charAt(lastStart))) {
            --lastStart;
        }
        if (lastStart >= 0) {
            int begin = lastStart;
            while ((begin - 1) >= 0 && isAlpha(s.charAt(begin - 1))) {
                --begin;
            }
            return (lastStart - begin + 1);
        }
        return 0;
    }
    
    public boolean isAlpha(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
            return true;
        }
        return false;
    }
}
