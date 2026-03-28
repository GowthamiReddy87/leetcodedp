//link:https://leetcode.com/problems/minimum-falling-path-sum/?envType=problem-list-v2&envId=dynamic-programming
package day5;
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++)
        dp[0][i]=matrix[0][i];
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                int up=dp[i-1][j];
                int upleft=(j>0)?dp[i-1][j-1]:Integer.MAX_VALUE;
                int upright=(j<n-1)?dp[i-1][j+1]:Integer.MAX_VALUE;
                 dp[i][j]=matrix[i][j]+Math.min(up,Math.min(upleft,upright));
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        min=Math.min(min,dp[n-1][i]);
        return min;
    }
}