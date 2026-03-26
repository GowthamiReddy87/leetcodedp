package day2;
public class Frogjump {
    static int frogJump(int[] steps)
    {
        if(steps.length == 0) {
            return 0;
        }
        if(steps.length == 1) {
            return Math.abs(steps[1]-steps[0]);
        }
        int[] dp = new int[steps.length];
        dp[0] = 0;
        dp[1] = Math.abs(steps[1]-steps[0]);
        for(int i=2; i<steps.length; i++) {                                                                                                     
            int jump1 = dp[i-1] + Math.abs(steps[i]-steps[i-1]);
            int jump2 = dp[i-2] + Math.abs(steps[i]-steps[i-2]);
            dp[i] = Math.min(jump1, jump2);
        }
        return dp[steps.length - 1];
    }
    public static void main(String[] args) {
        int[] steps = {5,1,6,9};
        System.out.println(frogJump(steps));
    }   
}