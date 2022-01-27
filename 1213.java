// [SWEA] 1213. String (Java)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int test =0; test<10; test++) {
			int t = Integer.parseInt(br.readLine()); // 테스트 케이스 번호
			String des = br.readLine(); // 찾을 문자열
			String str = br.readLine(); // 검색할 문장
			int sum = 0; // 찾을 문자열 합
			
			for(int i = 0; i <= str.length()-des.length(); i++) {
				if(des.equals(str.substring(i, i + des.length()))) {
					sum++;
				}
			}
			
			System.out.println("#" + t + " " +sum);
		}	
		br.close();
	}
}
