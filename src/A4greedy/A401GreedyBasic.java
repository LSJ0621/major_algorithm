package A4greedy;

import java.util.Arrays;

public class A401GreedyBasic {
//    greedy : 현재로서 최적의 해를 선택했을 때, 전체의 최적의 해를 보장하는 알고리즘.
    public static void main(String[] args) {
//        1,5,10,20 숫자를 조합하여 99를 만들수 있는 조합중 가장 짧은 조합의 길이
        int[] arr = {1,5,10,20};
        int  target = 99;
        Arrays.sort(arr);
        int total = 0;
        for(int i= arr.length-1;i>=0;i--){
            total+=target/arr[i];
            target%=arr[i];
        }
        System.out.println(total);
    }
}
