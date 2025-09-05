package A6투포인터;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A602연속된부분수열의합 {
    public static void main(String[] args) {
        int[] sequence = {1, 1, 1, 2, 3, 4, 5};
        int k = 	5;
        int start =0;
        int end = 0;
        int total=0;
        int[] answer = new int[2];
        int size = sequence.length;
        for(end=0;end<sequence.length;end++){
            total+=sequence[end];

            while(end<sequence.length && total>k){
                total-=sequence[start];
                start++;
            }
            if(total==k){
                if(size>end-start){
                    size = end-start;
                    answer[0] = start;
                    answer[1] = end;
                }
            }
        }
        System.out.println(Arrays.toString(answer));
    }
}
