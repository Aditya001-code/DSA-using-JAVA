class Solution {
    public int maxSubarrayLength(int[] nums, int k) {

        //Optimal Soln

        Map<Integer, Integer> freqMap = new HashMap<>();

        int maxLen = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            
            // Expand the window by adding the current element
            freqMap.put(nums[right], freqMap.getOrDefault(nums[right], 0) + 1);

            // Shrink the window from the left if the frequency of nums[right] exceeds k
            while (freqMap.get(nums[right]) > k) {
                freqMap.put(nums[left], freqMap.get(nums[left]) - 1);
                left++;
            }

            // Update maximum valid subarray length found so far
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}