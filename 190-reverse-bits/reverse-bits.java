public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int rev = 0;
        for (int i = 0; i < 32; i++) {
            rev <<= 1; // Shift rev left to make space
            rev |= (n & 1); // Add the last bit of n to rev
            n >>= 1; // Shift n right to process next bit
        }
        return rev;
    }

}