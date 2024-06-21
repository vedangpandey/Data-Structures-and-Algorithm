class Solution {
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
       
        int[] dp=new int[nums[n-1]+1];
        Arrays.fill(dp,-1);
        return findMax(nums,0,-1,dp);
    }
    int findMax(int[] nums,int in,int prev,int[] dp){
        if(in==nums.length)
        return 0;
        int idx=prev==-1?0:nums[prev];
        if(dp[idx]!=-1)
        return dp[idx];

        int take=0;
        if(prev==-1||nums[prev]+1!=nums[in])
        take=nums[in]+findMax(nums,in+1,in,dp);
        int notTake=0;
        notTake=findMax(nums,in+1,prev,dp);
        return dp[idx]=Math.max(take,notTake);
    }
}