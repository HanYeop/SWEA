// [SWEA] 2117. 홈 방범 서비스 (Java)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{
	static StringTokenizer st;
	static int n; // 도시의 크기
	static int m; // 하나의 집이 지불할 수 있는 비용
	static int max;
	static int[][] arr; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= test; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			max = Integer.MIN_VALUE;
			arr = new int[n][n];
			
			// 도시 정보 입력
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 모든 경우의 수 탐색
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					find(i,j,0);
				}
			}
			System.out.println("#" + t + " " + max);
		}
	}
	
	public static void find(int row, int col, int money) {
		int k = 1;
		
		while(true) {
			
			int cost = 0;
			int profit = 0;
			
			for(int i = (row - k + 1); i < (row + k); i++) {
				for(int j = (col - k + 1); j < (col + k); j++) {
					
					// 맨해튼 거리 (마름모 영역)
					int dist = Math.abs(row - i) + Math.abs(col - j);
					if(dist < k) {
						cost++;
						
						// null check
						if(i < 0 || j < 0 || i >= n || j >= n) {
							continue;
						}
						
						if(arr[i][j] == 1) {
							profit++;
						}
					}
				}
			}
			
			k++;
			
			// 손해보지 않을 때 최대 집 개수 갱신
			int result = (profit * m) - cost;
			if(result >= 0) {
				max = Math.max(max, profit);
			}
			
			// 그 점을 기준점으로 하는 모든 경우의 수 종료
			if(k > n + 1) {
				return;
			}
		}
	}
}
