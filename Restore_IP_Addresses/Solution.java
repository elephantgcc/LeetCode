public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return restoreCore(s, 4);
    }
    
    private ArrayList<String> restoreCore(String s, int n) {
        ArrayList<String> result = new ArrayList<String>();
        int minLen = n;
        int maxLen = n * 3;
        if ( s.length() > maxLen || s.length() < minLen) {
            return result;
        }
        
        if (n == 1) {
            if (s.length() >= 2 && s.charAt(0) == '0') {
                return result;
            }
            int curr = Integer.parseInt(s);
            if (curr > 255) {
                return result;
            } else {
                result.add(s);
                return result;
            }
        }
        
        for (int i = 1; i <= 3 && i < s.length(); ++i) {
            String substring = s.substring(0, i);
            if (i >= 2 && substring.startsWith("0")) {
                continue;
            }
            int curr = Integer.parseInt(substring);
            if (curr > 255) {
                continue;
            }
            ArrayList<String> subResult = restoreCore(s.substring(i), n - 1);
            if (subResult.size() != 0) {
                for (String str : subResult) {
                    result.add(curr + "." + str);
                }
            }
        }
        
        return result;
    }
}
