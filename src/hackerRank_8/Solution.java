package hackerRank_8;

import java.util.Scanner;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 10. 20
 * Time: 오후 3:51
 */
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i=0; i<t; i++) {
            try {
                long x = sc.nextLong();
                System.out.println(x + " can be fitted in:");
                if (-128 <= x && x <= 127) {
                    System.out.println("* byte");
                }
                try {
                    Short.parseShort(String.valueOf(x));
                    System.out.println("* short");
                } catch (Exception e) {

                }

                try {
                    Integer.parseInt(String.valueOf(x));
                    System.out.println("* int");
                } catch (Exception e) {

                }

                try {
                    Long.parseLong(String.valueOf(x));
                    System.out.println("* long");
                } catch (Exception e) {

                }

            } catch (Exception e) {
                System.out.println(sc.next() + " can't be fitted anywhere.");
            }
        }
    }
}
