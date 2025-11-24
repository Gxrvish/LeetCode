class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Integer can1 = null, can2 = null;
        int can1count = 0, can2count = 0;
        for (int i = 0; i< nums.length; i++) {
            if (can1 != null && can1 == nums[i]) {
                can1count++;
            } else if (can2 != null && can2 == nums[i]) {
                can2count++;
            } else if (can1count == 0) {
                can1 = nums[i];
                can1count = 1;
            } else if (can2count == 0) {
                can2 = nums[i];
                can2count = 1;
            } else {
                can1count--;
                can2count--;
            }
        }
        can1count = 0;
        can2count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (can1 != null && can1 == nums[i]) {
                can1count++;
            }
            if (can2 != null && can2 == nums[i]) {
                can2count++;
            }
        }
        List<Integer> result = new ArrayList<>();
        if (can1count > nums.length/3) result.add(can1);
        if (can2count > nums.length/3) result.add(can2);
        return result;
    }
}