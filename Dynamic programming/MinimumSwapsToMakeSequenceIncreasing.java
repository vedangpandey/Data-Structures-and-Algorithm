class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int max=0;
        int[][] dp=new int[n][2];
        for(int[] z:dp)
        Arrays.fill(z,-1);
        return findMin(nums1,nums2,0,-1,-1,dp,0);
    }
    int findMin(int[] nums1,int[] nums2,int i,int prev1,int prev2,int[][] dp,int swapped){
      if(nums1.length==i)
      return 0;
      if(dp[i][swapped]!=-1)
      return dp[i][swapped];
      int noSwap=(int)1e9;
      int swap=(int)1e9;
      if(nums1[i]>prev1&&nums2[i]>prev2){
        noSwap=findMin(nums1,nums2,i+1,nums1[i],nums2[i],dp,0);
      }
      if(nums1[i]>prev2&&nums2[i]>prev1){
        swap(nums1,nums2,i);
        swap=1+findMin(nums1,nums2,i+1,nums1[i],nums2[i],dp,1);
        swap(nums1,nums2,i);
      }
      return dp[i][swapped]=Math.min(noSwap,swap);
        
    }
    void swap(int[] nums1,int[] nums2,int i){
        int temp=nums1[i];
        nums1[i]=nums2[i];
        nums2[i]=temp;
    }
}