class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] minLen = new int[n];
        java.util.Arrays.fill(minLen, Integer.MAX_VALUE);
        int ans = Integer.MAX_VALUE;
        int currSum = 0;
        int l = 0;
        
        for (int r = 0; r < n; r++) {
            currSum += arr[r];
            
            while (currSum > target && l <= r) {
                currSum -= arr[l];
                l++;
            }
            
            if (currSum == target) {
                int length = r - l + 1;
                
                if (l > 0 && minLen[l - 1] != Integer.MAX_VALUE) {
                    ans = Math.min(ans, length + minLen[l - 1]);
                }
                
                minLen[r] = (r == 0) ? length : Math.min(minLen[r - 1], length);
            } else {
                minLen[r] = (r > 0) ? minLen[r - 1] : Integer.MAX_VALUE;
            }
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}