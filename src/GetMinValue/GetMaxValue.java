package GetMinValue;

import java.util.HashMap;
import java.util.LinkedList;

public class GetMaxValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(1);
		list.add(3);
		list.add(5);
		list.add(13);
		list.add(21);
		Solution s = new Solution();
		System.out.println(s.solution(list));
	}

}
class Solution{
	public int solution(LinkedList<Integer> list){
		HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
		int listSize=list.size();
		
		for(int i=0; i<listSize; i++){
			int x=list.get(i);
			if(x<10){
				if(hash.containsKey(x)==false){
					hash.put(x,1);
				}else{
					hash.put(x, hash.get(i)+1);
				}
			}else{
				String s = String.valueOf(x);
				for(int j=0; j<s.length(); j++){
					int q=(int)(s.charAt(j))-48;
					if(hash.containsKey(q)==false){
						hash.put(q,1);
					}else{
						hash.put(q, hash.get(q)+1);
					}
				}
			}
		}
		
		int maxValue=0;
		int maxIndex=0;
		for(int i=0; i<10 ;i++){
			if(hash.containsKey(i)){
				if(hash.get(i)>maxValue){
					maxValue=hash.get(i);
					maxIndex=i;
				}
			}
		}

		return maxIndex;
	}
}