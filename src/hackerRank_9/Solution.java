package hackerRank_9;

import java.io.*;
import java.util.Scanner;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 10. 20
 * Time: 오후 4:05
 */
public class Solution {

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String sequence;
        int i = 1;
        while ((sequence = reader.readLine()) != null && sequence.length()!=0) {
            writer.write(String.valueOf(i)+" ");
            i++;
            writer.write(sequence+"\n");
        }
        reader.close();
        writer.flush();
        writer.close();
    }
}
