class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> output_arr = new ArrayList();
        backtrack(output_arr, "", 0, 0, n);
        return output_arr;
    }

    public static void backtrack(ArrayList<String> output_arr, String current_string, int open, int close, int max) {
        if(current_string.length() == max * 2) {
            output_arr.add(current_string);
        }
        if(open < max) backtrack(output_arr, current_string + "(", open + 1, close, max);
        if(close < open) backtrack(output_arr, current_string + ")", open, close + 1, max);
    }
}