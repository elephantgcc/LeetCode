 public class Solution {
    public String simplifyPath(String path) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (path == null || path.length() == 0) {
            return "";
        }

        String[] temp = path.split("/+");
        ArrayList<String> blocks = new ArrayList<String>();
        for (String s : temp) {
            if (!s.equals("")) {
                blocks.add(s);
            }
        }
        for (int i = 0; i < blocks.size(); ++i) {
            if (blocks.get(i).equals(".")) {
                blocks.remove(i);
                --i;
            }
        }
        for (int i = 0; i < blocks.size(); ++i) {
            if (blocks.get(i).equals("..")) {
                if (i - 1 >= 0) {
                    blocks.remove(i);
                    --i;
                    blocks.remove(i);
                    --i;
                } else {
                    blocks.remove(i);
                    --i;
                }
            }
        }
        
        String result = "/";
        if (blocks.size() > 0) {
            for (String block : blocks) {
                result += block + "/";
            }
            result = result.substring(0, result.length() - 1);
        }
        return result;
    }
}



