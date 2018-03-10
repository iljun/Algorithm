package BOJ_1120;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String A;
    static String B;

//    public static void main(String[] args) throws IOException {//Solution1
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        String[] AB = reader.readLine().split(" ");
//        A = AB[0];
//        B = AB[1];
//        List<Character> aList = new ArrayList<>();
//
//        for (char a : A.toCharArray()) {
//            aList.add(a);
//        }
//        List<Character> bList = new ArrayList<>();
//
//        for (char b : B.toCharArray()) {
//            bList.add(b);
//        }
//
//        boolean t = false;
//        while (aList.size() != bList.size()) {
//            //앞
//            aList.add(0, '*');
//            int firstValue = calculate(aList, bList);
//            aList.remove(0);
//
//            //뒤
//            aList.add(aList.size(), '*');
//            int lastValue = calculate(aList, bList);
//            aList.remove(aList.size() - 1);
//
//            //Save
//            if (firstValue > lastValue) {
//                aList.add(aList.size(), '*');
//            } else if (firstValue < lastValue) {
//                aList.add(0, '*');
//            } else {
//                //같은경우???
//                t = true;
//                break;
//            }
//        }
//
//        if (t)
//            System.out.println(0);
//        else
//            System.out.println(calculate(aList, bList));
//
//        reader.close();
//    }
//
//    static int calculate(List<Character> a, List<Character> b) {
//        int cnt = 0;
//        for (int i = 0; i < a.size(); i++) {
//
//            if (a.get(i) == '*')
//                continue;
//
//            if (a.get(i) != b.get(i))
//                cnt++;
//        }
//        if(cnt==A.length())
//            return 0;
//
//        return cnt;
//    }

    public static void main(String[] args) throws IOException{//Solution2
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] AB = reader.readLine().split(" ");
        A = AB[0];
        B = AB[1];

        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        int min = Integer.MAX_VALUE;

        for(int i=0;i<b.length-a.length+1; i++){
            min = Math.min(min,calculate(a,b,i));
        }

        System.out.println(min);
    }

    static int calculate(char[] a, char[] b, int index){
        int cnt=0;
        for(int i=0; i<a.length; i++){
            if(a[i]!=b[i+index]){
                cnt++;
            }
        }

        return cnt;
    }
}
