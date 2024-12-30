package A4greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A402체육복 {
    public static void main(String[] args) {
        int n = 3;
        int[] lost = {3};
        int[] reserve = {1};
        int [] use = new int[n];
        Arrays.fill(use,1);

        for(int i=0; i<reserve.length;i++){
            use[reserve[i]-1] = 2;
        }
        for(int i=0;i<lost.length;i++){
            if(use[lost[i]-1]==2){
                use[lost[i]-1] =1;
            } else use[lost[i]-1] = 0;
        }

        int answer =0;

        for(int i=0;i<use.length;i++){
            if(use[i]==0){
                if(i>=1 && use[i-1]==2){
                    use[i] =1;
                    use[i-1] =1;
                } else if (i<=n-2 && use[i+1]==2) {
                    use[i] = 1;
                    use[i+1] =1 ;
                }
            }
        }
        for(int i=0; i<use.length;i++){
            if(use[i]>=1){
                answer++;
            }
        }
        System.out.println(Arrays.toString(use));
        System.out.println(answer);
    }
}
