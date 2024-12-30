package A3bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class A302BfsBasic2 {
    public static void main(String[] args) throws IOException {
//        방문할 수 있는 정점이 여러개인경우, 정점 번호가 작은것을 먼저 방문
//        dfs 알고리즘 형식의 방문순서를 출력. 출발은 0부터.
        int[][] edge = {{0,2},{0,1},{1,3},{2,3},{2,4}};
//        bfs로 방문시 0->1->2->3->4
        int[] distance = new int[edge.length];
//        인접리스트에 담기.(양방향)
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i< edge.length;i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] a:edge){
            adjList.get(a[0]).add(a[1]);
            adjList.get(a[1]).add(a[0]);
        }
        for(List<Integer> a :adjList){
            a.sort(Comparator.naturalOrder());
        }
        boolean[] visited = new boolean[adjList.size()];

//        bfs 알고리즘을 구현하기 위한 Queue 생성
        Queue<Integer> myQueue = new LinkedList<>();
        myQueue.add(0);
        visited[0] = true;
//        Queue가 비워질때까지, 방문을 지속.
//        Queue가 비워진다는 것은 더이상 갈곳이 없을때를 의미. 이때 코드 종료.
        while (!myQueue.isEmpty()){
            int temp = myQueue.poll();
            System.out.println(temp);

            for(int target : adjList.get(temp)){
                if(!visited[target]) {
//                    queue에 add하는 시점에 boolean값 세팅
                    visited[target]= true;
                    myQueue.add(target);
                    distance[target]= distance[temp]+1;
                }
            }
        }
        System.out.println(Arrays.toString(distance));

    }
}
