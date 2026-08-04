class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        boolean[] seen = new boolean[101];
        List<Integer> missing = new ArrayList<>();

        for(int num : nums){
            seen[num] = true;
            max = Math.max(max , num);
            min = Math.min(min, num);
        }

        for(int i = min; i <= max; i++){
            if(!seen[i]){
                missing.add(i);
            }
        }
        return missing;
    }
}