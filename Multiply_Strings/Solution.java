public class Solution {
    public String multiply(String num1, String num2) {

		String result = "0";

		if (num1.length() == 0 || num2.length() == 0) {
			return result;
		}

		for (int i = num2.length() - 1; i >= 0; --i) {
			String line = multiplyStringChar(num1, num2.charAt(i));
			if (!line.equals("0")){
				for (int j = 0; j < num2.length() - 1 - i; ++j) {
					line += "0";
				}
			}
			result = addStringString(result, line);
		}

		return result;	
    }

	private String addStringString(String num1, String num2) {
		//always asumme num1.length() <= num2.length()
		if (num1.length() > num2.length()) {
			return addStringString(num2, num1);
		}

		String result = "";
		int decimal = 0;
		for(int i = 0; i <= num1.length() - 1; ++i) {
			int col = num1.charAt(num1.length() - 1 - i) - '0' + num2.charAt(num2.length() - 1 - i) - '0'  + decimal;
			if (col >= 10) {
				decimal = 1;
				col = col - 10;
			} else {
				decimal = 0;
			}
			result = col + result;
		}
		for (int i = num2.length() - num1.length() - 1; i >= 0; --i) {
			int col = num2.charAt(i) - '0' + decimal;
			if (col >= 10) {
                decimal = 1;
                col = col - 10;
            } else {
                decimal = 0;
            }
            result = col + result;
		}
		if (decimal > 0) {
			result = 1 + result;
		}
		return result;
	}

	private String multiplyStringChar(String num, char c) {

		if (num.equals("0") || c == '0') {
			return "0";
		}

		String result = "";
		int decimal = 0;
		for (int i = num.length() - 1; i >= 0; --i) {
			int col = (num.charAt(i) - '0') * (c - '0') + decimal;
			if (col >= 10) {
				decimal = col / 10;
				col = col - decimal * 10;
			} else {
				decimal = 0;
			}
			result = col + result;
		}
		if (decimal > 0) {
			result = decimal + result;
		}
		return result;
	}

	public static void main(String args[]) {
		System.out.println(new Solution().multiply("99", "0"));
	}
}
