class Solution {
    public int maxSizeSlices(int[] slices) {

        int n=slices.length;
        int canTake=n/3;
        int dp[][]=new int[n][canTake+1];
        int dp1[][]=new int[n][canTake+1];
        int[] arr1=new int[n-1];
        int[] arr2=new int[n-1];
        for(int i=0;i<n-1;i++)
        arr1[i]=slices[i];
        for(int i=1;i<n;i++)
        arr2[i-1]=slices[i];

        for(int[] z:dp)
        Arrays.fill(z,-1);
        for(int[] z:dp1)
        Arrays.fill(z,-1);

        int first= findMax(arr1,0,canTake,dp);
        int second= findMax(arr2,0,canTake,dp1);
        return Math.max(first,second);
    }
    int findMax(int[] slices,int in,int canTake,int[][] dp){
        
        if(in>=slices.length||canTake==0){
            return 0;
        }
        if(dp[in][canTake]!=-1)
        return dp[in][canTake];
        int take=slices[in]+findMax(slices,in+2,canTake-1,dp);
        int notTake=findMax(slices,in+1,canTake,dp);
        return dp[in][canTake]=Math.max(notTake,take);
    }
}