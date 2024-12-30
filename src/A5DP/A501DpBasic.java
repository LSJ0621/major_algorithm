package A5DP;

import java.util.Arrays;

public class A501DpBasic {
    public static void main(String[] args) {
//        1,4,5 로 13을 만들수 있는 조합중에 가장 작은 조합의 개수
//        greedy로 풀경우 : 5개 (5*2+1*3)
//        dfs, bfs로 풀경우 일반적으로 시간초과나도록 설계.

//        dp로 풀경우: (5*1+4*2)
//        Min(f(n-1)+f(n-2)...) +1
        int target = 13;
        int[] numbers = {1,4,5};
        int[] arr = new int[target+1];
        int[] arr1 = new int[target+1];
        arr[1] = 1;
        for(int i=2; i<arr.length;i++){
            int min = Integer.MAX_VALUE;
            for(int n : numbers){
                if(i-n>=0 && min>arr[i-n]){
                    min = arr[i-n];
                }
            }
            arr[i] = min+1;
            arr1[i] = min;
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr1));
    }
}
