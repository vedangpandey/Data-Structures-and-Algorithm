class Solution {
    private int mod=(int) 1e9+7;
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int[][][] dp=new int[group.length+1][n+1][minProfit+1];
        for(int[][] a:dp)
        for(int[] z:a)
        Arrays.fill(z,-1);
        int ans=findCount(n,group,profit,minProfit,0,dp);
        return ans;
    }
    int findCount(int n,int[] group,int[] profit,int min,int in,int[][][] dp){
        
        if(in==group.length){
            if(min<=0)return 1;
            else return 0;
        }
        min=min<0?0:min;
        if(dp[in][n][min]!=-1)
        return dp[in][n][min];
         
        int pick=0;
        int notPick=0;
        if(group[in]<=n){
            pick=findCount(n-group[in],group,profit,min-profit[in],in+1,dp);
        }
        notPick=findCount(n,group,profit,min,in+1,dp);

        return dp[in][n][min]=((pick%mod)+(notPick%mod))%mod;
    }
}