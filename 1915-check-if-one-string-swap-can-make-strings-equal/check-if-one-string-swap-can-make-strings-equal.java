class Solution {

    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) return true; // Already equal

        int first = -1, second = -1;
        int mismatchCount = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                mismatchCount++;

                if (mismatchCount > 2) return false; // More than 2 mismatches, swap won't work

                if (first == -1) {
                    first = i; // Store first mismatch position
                } else {
                    second = i; // Store second mismatch position
                }
            }
        }

        return (mismatchCount == 2 && s1.charAt(first) == s2.charAt(second) && s1.charAt(second) == s2.charAt(first));
    }
}
