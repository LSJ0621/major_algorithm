package A08알고리즘테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class A0804적록색약 {
    static int dx[]={0,0,1,-1};
    static int dy[]={1,-1,0,0};
    static boolean visit[][];
    static int N;
    static int arr[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visit = new boolean[N][N];

        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<N;j++){
                if(str.charAt(j)=='R'){
                    arr[i][j] = 1;
                } else if (str.charAt(j)=='G') {
                    arr[i][j]=2;
                }else{
                    arr[i][j] = 3;
                }
            }
        }

        int normal=0;

        for(int i =0; i<N;i++){
            for(int j=0;j<N;j++){
                if(!visit[i][j]){
                    bfs(i,j);
                    normal++;
                }
            }
        }


        visit = new boolean[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(arr[i][j]==2){
                    arr[i][j]=1;
                }
            }
        }


        int blind=0;
        for(int i =0; i<N;i++){
            for(int j=0;j<N;j++){
                if(!visit[i][j]){
                    bfs(i,j);
                    blind ++;
                }
            }
        }

        System.out.println(normal +" "+blind);
    }

    static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        visit[x][y]=true;
        int color = arr[x][y];

        while(!q.isEmpty()){
            int p[] = q.poll();
            for(int i =0; i<4;i++){
                int nx = p[0]+dx[i];
                int ny = p[1]+dy[i];
                if(0<=nx&&nx<N && 0<=ny&&ny<N && !visit[nx][ny]){
                    if(arr[nx][ny]==color){
                        visit[nx][ny]=true;
                        q.add(new int[]{nx,ny});
                    }
                }
            }
        }
    }
}
