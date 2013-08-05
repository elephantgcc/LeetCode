import java.util.*;

/**
 * Definition for an interval.
 */
class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
}

public class Solution {

	class Node {
		int val;
		int dir;
		public Node(int val, int dir) {
			this.val = val;
			this.dir = dir;
		}
	}

	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {

		ArrayList<Interval> result = new ArrayList<Interval>();
		if (intervals == null || intervals.size() == 0) {
			return result;
		}
		Node[] nodes = new Node[intervals.size() * 2];
        for (int i = 0; i < intervals.size(); ++i) {
			nodes[2 * i] = new Node(intervals.get(i).start, -1);
            nodes[2 * i + 1] = new Node(intervals.get(i).end, 1);
		}
		Arrays.sort(nodes, new Comparator() {
								public int compare(Object o1, Object o2) {
									Node node1 = (Node)o1;
									Node node2 = (Node)o2;
									if (node1.val != node2.val) {
										return node1.val - node2.val;
									} else {
										return node1.dir - node2.dir;
									}
								}
							});
		int sum = 0;
		int start = 0;
		int end = 0;
		for (int i = 0; i < nodes.length; ++i) {
			if (sum == 0) {
				start = nodes[i].val;
			}
			if (nodes[i].dir == -1) {
				++sum;
			} else {
				--sum;
			}
			if (sum == 0) {
				end = nodes[i].val;
				result.add(new Interval(start, end));
			}
		}
		return result;
    }

	public static void main(String args[]) {
		ArrayList<Interval> list = new ArrayList<Interval>();
		for (int i = 0; i < 1000; ++i) {
			Interval v = new Interval(i, i*i);
			list.add(v);
		}
		list = new Solution().merge(list);
		for (Interval i : list) {
			System.out.println(i.start + "\t" + i.end);
		}
	}
}
