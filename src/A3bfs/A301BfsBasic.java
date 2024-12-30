package A3bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class A301BfsBasic {
    public static void main(String[] args) throws IOException {
//        방문할 수 있는 정점이 여러개인경우, 정점 번호가 작은것을 먼저 방문
//        dfs 알고리즘 형식의 방문순서를 출력. 출발은 0부터.
//        int[][] edge = {{0,2},{0,1},{1,3},{2,3},{2,4}};
////        bfs로 방문시 0->1->2->3->4
//
////        인접리스트에 담기.(양방향)
//        List<List<Integer>> adjList = new ArrayList<>();
//        for(int i=0;i< edge.length;i++){
//            adjList.add(new ArrayList<>());
//        }
//        for(int[] a:edge){
//            adjList.get(a[0]).add(a[1]);
//            adjList.get(a[1]).add(a[0]);
//        }
//        for(List<Integer> a :adjList){
//            a.sort(Comparator.naturalOrder());
//        }
//        boolean[] visited = new boolean[adjList.size()];
//
////        bfs 알고리즘을 구현하기 위한 Queue 생성
//        Queue<Integer> myQueue = new LinkedList<>();
//        myQueue.add(0);
//        visited[0] = true;
////        Queue가 비워질때까지, 방문을 지속.
////        Queue가 비워진다는 것은 더이상 갈곳이 없을때를 의미. 이때 코드 종료.
//        while (!myQueue.isEmpty()){
//            int temp = myQueue.poll();
//            System.out.println(temp);
//            for(int target : adjList.get(temp)){
//                if(!visited[target]) {
////                    queue에 add하는 시점에 boolean값 세팅
//                    visited[target]= true;
//                    myQueue.add(target);
//                }
//            }
//        }
//        dfs와  bfs
//        1.dfs
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        Queue<Integer> myQueue = new LinkedList<>();
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        int V = Integer.parseInt(str[2]);
        int [][] edge = new int[M][2];
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<M;i++){
            String[] str1 = br.readLine().split(" ");
            edge[i][0] = Integer.parseInt(str1[0]);
            edge[i][1] = Integer.parseInt(str1[1]);
        }
        for(int i=0;i< edge.length+1;i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] a:edge){
            adjList.get(a[0]).add(a[1]);
            adjList.get(a[1]).add(a[0]);
        }

        for(int i=0; i<adjList.size();i++){
            adjList.get(i).sort(Comparator.naturalOrder());
        }

        boolean[] visited = new boolean[edge.length+1];
        dfs(adjList,visited,V);
        System.out.println(adjList);
        boolean[] visited1 = new boolean[adjList.size()];
        myQueue.add(V);
        visited1[V] = true;
        while (!myQueue.isEmpty()){
            int temp = myQueue.poll();
            System.out.println(temp);
            for(int target : adjList.get(temp)){
                if(!visited1[target]) {
                    visited1[target]= true;
                    myQueue.add(target);
                }
            }
        }
    }
    static void dfs(List<List<Integer>> adjList,boolean[] visited, int start){
        System.out.println(start);
        visited[start] = true;
        for(int a : adjList.get(start)){
            if(visited[a]==false){
                dfs(adjList,visited,a);
            }
        }
    }
}
