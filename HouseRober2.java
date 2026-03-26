//link:https://leetcode.com/problems/house-robber-ii/?envType=problem-list-v2&envId=dynamic-programming
package day2;
class Solution {
    public int robhelp(int[] nums) {
      if(nums.length==1)
      return nums[0];
      if(nums.length==2)
      return Math.max(nums[0],nums[1]);
      int[] dp=new int[nums.length];
      dp[0]=nums[0];
      dp[1]=Math.max(nums[0],nums[1]);
      for(int i=2;i<nums.length;i++)
      {
        dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1]);
      }
      return dp[nums.length-1];
    }
     public int rob(int[] nums) {
        if(nums.length==0)
        return 0;
        if(nums.length==1)
        return nums[0];
     int[] arr1=new int[nums.length-1];
     int[] arr2=new int[nums.length-1];
     for(int i=0;i<nums.length-1;i++)
     {
        arr1[i]=nums[i];
        arr2[i]=nums[i+1];
     }
     return Math.max(robhelp(arr1),robhelp(arr2));
     }
}
