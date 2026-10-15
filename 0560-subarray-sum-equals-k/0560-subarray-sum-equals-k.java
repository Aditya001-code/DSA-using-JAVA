class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int cnt = 0;
        
        for (int l = 0; l < n; l++) {
            int sum = 0;
            for (int r = l; r < n; r++) {
                sum += nums[r]; // Add elements one by one to expand the subarray
                if (sum == k) {
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
}