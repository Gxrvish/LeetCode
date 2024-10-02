import java.util.AbstractList;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        return new AbstractList<>() {
            List<List<Integer>> ans;

            public int size() {
                if (ans == null)
                    init();
                return ans.size();
            }

            public List<Integer> get(int i) {
                if (ans == null)
                    init();
                return ans.get(i);
            }

            private void init() {
                Set<List<Integer>> res = new HashSet<>();
                Arrays.sort(nums);
                int n = nums.length;
                for (int i = 0; i < n - 2; i++) {
                    int left = i + 1;
                    int right = n - 1;
                    while (left < right) {
                        int sum = nums[i] + nums[left] + nums[right];
                        if (sum == 0) {
                            res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                            left++;
                            right--;
                        } else if (sum < 0)
                            left++;
                        else
                            right--;
                    }
                }
                ans = new ArrayList<>(res);
            }
        };
    }
}