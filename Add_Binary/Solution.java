public class Solution {
    public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (a == null || a.length() == 0) {
            return b;
        } else if (b == null || b.length() == 0) {
            return a;
        }
        
        // assume a.length() <= b.length()
        if (a.length() > b.length()) {
            return addBinary(b, a);
        }
        
        String result = "";
        int bonus = 0;
        for (int i = 0; i <= a.length() - 1; ++i) {
            int na = a.charAt(a.length() - 1 - i) - '0';
            int nb = b.charAt(b.length() - 1 - i) - '0';
            int col = na + nb + bonus;
            if (col >= 2) {
                col = col - 2;
                bonus = 1;
            } else {
                bonus = 0;
            }
            result = col + result;
        }
        
        for (int i = b.length() - a.length() - 1; i >= 0; --i) {
            int nb = b.charAt(i) - '0';
            int col = nb + bonus;
            if (col >= 2) {
                col = col - 2;
                bonus = 1;
            } else {
                bonus = 0;
            }
            result = col + result;
        }

        if (bonus == 1) {
            result = 1 + result;
        }
        
        return result;
    }
}
