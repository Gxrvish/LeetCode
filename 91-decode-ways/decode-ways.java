public class Solution {
    public int numDecodings(String s) {
        // Edge case: If the string is empty or starts with '0', it cannot be decoded
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        
        int n = s.length();
        
        // dp[i] will store the number of ways to decode the substring s[0..i-1]
        int[] dp = new int[n + 1];
        
        // Base case: there's one way to decode an empty string
        dp[0] = 1;
        
        // Base case: there's one way to decode a string of length 1 if s[0] is not '0'
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            // Check for single digit decoding
            int oneDigit = Integer.parseInt(s.substring(i - 1, i)); // s[i-1]
            if (oneDigit >= 1 && oneDigit <= 9) {
                dp[i] += dp[i - 1];
            }
            
            // Check for two digit decoding
            int twoDigits = Integer.parseInt(s.substring(i - 2, i)); // s[i-2,i-1]
            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        
        // The number of ways to decode the entire string is stored in dp[n]
        return dp[n];
    }
}
