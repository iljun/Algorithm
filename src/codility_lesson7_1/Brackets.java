package codility_lesson7_1;

import java.util.Stack;
/*

Task description
A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:

S is empty;
S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
S has the form "VW" where V and W are properly nested strings.
For example, the string "{[()()]}" is properly nested but "([)()]" is not.

Write a function:

class Solution { public int solution(String S); }

that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.

For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.

Assume that:

N is an integer within the range [0..200,000];
string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
Copyright 2009–2017 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */
public class Brackets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "{[()()]}";
		System.out.println(solution(S));
	}

	public static int solution(String S){
		int N = S.length();
		char[] array = S.toCharArray();

		Stack<Character> s = new Stack<>();
		for(int i=0; i<N; i++){
			if(array[i]=='(' || array[i]=='{' || array[i]=='[')
				s.push(array[i]);
			else{
				if(s.isEmpty())
					return 0;

				if(array[i]==']'){
					if(s.pop()!='[')
						return 0;
				}else if(array[i]=='}'){
					if(s.pop()!='{')
						return 0;
				}else if(array[i]==')'){
					if(s.pop()!='(')
						return 0;
				}
			}
		}

		if(!s.isEmpty())
			return 0;

		return 1;
	}
}
