package BackJun_1092;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int N;
    static List<Integer> crane = new ArrayList<>();
    static int M;
    static List<Integer>[] box;
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());


        String[] craneList = reader.readLine().split(" ");
        for(int i=0; i<N; i++){
            crane.add(Integer.parseInt(craneList[i]));
        }

        Collections.sort(crane);

        M = Integer.parseInt(reader.readLine());
        box = new ArrayList[N];

        for(int i=0; i<N; i++){
            box[i]=new ArrayList<Integer>();
        }

        String[] boxList = reader.readLine().split(" ");
        for(int i=0; i<M; i++){
            int boxs = Integer.parseInt(boxList[i]);
            if(boxs>crane.get(crane.size()-1)){
                System.out.println("-1");
                return ;
            }
            for(int j=0; j<crane.size(); j++){
                if(crane.get(j)>=boxs){
                    box[j].add(boxs);
                    break;
                }
            }
        }

        for(int i=0; i<crane.size(); i++){
            Collections.sort(box[i]);
        }

        int time=0;
        int cnt=0;
        for(int i=0; i<M && cnt<M; i++){
            for(int j=crane.size()-1; j>=0; j--){
                if(!box[j].isEmpty()){
                    box[j].remove(0);
                    cnt++;
                }else{
                    for(int k=j; k>=0; k--){
                        if(!box[k].isEmpty() && box[k].get(0)<=crane.get(j)){
                            box[k].remove(0);
                            cnt++;
                            break;
                        }
                    }
                }
            }
            time++;
        }

        System.out.println(time);
    }
}
