class Solution {
    public List<String> stringMatching(String[] words) {
        ArrayList<String> ans = new ArrayList<>();
        Arrays.sort(words, Comparator.comparingInt(String::length));
        for(int i=0; i<words.length-1; i++) {
            boolean meet = false;
            for(int j=i+1; j<words.length; j++) {
                if(words[j].indexOf(words[i]) != -1) {
                    meet = true;
                }
            }
            if(meet == true) {
                ans.add(words[i]);
            }
        }
        return ans;
    }
}