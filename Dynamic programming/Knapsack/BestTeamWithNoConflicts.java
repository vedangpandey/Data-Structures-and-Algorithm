class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n=scores.length;
        int[][] ageScore=new int[n][2];
        for(int i=0;i<n;i++){
            ageScore[i][0]=ages[i];
            ageScore[i][1]=scores[i];
        }
        Arrays.sort(ageScore,(a,b)->a[0]-b[0]==0?a[1]-b[1]:a[0]-b[0]);
        
        int[][] dp=new int[n][n+1];
        for(int[] z:dp)
        Arrays.fill(z,-1);
        return findMax(ageScore,0,-1,dp);
    }
    int findMax(int[][] ageScore,int in,int prev,int[][] dp){
        if(in==ageScore.length)
        return 0;
        if(dp[in][prev+1]!=-1)
        return dp[in][prev+1];
        int take=0;
        if(prev == -1 ||ageScore[in][1]>=ageScore[prev][1])
        take=ageScore[in][1]+findMax(ageScore,in+1,in,dp);
        int notTake=findMax(ageScore,in+1,prev,dp);

        return dp[in][prev+1]=Math.max(take,notTake);
    }
}