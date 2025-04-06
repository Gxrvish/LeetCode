class Solution {

    public List<String> letterCasePermutation(String s) {
        // This list will store all the valid permutations we generate
        List<String> result = new ArrayList<>();

        // StringBuilder is used for efficient string manipulation during recursion
        StringBuilder path = new StringBuilder();

        // Begin backtracking from index 0
        backtrack(s, 0, path, result);

        return result;
    }

    /**
     * Backtracking function that explores all valid case permutations.
     *
     * @param s       - The original input string.
     * @param index   - The current position in the string we are processing.
     * @param path    - The current built-up string (partial permutation).
     * @param result  - The list storing all complete valid permutations.
     */
    private void backtrack(String s, int index, StringBuilder path, List<String> result) {
        // BASE CASE: We've reached the end of the input string
        if (index == s.length()) {
            // Add a COPY of the current path to the result.
            // Important: new String created from StringBuilder to prevent mutation
            result.add(path.toString());
            return;
        }

        // Get the current character at index
        char ch = s.charAt(index);

        // CASE 1: Digit → Only one path (we can't change digits)
        if (Character.isDigit(ch)) {
            path.append(ch); // Choose the digit
            backtrack(s, index + 1, path, result); // Recurse to next index
            path.deleteCharAt(path.length() - 1); // Backtrack by removing last char
        }
        // CASE 2: Alphabet → Two choices (lowercase + uppercase)
        else {
            // OPTION A: Choose lowercase version
            path.append(Character.toLowerCase(ch)); // Choose lowercase
            backtrack(s, index + 1, path, result); // Recurse
            path.deleteCharAt(path.length() - 1); // Backtrack

            // OPTION B: Choose uppercase version
            path.append(Character.toUpperCase(ch)); // Choose uppercase
            backtrack(s, index + 1, path, result); // Recurse
            path.deleteCharAt(path.length() - 1); // Backtrack
        }
    }
}
