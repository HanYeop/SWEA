// [SWEA] 1218. 괄호 짝짓기 (Java)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
	static Stack<Character> stack;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int test = 1; test <= 10; test++) {
			int l = Integer.parseInt(br.readLine()); // 테스트케이스 길이
			stack = new Stack<>();
			int result = 1;
			
			String str = br.readLine();
			
			for(int i = 0; i < l; i++) {
				char ch = str.charAt(i);
				// 스택이 비어 있을 때
				if(stack.isEmpty()) {
					// 닫는 괄호가 들어왔다면
					if(CloseAdd(ch)) {
						result = 0;
						break;
					}
					// 닫는 괄호가 아니라면 스택에 추가
					else {
						stack.add(ch);
					}
				}
				
				// 스택이 비어있지 않을 때
				else {
					// 여는 괄호가 들어왔다면
					if(!CloseAdd(ch)) {
						stack.add(ch);
					}
					
					// 닫는 괄호가 들어왔을 때 짝이 맞는지 판별
					else if(CompareSign(stack.pop(),ch)) {
						result = 0;
						break;
					}
				}
			}
			System.out.println("#" + test + " " + result );
		}	
		br.close();
	}
	
	public static boolean CloseAdd(char ch) {
		if(ch == ')' || ch == ']' || ch == '}' || ch == '>') {
			return true;
		}
		return false;
	}
	
	public static boolean CompareSign(char pop, char add) {
		// 짝이 맞을 때 false 리턴
		if(pop == '(' && add == ')' || pop == '[' && add == ']'
			|| pop == '{' && add == '}' || pop == '<' && add == '>') {
			return false;
		}
		
		// 짝이 맞지 않을 때 true 리턴
		return true;
	}
	
}
