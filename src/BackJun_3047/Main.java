package BackJun_3047;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int[] arr = new int[3];

        for(int i = 0; i<3; i++){
            arr[i] = input.nextInt();
        }

        char[] s = input.next().toCharArray();

        Arrays.sort(arr);

        for(int i=0; i<s.length; i++){
            System.out.print(arr[s[i]-65] + " ");
        }
    }
}