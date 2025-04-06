class Solution {
    public List<String> letterCombinations(String digits) {
        // Edge case: empty input string returns empty list
        if (digits == null || digits.isEmpty()) return new ArrayList<>();

        // Mapping each digit to its corresponding letters on the phone keypad
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc"); map.put('3', "def");
        map.put('4', "ghi"); map.put('5', "jkl");
        map.put('6', "mno"); map.put('7', "pqrs");
        map.put('8', "tuv"); map.put('9', "wxyz");

        List<String> result = new ArrayList<>();

        // Start recursive backtracking
        backtrack(digits, map, new StringBuilder(), 0, result);

        return result;
    }

    // Backtracking helper
    private void backtrack(String digits, Map<Character, String> map, StringBuilder current, int index, List<String> result) {
        // Base case: if the length of current string equals digits length
        if (index == digits.length()) {
            result.add(current.toString());  // Add the fully formed combination
            return;
        }

        // Get the letters corresponding to current digit
        String letters = map.get(digits.charAt(index));

        // Explore all possible characters for the current digit
        for (char c : letters.toCharArray()) {
            current.append(c);  // Choose a letter
            backtrack(digits, map, current, index + 1, result);  // Recurse
            current.deleteCharAt(current.length() - 1);  // Backtrack (remove last letter added)
        }
    }
}
