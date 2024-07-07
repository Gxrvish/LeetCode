class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        s = s.replaceAll("\\s+", " ");
        String[] words = s.split("\\W+");
        String answer = "";
        for(int i = words.length - 1; i >= 0; i--) {
            answer += " " + words[i];
        }
        answer = answer.trim();
        return answer;
    }
}