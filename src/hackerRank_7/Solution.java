package hackerRank_7;

import java.util.Scanner;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 10. 20
 * Time: 오후 3:41
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            int prev = a;
            for (int j=0; j<n; j++) {
                prev += b * Math.pow(2,j);
                System.out.print(prev + " ");
            }
            System.out.println();
        }
        in.close();
    }
}
