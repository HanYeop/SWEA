// [SWEA] 1240. 단순 2진 암호코드 (Java)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n; // 세로 크기
	static int m; // 가로 크기
	static int start; // 시작점
	static String str; // 탐색할 암호
	static String[] password;
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	password = new String[10];
    	createPassword();
    	
    	int t = Integer.parseInt(br.readLine());
    	for(int c = 1; c <= t; c++) {
    		
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		n = Integer.parseInt(st.nextToken());
    		m = Integer.parseInt(st.nextToken());
    		start = -1;
    		
    		// 한줄씩 거꾸로 봐서 시작점, 종료점 찾기 
    		for(int i = 0; i < n; i++) {
    			String tmp = br.readLine();

    			// 암호를 찾지 못했을 때 암호 찾기
    			if(start == -1) {
    				// 암호의 길이가 56 이므로 j가 55보다 작아지면 탐색 필요 X 				
    				for(int j = m - 1; j >= 55; j--) {
    					// 모든 암호의 끝이 1이므로 끝이 1인지 체크하여 종료점 체크
        				if(tmp.charAt(j) - '0' == 1) {
        					start = j - 55;
        					str = tmp.substring(start, j+1); // 암호 문자열
        					break;
        				}
        			}
    			}
    		}
    		System.out.println("#" + c + " " + check());
    	}
    }
    
    // 암호코드 그림 만들기
    public static void createPassword() {
    	password[0] = "0001101";
    	password[1] = "0011001";
    	password[2] = "0010011";
    	password[3] = "0111101";
    	password[4] = "0100011";
    	password[5] = "0110001";
    	password[6] = "0101111";
    	password[7] = "0111011";
    	password[8] = "0110111";
    	password[9] = "0001011";
    }
    
    // 암호코드 검사
    public static int check() {
    	int index = 0;
    	int correct = 0; // 검사식
    	int sum = 0; // 합계
    	
    	// 8개의 암호 해독
    	for(int i = 1; i <= 8; i++) {		
    		for(int j = 0; j <= 9; j++) {
    			// 암호 매칭
    			if(password[j].equals(str.substring(index, index+7))) {
    				
    				// 짝수번이면 * 3
    				if(i % 2 == 1) {
    					correct = correct + (j * 3);
    				}
    				else {
    					correct += j;
    				}
    				sum += j;
    				break;
    			}
    		}
    		index += 7;
    	}
    	
    	// 암호가 맞는지 검사, 틀리면 0
    	if(correct % 10 != 0) {
    		sum = 0;
    	}
    	
    	return sum;
    }
}
