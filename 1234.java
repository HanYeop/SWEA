// [SWEA] 1234. 비밀번호 (Java)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
 
public class Solution {
     
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        for(int t = 1; t <= 10; t++) {
            Stack<Character> stack = new Stack<>(); // 문자열 저장할 스택
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken()); // 문자의 총 수
            String str = st.nextToken(); // 번호 문자열
            String result = "";
             
            for(int i = 0; i < l; i++) {
                char cur = str.charAt(i);
                 
                // 스택이 비어있거나 스택 peek가 다른 문자라면 push
                if(stack.isEmpty() || cur != stack.peek()) {
                    stack.push(cur);
                }
                // 스택 peek이 현재 문자와 같다면 pop
                else {
                    stack.pop();
                }
            }
             
            // 스택 내용물 전부 출력
            while(!stack.isEmpty()) {
                result += stack.pop();
            }
             
            // 뒤집어서 출력
            StringBuffer sb = new StringBuffer(result);
            System.out.println("#" + t + " " + sb.reverse().toString());
        }
    }
}
