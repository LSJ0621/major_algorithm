package A07이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//1920
public class A0702수찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int M = Integer.parseInt(br.readLine());
        String[] target = br.readLine().split(" ");
        int [] arr = new int[str.length];
        for(int i=0;i<str.length;i++){
            arr[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(arr);
        for(int i=0; i<M;i++){
            int start =0;
            int end = N-1;
            int index = -1;
            while(start<=end){
                int middle = (start+end)/2;
                if(arr[middle]==Integer.parseInt(target[i])){
                    index = middle;
                    break;
                }else if(arr[middle]<Integer.parseInt(target[i])){
                    start = middle+1;
                }else if(arr[middle]>Integer.parseInt(target[i])){
                    end = middle-1;
                }
            }
            if(index!=-1){
                System.out.println(1);
            }else {
                System.out.println(0);
            }
        }

//        for(int i=0; i<arr2.length;i++){
//            if(Arrays.binarySearch(arr1,arr2[i]<0)){
//                System.out.println(0);
//            }else{
//                System.out.println(1);
//            }
//        }
    }
}
