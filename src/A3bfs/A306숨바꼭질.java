package A3bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
//백준문제풀이
public class A306숨바꼭질 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);
        int[] check = new int[100001];

        if(N==K){
            System.out.println(0);
        }else{
            Queue<Integer> queue = new LinkedList<>();
            queue.add(N);
            check[N] = 0;
            while (!queue.isEmpty()) {
                int temp = queue.poll();
                for(int i=0;i<3;i++){
                    int next;
                    if(i==0){
                        next = temp+1;
                    }if(i==1){
                        next=temp-1;
                    }else{
                        next=temp*2;
                    }
                    if(next>=0 && next<check.length && check[next]==0){
                        queue.add(next);
                        check[next] =check[temp]+1;
                    }
                    if(next == K){
                        System.out.println(check[next]);
                    }
                }
            }
        }
    }
}
