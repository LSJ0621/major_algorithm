package A08알고리즘테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class A0802A와B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        int a = str2.length()-str1.length();
        for(int i=0;i<a;i++){
            if(str2.charAt(str2.length()-1) == 'B'){
                str2 = str2.substring(0,str2.length()-1);
                StringBuffer sb = new StringBuffer(str2);
                str2 = sb.reverse().toString();
            } else if (str2.charAt(str2.length()-1) == 'A') {
                str2 = str2.substring(0,str2.length()-1);
            }
        }

        if(str1.equals(str2)){
            System.out.println(1);
        }else {
            System.out.println(0);
        }
    }
}
