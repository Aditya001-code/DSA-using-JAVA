class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);           // O(nlogn)

        for(int i = 0; i < n-3; i++){   // O(n)

            // Skip Duplicates---
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for(int j = i+1; j < n-2; j++){         // 0(n)

                // Skip Duplicates-----
                if (j > i+1 && nums[j] == nums[j - 1]) continue;

                int l = j+1 ; int r = n-1;

                // Two Pointers---------------------

                while(l < r){

                    long sum = (long) nums[i] + nums[j] + nums[l] + nums[r];
                    
                    if(sum == target){
                        ans.add(Arrays.asList(nums[i],nums[j],nums[l],nums[r]));
                        l++;
                        r--;

                        // Skip Duplicate l and r ------------

                        while (l < r && nums[l] == nums[l - 1]) l++;
                        while (l < r && nums[r] == nums[r + 1]) r--;
                    }

                    else if(target > sum){
                        l++;
                    }
                    
                    else if(sum > target){
                        r--;
                    }
                }
            }
        }
        return ans;
    }
}