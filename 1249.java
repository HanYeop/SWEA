// [SWEA] 1249. 보급로 (Java)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution{
	static int n; // 지도의 크기
	static int min; // 가장 작은 경로의 복구시간
	static int[][] arr; // 지도	
	// 상하좌우
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static Queue<Integer> queueX;
	static Queue<Integer> queueY;
	static boolean[][] visit; // 방문 여부
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= test; t++) {
			
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			visit = new boolean[n][n];
			queueX = new LinkedList<>();
			queueY = new LinkedList<>();
			min = 1000000;
			
			for(int i = 0; i < n; i++) {
				String str = br.readLine();
				for(int j = 0; j < n; j++) {
					arr[i][j] = str.charAt(j) - '0';
				}
			}
			
			visit[0][0] = true;
			
			
			System.out.println("#" + t + " " + min);
		}
	}
	
	public static void bfs(int x, int y, int sum) {
		
		
	}
}
