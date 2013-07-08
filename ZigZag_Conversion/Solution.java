public class Solution {
	public String convert(String s, int nRows) {
        	if (s == null || nRows < 0) {
			return null;
		}
		if (nRows == 1) {
			return s;
		}
		int length = s.length();
		StringBuffer result = new StringBuffer();
		for (int row = 0; row < nRows; ++row) {
			int index = row;
			boolean vertical = true;
			while (index < length) {
				if (row == 0 || row == nRows - 1) {
					result.append(s.charAt(index));
					index += (2 * nRows - 2);
				} else {
					if (vertical) {
						result.append(s.charAt(index));
						index += (2 * nRows - 2 * row - 2);
						vertical = false;
					} else {
						result.append(s.charAt(index));
						index += 2 * row;
						vertical = true;
					}
				}
			}
		}
		return result.toString();
	}

	public static void main(String args[]) {
		String s = "A";
		System.out.println(new Solution().convert(s, 1)); 
	}
}
