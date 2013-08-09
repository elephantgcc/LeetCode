import java.util.*;

public class Solution {

    public int ladderLength(String start, String end, HashSet<String> dict) {
        if (start.equals(end)) {
			return 0;
		}

		ArrayDeque<String> q = new ArrayDeque<String>();
		q.add(start);
		int distance = 1;
		int count = 1;

		while (count > 0) {
			while (count > 0) {
				char[] array = q.poll().toCharArray();
				for (int i = 0; i < array.length; ++i) {
					for (char c = 'a'; c <= 'z'; ++c) {
						if (array[i] == c) {
							continue;
						}
						char temp = array[i];
						array[i] = c;
						String candWord = new String(array);
						if (candWord.equals(end)) {
							return distance + 1;
						}
						if (dict.contains(candWord)) {
							q.add(candWord);
							dict.remove(candWord);
						}
						array[i] = temp;
					}
				}
				--count;
			}
			++distance;
			count = q.size();
		}
		return 0;
    }

	public static void main(String args[]) {
		String start = "sand";
		String end = "acne";
		String [] dict = new String [] {"sane", "scne"};


		HashSet<String> set = new HashSet<String>();
		for (String s : dict) {
			set.add(s);
		}
		long t1 = System.currentTimeMillis();
		System.out.println(new Solution().ladderLength(start, end, set));
		long t2 = System.currentTimeMillis();
		System.out.println(t2 - t1);
	}
}
