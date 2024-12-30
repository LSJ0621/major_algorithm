package A07이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class A703과자나눠주기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int M = Integer.parseInt(str[0]);
        int N = Integer.parseInt(str[1]);

        String[] str1 = br.readLine().split(" ");
        int[] cookie = new int[str1.length];
        for(int i=0;i< cookie.length;i++){
            cookie[i] = Integer.parseInt(str1[i]);
        }
        Arrays.sort(cookie);
        int start = 1;
        int end = cookie[cookie.length-1];
        int answer = 0;
        while(start<=end){
            int total = 0;
            int middle = (start+end)/2;
            for(int i=0;i< cookie.length;i++){
                total = total+cookie[i]/middle;
            }
            if(total>=M){
                start = middle+1;
                answer = middle;
            }else if(total<M){
                end  = middle-1;
            }
        }
        System.out.println(answer);
    }
}
