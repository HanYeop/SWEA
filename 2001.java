// [SWEA] 2001. 파리 퇴치 (Java)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{
	static StringTokenizer st;
	static int n;
	static int m;
	static int dir;
	static int max;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(br.readLine());
			
		for(int t = 1; t <= test; t++) {
			st = new StringTokenizer(br.readLine());
			
			max = 0;
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			arr = new int[n][n];
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					arr[i][j] =	Integer.parseInt(st.nextToken()); 
				}
			}
			
			dir = n - m;
			
			for(int i = 0; i <= dir; i++) {
				for(int j = 0; j <= dir; j++) {
					solve(i,j);
				}
			}
			
			System.out.println("#" + t + " " + max);
		}
	}
	
	public static void solve(int x, int y) {
		int sum = 0;
		
		for(int i = x; i < x + m; i++) {
			for(int j = y; j < y + m; j++) {
				sum += arr[i][j];
			}
		}
		
		max = Math.max(max, sum);
	}
}
