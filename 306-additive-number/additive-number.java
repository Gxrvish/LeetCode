import java.math.BigInteger;

class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();

        // Try all combinations of first and second numbers
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                String num1 = num.substring(0, i);
                String num2 = num.substring(i, j);

                // Skip leading zeros
                if ((num1.length() > 1 && num1.charAt(0) == '0') ||
                    (num2.length() > 1 && num2.charAt(0) == '0')) {
                    continue;
                }

                BigInteger n1 = new BigInteger(num1);
                BigInteger n2 = new BigInteger(num2);

                if (isValid(n1, n2, j, num)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isValid(BigInteger n1, BigInteger n2, int start, String num) {
        while (start < num.length()) {
            BigInteger sum = n1.add(n2);
            String sumStr = sum.toString();

            // If the next part of the string doesn't match the expected sum
            if (!num.startsWith(sumStr, start)) {
                return false;
            }

            start += sumStr.length();
            n1 = n2;
            n2 = sum;
        }

        return true;
    }
}
