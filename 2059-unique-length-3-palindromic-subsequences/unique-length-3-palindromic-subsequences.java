class Solution {
    public int countPalindromicSubsequence(String s) {
        Set<Character> uniqueChars = new HashSet<>();
        for (char c : s.toCharArray()) {
            uniqueChars.add(c);
        }
        
        int totalCount = 0;
        
        for (char c : uniqueChars) {
            int firstIndex = s.indexOf(c); // First occurrence
            int lastIndex = s.lastIndexOf(c); // Last occurrence
            
            if (lastIndex - firstIndex > 1) { // Only process if there's space in between
                Set<Character> middleChars = new HashSet<>();
                for (int i = firstIndex + 1; i < lastIndex; i++) {
                    middleChars.add(s.charAt(i));
                }
                totalCount += middleChars.size();
            }
        }
        
        return totalCount;
    }
}
