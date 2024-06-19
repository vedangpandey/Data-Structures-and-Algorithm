class Solution {
    public int tallestBillboard(int[] rods) {
        int max=0;
        for(int i=0;i<rods.length;i++){
            max+=rods[i];
        }
        int[][] dp=new int[rods.length][10001];
        for(int[] z:dp)
        Arrays.fill(z,-1);
        return findMax(rods,0,0,dp);
    }
    int findMax(int[] arr,int in,int diff ,int[][] dp){
        
        if(in==arr.length)
        if(diff==0)
        return 0;
        else
        return -(int)1e9;

        if(dp[in][diff+5000]!=-1)
        return dp[in][diff+5000];
        

        int pick1=arr[in]+findMax(arr,in+1,diff+arr[in],dp);
        int pick2=findMax(arr,in+1,diff-arr[in],dp);
        int notPick=findMax(arr,in+1,diff,dp);

        return dp[in][diff+5000]=Math.max(pick1,Math.max(pick2,notPick));
        
    }

}