public class Solution {
    public int maxVowels(String s, int k) {
        int ans = 0;
        int maxi = 0;
        String kVowels = "aeiou";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (kVowels.indexOf(c) != -1) {
                maxi++;
            }
            if (i >= k && kVowels.indexOf(s.charAt(i - k)) != -1) {
                maxi--;
            }
            ans = Math.max(ans, maxi);
        }

        return ans;
    }
}
