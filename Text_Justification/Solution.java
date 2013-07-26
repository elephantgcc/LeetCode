import java.util.*;

public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> result = new ArrayList<String>();
        if (words == null || words.length == 0) {
            return result;
        }
        
        int count = 0;
        ArrayList<String> candidates = new ArrayList<String>();
        for (int i = 0; i < words.length; ++i) {
            if (count + words[i].length() > L) {
                String line = makeLine(candidates, L);
                result.add(line);
                candidates.clear();
                count = 0;
            }
            candidates.add(words[i]);
            count += words[i].length();
            ++count; // at least one space after;
        }
        if (candidates.size() > 0) {
            String line = "";
            for (String can : candidates) {
                line += can;
                if (line.length() < L) {
                    line += " ";
                }
            }
            int restLength = L - line.length();
            for(int j = 0; j < restLength; ++j) {
                line += " ";
            }
            result.add(line);
        }
        return result;
    }
    
    private String makeLine(ArrayList<String> candidates, int L) {
        String line = "";
        if (candidates.size() == 1) {
            line = candidates.get(0);
            int restLength = L - line.length();
            for (int j = 0; j < restLength; ++j) {
                line += " ";
            }
        } else {
            int totalSpaceNum = L;
            for (String can : candidates) {
                totalSpaceNum -= can.length();
            }
            int avgSpaceNum = totalSpaceNum / (candidates.size() - 1);
            String avgSpaces ="";
            for (int j = 0; j < avgSpaceNum; ++j) {
                avgSpaces += " ";
            }
            int extraSpaceNum = totalSpaceNum % (candidates.size() - 1);

            for(int j = 0; j < candidates.size(); ++j) {
                line += candidates.get(j);
                if (j < candidates.size() - 1) {
                     line += avgSpaces;
                }
                if (j < extraSpaceNum) {
                    line += " ";
                }
            }
        }
        return line;
    }
	public static void main(String args[]) {
		String[] A = {"This", "is", "an", "example", "of", "text", "justification."};
		//String[] A = new String[] {""};
		System.out.println(new Solution().fullJustify(A, 16));
	}
}
