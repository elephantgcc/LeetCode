public class Solution {
    public int sqrt(int x) {
    if (x == 0 ) {
		return x;
	}
	int last = 0;
	int curr = 10;
	while ( Math.abs(curr - last) > 1) {
        last = curr;
		curr = (curr + x / curr) / 2;
	}
	return curr;
    }
}
