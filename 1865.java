// [SWEA] 1865. 동철이의 일 분배 (Java)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algorithm {

	static int n;
	static int[] visited;
	static double[][] arr;
	static double max;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= test; t++) {
			n = Integer.parseInt(br.readLine());
			max = Double.MIN_VALUE;
			arr = new double[n][n];
			visited = new int[n];
			
			for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					arr[i][j] = Double.parseDouble(st.nextToken()) * 0.01;
				}
			}
			for(int i = 0; i < n; i++) {
				visited[i] = 1;
				solve(i,0,100);
				visited[i] = 0;
			}
			
			System.out.println("#" + t + " " + String.format("%.6f", max) );
		}
	}	
	
	static void solve(int x, int count, double sum) {
		double curSum = sum * arr[x][count];
		if(curSum < max) {
			return;
		}
		
		if(count == n - 1) {
			max = curSum;
		}
		
		for(int i = 0; i < n; i++) {
			if(visited[i] == 0) {
				visited[i] = 1;
				solve(i, count + 1, curSum);
				visited[i] = 0;
			}
		}
	}
}
