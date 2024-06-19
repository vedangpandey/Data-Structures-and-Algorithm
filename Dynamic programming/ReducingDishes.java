class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int n=satisfaction.length+1;
        int[][] dp=new int[n][n];
        for(int[] z:dp)
        Arrays.fill(z,-1);

        Arrays.sort(satisfaction);
        return findMax(satisfaction,0,1,dp);
    }
    int findMax(int[] satisfaction,int in,int curridx,int[][] dp){
        if(in==satisfaction.length)
        return 0;
        if(dp[in][curridx]!=-1)
        return dp[in][curridx];
        int pick=satisfaction[in]*curridx+findMax(satisfaction,in+1,curridx+1,dp);
        int notPick=findMax(satisfaction,in+1,curridx,dp);

        return dp[in][curridx]=Math.max(pick,notPick);
    }
}