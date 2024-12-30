package A6투포인터;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A602연속된부분수열의합 {
    public static void main(String[] args) {
        int[] sequence = {1, 2, 3, 4, 5};
        int start = 0;
        int end = 0;
        int target = 7;
        int total = sequence[0];
        List<int[]> list = new ArrayList<>();
        while (start <= end && end<sequence.length){
            if(total == target){
                list.add(new int[]{start, end});
                total -= sequence[start];
                start++;
            }else if(total > target){
                total -= sequence[start];
                start++;
            }else if(total < target){
                if(end<sequence.length-1){
                    end++;
                    total += sequence[end];
                }else {
                    end++;
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int[] a : list){
            if(a[1]-a[0] < min){
                min = a[1]-a[0];
            }
        }
        int[] answer = new int[2];
        for(int[] a : list){
            if(a[1]-a[0] == min){
                answer = new int[]{a[0], a[1]};
                break;
            }
        }
        System.out.println(Arrays.toString(answer));
    }
}
