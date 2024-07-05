class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<>();
        int max = Arrays.stream(candies).max().getAsInt();
        int k = 0;
        for(int i = 0; i < candies.length; i++){
            k = candies[i] + extraCandies;
            if(k >= max){
                ans.add(true);
            }
            else{
                ans.add(false);
            }
        }
        return ans;
    }
}