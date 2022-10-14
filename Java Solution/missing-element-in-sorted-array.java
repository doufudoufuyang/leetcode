class Solution {
    public int missingElement(int[] nums, int k) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] - mid - nums[0] >= k){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        int gap = nums[left] - left - nums[0];
        if (gap >= k){
            return nums[left] - gap + k - 1;
        }
        return nums[left] + k - gap;
    }
}