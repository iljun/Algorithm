package hackerRank_10;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 10. 20
 * Time: 오후 4:20
 */
public class Solution {

    static boolean flag;
    static int B;
    static int H;

    static{
        Scanner cin=new Scanner(System.in);
        B=cin.nextInt();
        H=cin.nextInt();
        if(B>0&&H>0){
            flag=true;
        }else{
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        }
    }

    public static void main(String[] args) {
        if(flag) {
            int area = B*H;
            System.out.println(area);
        }
    }
}
