class Solution {
    public int numDecodings(String s) {
        char[] ch=s.toCharArray();
        int n=s.length();

        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return decode(ch,0,dp);
    }
    public int decode(char[] ch,int in,int[] dp){
      if(in==ch.length)return 1;
      if(dp[in]!=-1)
      return dp[in];
      int take=0;
      int first=ch[in]-'0';
      int second=0;
      if(in<ch.length-1)
       second=Integer.parseInt(""+ch[in]+ch[in+1]);
      if(first>=1&&first<10){
        take+=decode(ch,in+1,dp);
      }
      if(second>=10&&second<=26){
        take+=decode(ch,in+2,dp);
      }

      return dp[in]=take;
    }
}