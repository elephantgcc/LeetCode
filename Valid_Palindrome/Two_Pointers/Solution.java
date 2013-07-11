public class Solution {
	public boolean isPalindrome(String s) {
		if (s == null) {
			return false;
		}
		if (s.length() == 0 || s.length() == 1) {
			return true;
		}

		int i = 0, j = s.length() - 1;
		boolean isPal = true;
		while(i < j) {
			if (!isAlphaNumeric(s.charAt(i))) {
				++i;
				continue;
			}
			if (!isAlphaNumeric(s.charAt(j))) {
				--j;
				continue;
			}
			if (s.charAt(i) == s.charAt(j)
					|| s.charAt(i) == s.charAt(j) + 'a' - 'A'
					|| s.charAt(i) + 'a' - 'A' == s.charAt(j)) {
				++i;
				--j;
			} else {
				return false;
			}
		}
		return true;	
	}

	private boolean isAlphaNumeric(char c) {
		if (c >= '0' && c <= '9' || c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z') {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String args[]) {
		String s = "Mb3'.IPC!\",eH`1 L,jMGvqq8''o QO`Pq6z9?LNDT0 0JZ:::.2 w;1yDxS V\"ip.8K.`.;`3h F9'.\"HWS6bn ;v v?',P6P:D4e:X34RXo.Hg3scB 4Mj2k!\"T'.: 5h''19vH.W'E09Y7l 75;q!a'y  3`3;3  y'a!q;57 l7Y90E'W.Hv91''h5 :.'T\"!k2jM4 Bcs3gH.oXR43X:e4D:P6P,'?v v; nb6SWH\".'9F h3;;.`.K8.pi\"V SxDy1;w 2.:::ZJ0 0TDNL?9z6qP`OQ o''8qqvGMj,L 1`He,\"!CPI.'3bM";
		System.out.println(new Solution().isPalindrome(s));
	}
}
