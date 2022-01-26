import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] arr = new int[100][100];		
		
		for(int test =0; test<10; test++) {
			int n = Integer.parseInt(br.readLine()); // 한 변의 길이
			
			// 테이블 저장
			for(int i=0; i<100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<100; j++) {
					// 1 = N극, 2 = S극
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int sum = 0;
			// 세로줄 하나씩 탐색
			for(int i=0; i<100; i++) {
				int last = 0; // 최근 마지막 자성체
				
				for(int j=0; j<100; j++) {
					// N극 이면
					if(arr[j][i] == 1) {
						last = 1;
					}
					// S극 이면
					else if(arr[j][i] == 2) {	
						// 최근 마지막 자성체가 N극 이면
						if(last == 1) {
							sum++;
						}
						last = 2;
					}
				}
			}
			System.out.println("#" + (test+1) + " " + sum);
		}
		
		br.close();
	}
}
