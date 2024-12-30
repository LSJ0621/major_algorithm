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
