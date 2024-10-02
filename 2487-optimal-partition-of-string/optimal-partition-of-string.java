class Solution {
    public int partitionString(String s) {
        ArrayList<Character> checking = new ArrayList();
        int count = 1;
        for(int i = 0; i < s.length(); i++) {
            if(checking.contains(s.charAt(i))) {
                checking.clear();
                checking.add(s.charAt(i));
                count++;
            } else {
                checking.add(s.charAt(i));
            }
        }
        return count;
    }
}