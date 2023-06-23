class Solution {
    int count=0;
    private void countWays(int[] nums,int target,int n){
        if(n==0){
            if(target==0){
                count++;
            }
        }else{
        countWays(nums,target-nums[n-1],n-1);
        countWays(nums,target+nums[n-1],n-1);
        }
    }
    public int findTargetSumWays(int[] nums, int target) {
        countWays(nums,target,nums.length);
        return count;
    }
}
