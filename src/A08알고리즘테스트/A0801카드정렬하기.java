package A08알고리즘테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class A0801카드정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> card = new PriorityQueue<>();

        for(int i=0;i<N;i++){
            card.add(Integer.parseInt(br.readLine()));
        }

        int answer = 0;
        int total = 0;
        while(card.size()!=1){
            total = card.poll()+card.poll();
            card.add(total);
            answer += total ;
        }
        System.out.println(answer);
    }
}
