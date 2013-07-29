import java.util.*;

public class Solution {
    
    class Node {
        int index;
        int val;
        public Node(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }
    
    public int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (height.length == 0) {
            return 0;
        }
        
        Stack<Node> st = new Stack<Node>();
        
        int[] rightBounds = new int[height.length];

        st.push(new Node(0, height[0]));
        for (int i = 1; i < height.length; ++i) {
            if (height[i] < st.peek().val) {
                while (st.size() > 0 && st.peek().val > height[i]) {
                    rightBounds[st.peek().index] = i;
                    st.pop();
                }
                st.push(new Node(i, height[i]));
            } else {
                st.push(new Node(i, height[i]));
            }
        }
        while (st.size() > 0) {
            rightBounds[st.peek().index] = height.length;
            st.pop();
        }
        
        int [] leftBounds = new int[height.length];
        st.push(new Node(height.length - 1, height[height.length - 1]));
        for (int i = height.length - 2; i >= 0; --i) {
            if (height[i] < st.peek().val) {
                while (st.size() > 0 && st.peek().val > height[i]) {
                    leftBounds[st.peek().index] = i;
                    st.pop();
                }
                st.push(new Node(i, height[i]));
            } else {
                st.push(new Node(i, height[i]));
            }
        }
        while (st.size() > 0) {
            leftBounds[st.peek().index] = -1;
            st.pop();
        }
        
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; ++i) {
            int curr = height[i] * ( rightBounds[i] - leftBounds[i] - 1);
            max = Math.max(max, curr);
        }
        
        return max;

    }
}
