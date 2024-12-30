package A5DP;

import java.util.ArrayList;
import java.util.List;

public class A502멀리뛰기 {
    public static void main(String[] args){
        int n = 1;
        long answer = 0;

        int[] dp = new int[n+3];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < dp.length; i++) {
            dp[i] = (dp[i-1]%1234567 + dp[i-2]%1234567)%1234567;
        }

        answer = dp[n];
        System.out.println(answer);
    }
}
