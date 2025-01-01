class Solution {
    public int maxScore(String s) {
        int maxCount = 0;
        int numberOfOne = 0;
        for(int i = 0; i<s.length(); i++) {
            if(s.charAt(i) == '1') {
                numberOfOne += 1;
            }
        }

        int leftSome = 0, rightSome = numberOfOne;
        for(int i = 0; i<s.length()-1; i++) {
            if(s.charAt(i) == '0') {
                leftSome++;
            } else {
                rightSome--;
            }
            maxCount = Math.max(maxCount, rightSome + leftSome);
        }

        return maxCount;
    }
}