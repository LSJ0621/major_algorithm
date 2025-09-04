package A5DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A504땅따먹기 {
    public static void main(String[] args) {
        int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
        int answer = 0;
        int index = 0;
        while(true){
            for(int i=0; i<4;i++){
                int temp = land[index+1][i];
                for(int j=0;j<4;j++) {
                    if(i!=j&&temp+land[index][j]>land[index+1][i]){
                        land[index+1][i] = temp+land[index][j];
                    }
                }
            }
            index++;
            if(index== land.length-1){
                break;
            }
        }
        int max = Arrays.stream(land[land.length-1]).max().getAsInt();
        answer = max;
        System.out.println(max);
    }
}

// 땅따먹기 dfs로 풀었을때 풀이, dfs방식을 잘 보자.
// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.*;

// public class Main {
//     static int count;
//     static int answer;
//     public static void main(String[] args) throws IOException {
// //        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int[][] land = {
//                 {1,2,3,5},
//                 {5,6,7,8},
//                 {4,3,2,1}
//         };
//         boolean[][] visited = new boolean[land.length][4];
//         dfs(land,visited,0);
//         System.out.println(answer);
//     }

//     static void dfs(int[][] land, boolean[][]visited,int n){
//         if(n== land.length){
//             if(count>answer){
//                 answer = count;
//             }
//             return;
//         }
//         for(int i=0; i< 4;i++){
//             if(!visited[n][i]){
//                 count+=land[n][i];
//                 if(n<land.length-1){
//                     visited[n+1][i] = true;
//                 }
//                 dfs(land,visited,n+1);
//                 if(n<land.length-1){
//                     visited[n+1][i]=false;
//                 }
//                 count-=land[n][i];
//             }
//         }
//     }


// }
