package hackerRank_18;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 10. 20
 * Time: 오후 5:30
 */
public class Solution {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        double biggerZero = 0;
        double lowerZero = 0;
        double zero = 0;
        int size = arr.length;
        for (Integer array : arr) {
            if (array < 0) {
                lowerZero++;
            } else if(0 < array) {
                biggerZero++;
            } else {
                zero++;
            }
        }
        biggerZero = biggerZero / size;
        lowerZero = lowerZero / size;
        zero = zero / size;

        String f = String.format("%f",biggerZero);
        String f2 = String.format("%f",lowerZero);
        String f3 = String.format("%f",zero);
        System.out.println(f);
        System.out.println(f2);
        System.out.println(f3);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }

}
