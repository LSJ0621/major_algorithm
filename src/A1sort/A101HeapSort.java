package A1sort;

import javax.imageio.ImageTranscoder;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class A101HeapSort {
    public static void main(String[] args) {
        int[] arr = {7,6,5,8,3,5,9,1,6};
        int length = arr.length;
//        최초힙구성 : 복잡도 n*log(n)
        heapify(arr,arr.length/2-1,length);
        for(int i=arr.length/2-1;i>=0;i--){
            heapify(arr, i,length);
        }
//        루트노드와 최하위노드를 change하면서 heapify
//        최하위노드는 change가 될때마다 자리추가 -1
        for(int i=arr.length-1 ; i>=0;i--){
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            heapify(arr,0,i);
        }
        if(arr[1]>arr[0]){
            int temp = arr[1];
            arr[1]=arr[0];
            arr[0] = temp;
        }
        System.out.println(Arrays.toString(arr));

//        pq를 통한 정렬방법
        int[] newArr = new int[arr.length];
        Queue<Integer> pq = new PriorityQueue<>();
        for(int a : arr){
            pq.add(a);
        }
        for(int i=0; i<newArr.length;i++){
            newArr[i] = pq.poll();
        }
    }
    static void heapify(int[] arr,int parent,int length){
        int left = parent*2+1;
        int right = parent*2+2;
        int len = length;
//        check1: 왼쪽, 오른쪽 노드가 배열의 길이보다 짧아야함
//        check2: parent, left, right 둘중에 parent의 값보다 작은 값이 있을경우 자리 change 후 heapify 재귀호출.
        if(left>=len) return;

        if(right>len){
            return;
        } else if (right==len) {
            if(arr[parent]<arr[left]){
                int temp = arr[parent];
                arr[parent] = arr[left];
                arr[left] = temp;
                heapify(arr,left,length);
            }
        } else{
            int min =0;
            int min_index = 0;
            if(arr[right]>arr[left]){
                min = arr[left];
                min_index = left;
            }else {
                min = arr[right];
                min_index = right;
            }

            if(arr[parent]>min){
                int temp = arr[parent];
                arr[parent] = min;
                arr[min_index] = temp;
                heapify(arr,min_index,length);
            }
        }
    }

}

// 강사님 코드
//static void heapify(int[] arr, int parent){
//    int left = parent*2+1;
//    int right = parent*2+2;
////        check1 : 왼쪽, 오른쪽 노드가 배열의 길이보다 짧아야함
////        check2 : left, right 둘 중에 parent의 값보다 작은 값이 있을경우 자리 change 후 heapify 재귀호출.
//    if(left >= arr.length)return;
//    if(right >= arr.length){
////            left만 존재
//        if(arr[parent] > arr[left]){
//            int temp = arr[parent];
//            arr[parent] = arr[left];
//            arr[left] = temp;
//            heapify(arr, left);
//        }
//    }else {
////            left, right 둘다 존재
//        int index = 0;
//        if(arr[parent] > arr[left] || arr[parent] > arr[right]){
//            if(arr[left]> arr[right]){
//                index = right;
//            }else {
//                index = left;
//            }
//            int temp = arr[parent];
//            arr[parent] = arr[index];
//            arr[index] = temp;
//            heapify(arr, index);
//        }
//    }
//}