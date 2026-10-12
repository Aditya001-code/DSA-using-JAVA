class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int[] bitCount = new int[32];
        
        // Step 1: Count frequency of 1-bits at each position across all numbers
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if ((num & (1 << i)) != 0) {
                    bitCount[i]++;
                }
            }
        }
        
        long MOD = 1_000_000_007;
        long totalSumOfSquares = 0;
        
        // Step 2: Greedily build the k largest numbers
        for (int i = 0; i < k; i++) {
            long currentNum = 0;
            // For each bit position from 31 down to 0, distribute available bits
            for (int bit = 31; bit >= 0; bit--) {
                if (bitCount[bit] > 0) {
                    currentNum |= (1L << bit);
                    bitCount[bit]--;
                }
            }
            // Add current number's square to the total sum (with modulo)
            totalSumOfSquares = (totalSumOfSquares + (currentNum * currentNum) % MOD) % MOD;
        }
        
        return (int) totalSumOfSquares;
    }
}