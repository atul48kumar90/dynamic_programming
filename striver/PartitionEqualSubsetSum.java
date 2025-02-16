/*
 * Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.

 

Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
 */


import java.util.Arrays;

class PartitionEqualSubsetSum {
    
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).boxed().reduce(0,(a, b) -> a+b);

        if(sum%2 != 0) return false;

        Boolean[][] dp = new Boolean[nums.length+1][(sum/2) + 1];
        return f(nums, 0, (sum/2), dp);
    }

    public boolean f(int[] nums, int index, int target, Boolean[][] dp)
    {
        if(index == nums.length || target < 0) return 0 == target;
        if(target == 0) return dp[index][target] = true;

        if (dp[index][target] != null) {
            return dp[index][target];
        }
        return dp[index][target] = (f(nums, index+1, target-nums[index], dp) || f(nums, index+1, target, dp));
    }
}