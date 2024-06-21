class Solution {
    public int numTrees(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return findTrees(n,dp);
    }
    int findTrees(int n,int[] dp){
        if(n==1||n==0)
        return 1;
        if(dp[n]!=-1)
        return dp[n];
        int ans=0;
        for(int i=1;i<=n;i++){
        ans+=findTrees(n-i,dp)*findTrees(i-1,dp);
        }
        return dp[n]=ans;
    }
}