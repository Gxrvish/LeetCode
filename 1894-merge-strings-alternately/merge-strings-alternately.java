class Solution {
    public String mergeAlternately(String word1, String word2) {
        String strr = "";
        int lenns = Math.max(word1.length(), word2.length());
        for(int i = 0; i < lenns; i++) {
            if(i < word1.length()) {
                strr += word1.charAt(i);
            }
            if(i < word2.length()) {
                strr += word2.charAt(i);
            }
        }
        return strr;
    }
}