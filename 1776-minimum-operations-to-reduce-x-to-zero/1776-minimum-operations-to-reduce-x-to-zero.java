class Solution {
    public int minOperations(int[] nums, int x) {
        int target = -x;
        for (int num : nums) {
            target += num;
        }
        
        int n = nums.length;
        if (target < 0) return -1;
        if (target == 0) return n;
        
        int maxLen = -1;
        int currSum = 0;
        int left = 0;
        
        for (int right = 0; right < n; right++) {
            currSum += nums[right];
            
            while (currSum > target && left <= right) {
                currSum -= nums[left];
                left++;
            }
            
            if (currSum == target) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }
        
        return maxLen != -1 ? n - maxLen : -1;
    }
}