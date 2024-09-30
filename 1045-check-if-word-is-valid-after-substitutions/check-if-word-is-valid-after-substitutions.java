class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character> mfproblem = new Stack<>();
        for (int i = 0; i < n; i++) {
            mfproblem.push(s.charAt(i));
            if (s.charAt(i) == 'c' && mfproblem.size() >= 3) {
                char c, b, a;
                c = mfproblem.pop();
                b = mfproblem.pop();
                a = mfproblem.pop();
                if (a == 'a' && b == 'b' && c == 'c') {
                    // fuck this problem
                } else {
                    mfproblem.push(a);
                    mfproblem.push(b);
                    mfproblem.push(c);
                }
            } else if (s.charAt(i) == 'c')
                return false;
        }
        return mfproblem.empty();
    }
}