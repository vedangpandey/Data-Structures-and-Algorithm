class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->a[1]-b[1]==0?a[0]-b[0]:a[1]-b[1]);
        int n=pairs.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return findMax(pairs,0,-1001,dp);
    }
    int findMax(int[][] pairs,int in,int prev,int[] dp){
        if(pairs.length==in)
        return 0;

        int idx=prev==-1001?0:prev+1;
        if(dp[in]!=-1)
        return dp[in];

        int take=0;
        if(prev==-1001||pairs[in][0]>pairs[prev][1])
        take=1+findMax(pairs,in+1,in,dp);
        int notTake=findMax(pairs,in+1,prev,dp);
        return dp[in]=Math.max(take,notTake);
    }
}