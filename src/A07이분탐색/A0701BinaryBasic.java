package A07이분탐색;

public class A0701BinaryBasic {
    public static void main(String[] args) {
//        이분탐색은 사전에 데이터가 오름차순 정렬이 되어있어야 가능한 알고리즘.
        int[] arr ={1,3,5,7,8,11,13,15,17,19};
        int target = 17;
        int answer = -1;
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int middle = (end+start)/2;
            if(arr[middle]>target){
                end = middle-1;
            }else if(arr[middle]<target){
                start = middle+1;
            }else if(arr[middle] == target){
                answer=middle;
                break;
            }
        }
        System.out.println(answer);
    }
}
