// [SWEA] 2115. 벌꿀채취 (Java)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{
	static StringTokenizer st;
	static int n; // 벌통 크기
	static int m; // 선택할 수 있는 벌통의 개수
	static int c; // 채취할 수 있는 꿀의 최대 양
	static int result; // 결과
	static int[][] arr;
	static int[][] dp;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= test; t++) {
			st = new StringTokenizer(br.readLine());			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			arr = new int[n][n];
			dp = new int[n][n - m + 1];
			result = 0;
			
			// 꿀 정보 입력
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// i,j 칸에서 시작했을 때 최대 채취 가능한 꿀의 양 dp
			for(int i = 0; i < n; i++) {
				for(int j = 0; j <= (n - m); j++) {
					combi(j, i, j, j + m, 0, 0);
				}
			}
			
			// 구해진 dp에서 2개 선택 (범위 겹치는 경우 제외)
			for(int i = 0; i < n; i++) {
				for(int j = 0; j <= (n - m); j++) {
					maxCombi(i, j);
				}
			}
			
			System.out.println("#" + t + " " + result);
		}
	}
	
	public static void combi(int startCol, int row, int col, int scope, int count, int sum) {	
		// 최대 양 넘어가면 return
		if(count > c) {
			return;
		}
		
		// dp 갱신
		if(sum > dp[row][startCol]) {
			dp[row][startCol] = sum;
		}
		
		// 모든 경우 조합 탐색
		for(int i = col; i < scope; i++) {
			int cur = arr[row][i];
			combi(startCol, row, (i + 1), scope, (count + cur), (sum + (cur * cur)));
		}
	}
	
	public static void maxCombi(int row, int col) {
		int cur = dp[row][col];
		
		for(int i = row; i < n; i++) {
			for(int j = 0; j <= (n - m); j++) {
				// 범위 겹치는 경우 제외
				if(i == row) {
					int curCol = j + col;
					if((curCol + m) <= (n - m)) {
						result = Math.max(result, cur + dp[i][curCol + m]);
					}
				}
				else{
					result = Math.max(result, cur + dp[i][j]);
				}
			}
		}
	}
}
