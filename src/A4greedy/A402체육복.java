package A4greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A402체육복 {
    public static void main(String[] args) {
         int n =6;
        int[] lost = {2,4,6};
        int[] reserve = {1,3,5,6};
        Arrays.sort(lost);
        Arrays.sort(reserve);
        for(int i=0;i<lost.length;i++){
            for(int j=0; j<reserve.length;j++){
                if(reserve[j]==lost[i]){
                    lost[i]=-1;
                    reserve[j]=-1;
                }
            }
        }
        for (int i = 0; i < lost.length; i++) {
            for(int j=0; j<reserve.length;j++){
                if(reserve[j]==lost[i]-1 || reserve[j]==lost[i]+1){
                    if(reserve[j]!=-1){
                        lost[i]=-1;
                        reserve[j]=-1;
                        break;
                    }
                }
            }
        }
        int count =0;
        for(int i=0;i<lost.length;i++){
            if(lost[i]!=-1){
                count++;
            }
        }
        int answer = n-count;
        System.out.println(answer);
    }
}
