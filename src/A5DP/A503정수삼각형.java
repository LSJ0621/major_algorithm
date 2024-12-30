package A5DP;

import java.util.Arrays;
import java.util.List;

public class A503정수삼각형 {
    public static void main(String[] args) {
        int[][] triangle = {
                {7},
                {3, 8},
                {8, 1, 0},
                {2, 7, 4, 4},
                {4, 5, 2, 6, 5}
        };
        int answer = 0;
        for(int i=0; i<triangle.length-1;i++){
            for(int j=0; j< triangle[i+1].length;j++){
                if(j!=0 && j!=triangle[i+1].length-1){
                    if(triangle[i+1][j]+triangle[i][j-1]>triangle[i+1][j]+triangle[i][j]){
                        triangle[i+1][j] = triangle[i+1][j]+triangle[i][j-1];
                    } else if (triangle[i+1][j]+triangle[i][j-1]<=triangle[i+1][j]+triangle[i][j]) {
                        triangle[i+1][j] = triangle[i+1][j]+triangle[i][j];
                    }
                } else if(j==0){
                    triangle[i+1][j] = triangle[i+1][j]+triangle[i][j];
                } else if(j==triangle[i+1].length-1){
                    triangle[i+1][j] = triangle[i+1][j]+triangle[i][j-1];
                }
            }
        }
        int max = Arrays.stream(triangle[triangle.length-1]).max().getAsInt();
        answer = max;
        System.out.println(answer);
    }
}
