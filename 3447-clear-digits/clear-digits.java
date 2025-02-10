class Solution {

    public String clearDigits(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // Remove the most recent letter if available
                if (!stack.isEmpty() && Character.isLetter(stack.peek())) {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }

        // Construct result from the stack
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }
}
