package A3bfs;

import java.util.*;

public class A305게임맵 {
    public static void main(String[] args) {
        int[][] maps = {
                {1,0,1,1,1},
                {1,0,1,0,1},
                {1,0,1,1,1},
                {1,1,1,0,1},
                {0,0,0,0,1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        maps[0][0] = -1;
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        int answer = -1;
        while (!queue.isEmpty()){
            int[] temp = queue.poll();
            int x = temp[1];
            int y = temp[0];
            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx>=0 && ny>=0 && nx<maps[0].length && ny<maps.length){
                    if(maps[ny][nx]==1){
                        queue.add(new int[]{ny, nx});
                        maps[ny][nx]= maps[y][x]+1;
                    }
                }
            }
        }
        if(maps[maps.length-1][maps[0].length-1] != 1){
            answer = maps[maps.length-1][maps[0].length-1];
        }
        for(int i=0; i<5;i++){
            System.out.println(Arrays.toString(maps[i]));
        }
        System.out.println(answer);
    }
}
