class Solution {
    public int integerBreak(int n) {
        if (n <= 3) return n - 1; // Base cases

        int product = 1;

        // Break into as many 3s as possible
        while (n > 4) {
            product *= 3;
            n -= 3;
        }

        // Multiply the remainder
        product *= n;

        return product;
    }
}