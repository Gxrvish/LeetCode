class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1; // Edge case: n == 0 means only number 0 is valid
        
        int out = 10; // For n = 1, we have numbers 0-9, which is 10 numbers
        int pro = 9;
        
        // Start counting from n = 2 to n digits
        for (int i = 2; i <= n; i++) {
            pro *= (11 - i); // Decrease the available choices for each digit position
            out += pro;
        }
        
        return out;
    }
}
