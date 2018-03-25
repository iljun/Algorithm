package BOJ_6679;

public class Main {
    public static void main(String[] args) {

        for (int i = 1000; i < 10000; i++) {
            int result1 = calcurate(i, 10);
            int result2 = calcurate(i, 12);
            int result3 = calcurate(i, 16);
            if (result1 == result2 && result1 == result3)
                System.out.println(i);
        }
    }

    static int calcurate(int i, int k) {
        int sum=0;
        while(i>0){
            sum+=i%k;
            i/=k;
        }
        return sum;
    }
}
