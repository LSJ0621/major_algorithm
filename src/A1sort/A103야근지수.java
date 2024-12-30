package A1sort;

import java.util.Arrays;
import java.util.*;

public class A103야근지수 {
    public static void main(String[] args) {
        int n = 4;
        int[] works = {4,3,3};
        long answer = 0;
        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int total = 0;
        for(int i=0; i<works.length;i++){
            total=total+works[i];
        }
        if(total<=n){
            answer = 0;
        }else{
            for(int i=0;i<works.length;i++){
                pq.add(works[i]);
            }
            for(int i=0;i<n;i++){
                pq.add(pq.poll()-1);
            }
            int k = pq.size();
            for(int i=0;i<k;i++){
                int a = pq.poll();
                answer = answer+a*a;
            }
        }
    }
}
