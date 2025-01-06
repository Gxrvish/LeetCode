class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] answer = new int[n];
        
        // Left-to-Right Pass
        int balls = 0; // Balls encountered so far
        int operations = 0; // Operations for left side
        for (int i = 0; i < n; i++) {
            answer[i] = operations;
            balls += boxes.charAt(i) - '0';
            operations += balls;
        }
        
        // Right-to-Left Pass
        balls = 0; // Reset balls count
        operations = 0; // Reset operations count
        for (int i = n - 1; i >= 0; i--) {
            answer[i] += operations;
            balls += boxes.charAt(i) - '0';
            operations += balls;
        }
        
        return answer;
    }
}
