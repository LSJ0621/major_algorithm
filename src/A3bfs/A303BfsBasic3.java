package A3bfs;

import java.io.IOException;
import java.util.*;

public class A303BfsBasic3 {
    public static void main(String[] args) {
        int[][] edge = {{0,1}, {0,2}, {1,3}, {2,3}, {2,4}};
//        4번까지 도달하는 최단거리 구하기.
        int targetNode = 4;

        List<List<Integer>> adjList = new ArrayList<>();
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

        int[] distance = new int[5];

        Queue<Integer> myQue = new LinkedList<>();
        myQue.add(0);
        visited[0] = true;

        while (!myQue.isEmpty()) {
            int temp = myQue.poll();

            for (int target : adjList.get(temp)) {
                if (!visited[target]) {
                    myQue.add(target);
                    visited[target] = true;
                    distance[target] = distance[temp]+1;
                    if (target == targetNode) {
//                        targetNode를 발견 시 더 이상의 distance를 구하기 위한 작업은 할 필요없다.
                        break; // 또는 리턴.
                    }
                }
            }
        }

        System.out.println(distance[targetNode]);

    }
}