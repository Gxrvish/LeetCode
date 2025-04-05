class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        backtrack(used, nums, result, new ArrayList<>(), 0);
        return result;
    }
    private void backtrack(boolean[] used, int[] nums, List<List<Integer>> result, List<Integer> currPermu, int start) {
        if(currPermu.size() == nums.length) {
            result.add(new ArrayList<>(currPermu));
            return;
        }
        for(int i=0; i<nums.length; i++) {
            if(!used[i]) {
                currPermu.add(nums[i]);
                used[i] = true;
                backtrack(used, nums, result, currPermu, i + 1);
                currPermu.remove(currPermu.size() - 1);
                used[i] = false;
            }
        }
    }
}