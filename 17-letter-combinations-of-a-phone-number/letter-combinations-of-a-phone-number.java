class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        // Edge case: if input is empty, return empty result
        if (digits == null || digits.length() == 0) return result;

        // Mapping from digit to corresponding letters
        Map<Character, String> digitToLetters = new HashMap<>();
        digitToLetters.put('2', "abc");
        digitToLetters.put('3', "def");
        digitToLetters.put('4', "ghi");
        digitToLetters.put('5', "jkl");
        digitToLetters.put('6', "mno");
        digitToLetters.put('7', "pqrs");
        digitToLetters.put('8', "tuv");
        digitToLetters.put('9', "wxyz");

        // Begin backtracking with an empty combination
        backtrack(digits, digitToLetters, new StringBuilder(), 0, result);
        return result;
    }

    private void backtrack(String digits, Map<Character, String> digitToLetters, 
                           StringBuilder currEle, int index, List<String> result) {
        // Base case: if we have formed a combination of the same length as input
        if (index == digits.length()) {
            result.add(currEle.toString()); // store the result
            return;
        }

        // Get the digit and its corresponding characters
        char digit = digits.charAt(index);
        String letters = digitToLetters.get(digit);

        // Explore each letter choice for the current digit
        for (int i = 0; i < letters.length(); i++) {
            currEle.append(letters.charAt(i)); // Choose a letter
            backtrack(digits, digitToLetters, currEle, index + 1, result); // Recurse
            currEle.deleteCharAt(currEle.length() - 1); // Backtrack to try next letter
        }
    }
}
