package A08알고리즘테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class A0803연결요소의개수 {
    static List<List<Integer>> adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        adjList = new ArrayList<>();
        for(int i=0; i<=N; i++){
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i<M; i++){
            String[] str1 = br.readLine().split(" ");
            int s = Integer.parseInt(str1[0]);
            int e = Integer.parseInt(str1[1]);

            adjList.get(s).add(e);
            adjList.get(e).add(s);
        }

        boolean[] visited = new boolean[N+1];
        int answer =0;
        for(int i=1; i<N+1;i++){
            if(visited[i]==false){
                dfs(adjList,visited,i);
                answer ++;
            }
        }
        System.out.println(answer);
    }
    static void dfs(List<List<Integer>> adjList,boolean[] visited ,int start){
        visited[start] = true;
        for(int a : adjList.get(start)){
            if(visited[a]==false){
                dfs(adjList,visited,a);
            }
        }

    }
}
