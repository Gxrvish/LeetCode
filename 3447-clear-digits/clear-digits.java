class Solution {

    public String clearDigits(String s) {
        int[] ans = new int[s.length()];
        Arrays.fill(ans, 0);
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                continue;
            } else {
                for (int j = i - 1; j >= 0; j--) {
                    if(Character.isLetter(s.charAt(j)) && ans[j] == 0) {
                        ans[j] = 1;
                        ans[i] = 1;
                        break;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(Character.isLetter(s.charAt(i)) && ans[i] == 0) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
