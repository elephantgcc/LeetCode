public class Solution {
    public boolean isNumber(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s == null || s.length() == 0) {
            return false;
        }
        
        s = s.trim();
        
        if (s.matches("^[-+]?[0-9]+$")) {
            return true;
        } else if (s.matches("^[-+]?([0-9]+\\.[0-9]+|[0-9]*\\.[0-9]+|[0-9]+\\.[0-9]*)$")) {
            return true;
        } else if (s.matches("^[-+]?([0-9]+|[0-9]+\\.[0-9]+|[0-9]*\\.[0-9]+|[0-9]+\\.[0-9]*)e[-+]?[0-9]+$")) {
            return true;
        }
        
        return false;
    }
}
