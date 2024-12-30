package A2dfs;

import java.util.ArrayList;
import java.util.List;

public class A203피로도 {
    static int answer;
    static int static_k;
    static int static_count;
    public static void main(String[] args) {
        int k=80;
        int [][] dungeons = {{80,20},{50,40},{30,10}};
        boolean[] visited = new boolean[dungeons.length];
        static_k = k;
        dfs(dungeons,visited);
        System.out.println(answer);
    }
    static void dfs(int[][] dungeons,boolean[] visited){
        if(static_count>answer){
            answer = static_count;
        }
        for(int i=0; i< dungeons.length;i++){
            if(dungeons[i][0]<=static_k && !visited[i]){
                visited[i] = true;
                static_k -= dungeons[i][1];
                static_count+=1;
                dfs(dungeons,visited);
                visited[i] = false;
                static_k+= dungeons[i][1];
                static_count-=1;
            }
        }
    }
}
