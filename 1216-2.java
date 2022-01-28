import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	static char[][] arr; // 글자판
	static final int L = 100;

	public static boolean solve(int l) {
		for (int i = 0; i < L; i++) {
			for (int j = 0; j <= (L - l); j++) {
				if(solveRow(i, j, l) || solveColumn(j, i, l) ) return true;
			}
		}
		
		return false;
	}
 
	// 가로 탐색
	public static boolean solveRow(int i, int j, int l) {
		String tmp = "";
		int count = 0;
		
		while(count < l) {
			tmp += arr[i][j+count];
			count++;
		}
		
		// 문자열 뒤집기
		StringBuffer bf = new StringBuffer(tmp);
		String reverse = bf.reverse().toString();

		// 회문 여부 검사
		if(tmp.equals(reverse)) {
			return true;
		}
		
		return false;
	}
	
	// 세로 탐색
	public static boolean solveColumn(int i, int j, int l) {
		String tmp = "";
		int count = 0;
		
		while(count < l) {
			tmp += arr[i+count][j];
			count++;
		}
		
		// 문자열 뒤집기
		StringBuffer bf = new StringBuffer(tmp);
		String reverse = bf.reverse().toString();

		// 회문 여부 검사
		if(tmp.equals(reverse)) {
			return true;
		}
		
		return false;
	}
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int test =0; test<10; test++) {
			int t = Integer.parseInt(br.readLine()); // 테스트 케이스 번호
			arr = new char[L][L];
			
			// 글자판 입력
			for(int i=0; i<L; i++) {
				String str = br.readLine();
				for(int j=0; j<L; j++) {
					arr[i][j] = str.charAt(j);
				}
			}
			
			for(int i=L; i>0; i--) {
				if(solve(i)) {
					System.out.println("#"+ t + " " + i);
					break;
				}	
			}
		}
		
		br.close();
	}
}
