import java.util.*;

public class Solution {
    
    class Node {
        int index;
        char c;
        public Node(char c, int index) {
            this.index = index;
            this.c = c;
        }
    }
    
    public String minWindow(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (S == null || S.length() == 0) {
            return "";
        } else if (T == null || T.length() == 0) {
            return "";
        }
        
        ArrayDeque<Node> q = new ArrayDeque<Node>();
        HashMap<Character, Integer> alphabet = new HashMap<Character, Integer>();
        for (int i = 0; i < T.length(); ++i) {
            if (!alphabet.containsKey(T.charAt(i))) {
                alphabet.put(T.charAt(i), 1);
            } else {
                alphabet.put(T.charAt(i), alphabet.get(T.charAt(i)) + 1);
            }
        }
        
        int minLen = Integer.MAX_VALUE;
        int minBegin = 0;
        int minEnd = -1;
        HashMap<Character, Integer> collector = new HashMap<Character, Integer>();
        for (int i = 0; i < S.length(); ++i) {
            char c = S.charAt(i);
            if (alphabet.containsKey(c)) {
                q.add(new Node(c, i));
                if (!collector.containsKey(c)) {
                    collector.put(c, 1);
                } else {
                    collector.put(c, collector.get(c) + 1);
                }
                
                while (isCovered(collector, alphabet)) {
                    int minCand = q.getLast().index - q.getFirst().index + 1;
                    if (minCand < minLen) {
                        minLen = minCand;
                        minBegin = q.getFirst().index;
                        minEnd = q.getLast().index;
                    }

                    if (collector.get(q.getFirst().c) == 1) {
                        collector.remove(q.getFirst().c);
                    } else {
                        collector.put(q.getFirst().c, collector.get(q.getFirst().c) - 1);
                    }
                    
                    q.poll();
                }
                
            }
        }
        
        return S.substring(minBegin, minEnd + 1);
    }
    
    private boolean isCovered(HashMap<Character, Integer> big, HashMap<Character, Integer> small) {
        if (big.size() < small.size()) {
            return false;
        }
        
        for (char c : small.keySet()) {
            if (!big.containsKey(c) || big.get(c) < small.get(c)) {
                return false;
            }
        }
        return true;
    }
 
	public static void main(String args[]) {
		String s = "ueeouptjcosytyujjcvnmtndauseqxvkdzayrtjvhdtcbnnmrjbfeokfkdjacgnhfnhwjqtsumvvckkvtlbaclfmqqpuwecdtjccavxwiutmedhapkarwhfozwlxapauyeyaavwkpswwvdwmqydoflcejpbkedgdieficeutwqrtvnglllzswewgtzsadydlekvgqpcmhtgejmqwxrpwxletnwtquybakyjbnlnuevynjqmjkbfjojcbhxrdvudismjhxybeuctdsfoegtoxesylqsonouvhgeqgdsmzwfeontvvojstbtgrlxhzrcixjzfmtrnpzrfomalbjeunzcemzllqqwqzxxnqpahqtmggprhyxdlwfsiffwxvspwrnjheloufccnrtusrzfpexalfwjcqyzhnkqrygnfipsclmuclbtrztdgroihojqcwgvumjzxarblfxpsyjjxeofwcqftzwvvesrrbsqcjrpqofimqsmuitsljyejubgytarxsjbecqusxdhnxvifoasyayjwbrxvtoumaxsenmxlrgaqbiyrlqrlraksuhppxjdxgvcwibjbhjukusbfitsbveupljhjvkgdgkzqnirwulgofivqbprwulofvvoshxvnjvdzfxvzkcnqmkgnazlulbbiyqagpvvaszzyyvxkxncjxkyzklvvnxfnpfvearetsgtsbscafflfrlgbwcylzdboiwulnagfgzxhrcjzjugafmceocrpgsdqpzbcahkggjoalzzuuhxbtzfkdxzjpdagcdlenxltgbvuawqwdnyxofhsegdulfcqjnuwkhrtinnljdhptfmhlvbpdflpkqhtddrqljjtywejb";
		String t = "oyutmeghfylklcvbjqfmkxx";
		long t1 = System.currentTimeMillis();
		System.out.println(new Solution().minWindow(s, t));
		long t2 = System.currentTimeMillis();
		System.out.println(t2 - t1);

	}   
}
