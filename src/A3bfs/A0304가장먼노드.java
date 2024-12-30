package A3bfs;

import java.util.*;

public class A0304가장먼노드 {
    public static void main(String[] args) {
        int n = 6;
        int[][] edge = {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};
        int[] distance = new int[edge.length];
        List<List<Integer>> adjList = new ArrayList<>();
        List<Integer> total = new ArrayList<>();

        for (int i = 0; i < edge.length; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < edge.length; i++) {
            adjList.get(edge[i][0]).add(edge[i][1]);
            adjList.get(edge[i][1]).add(edge[i][0]);
        }
        for (List<Integer> a : adjList) {
            a.sort(Comparator.naturalOrder());
        }

        boolean[] visited = new boolean[adjList.size()];

        Queue<Integer> myQue = new LinkedList<>();
        myQue.add(1);
        visited[1] = true;
        for(int i=1;i<=n;i++){
            while (!myQue.isEmpty()) {
                int temp = myQue.poll();
                for (int target : adjList.get(temp)) {
                    if (!visited[target]) {
                        myQue.add(target);
                        visited[target] = true;
                        distance[target] = distance[temp]+1;
                        if (target == i) {
                            break; // 또는 리턴.
                        }
                    }
                }
            }
            total.add(distance[i]);
        }
        total.sort(Comparator.naturalOrder());
        int max = total.get(n-1);
        int answer= 0;
        for(int i=0; i<total.size();i++){
            if(total.get(i)==max){
                answer++;
            }
        }
        System.out.println(answer);
    }
}
