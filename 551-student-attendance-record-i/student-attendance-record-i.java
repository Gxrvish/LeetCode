class Solution {
    public boolean checkRecord(String s) {
        int absent = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                absent++;
                if (absent > 1) return false; // Early exit if more than 1 'A'
            }
            if (i >= 2 && s.charAt(i) == 'L' && s.charAt(i - 1) == 'L' && s.charAt(i - 2) == 'L') {
                return false; // Found "LLL"
            }
        }
        
        return true;
    }
}
