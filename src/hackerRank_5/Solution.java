package hackerRank_5;

import java.util.Scanner;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 10. 20
 * Time: 오후 3:30
 */
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("================================");
        for(int i=0;i<3;i++)
        {
            String s1=sc.next();
            int x=sc.nextInt();
            String result1 = String.format("%-15s",s1);
            String result2 = String.format("%03d",x);
            System.out.println(result1 + result2);
        }
        System.out.println("================================");

    }
}
