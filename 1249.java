// [SWEA] 1249. 보급로 (Java)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Pair{
	int x;
	int y;
	
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class Solution{
	static int n; // 지도의 크기
	static int[][] arr; // 지도	
	static boolean[][] visit; // 지도	
	static int[][] dist;
	// 상하좌우
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= test; t++) {
			
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			visit = new boolean[n][n];
			dist = new int[n][n];
			
			// 지도, 최소비용 입력
			for(int i = 0; i < n; i++) {
				String str = br.readLine();
				for(int j = 0; j < n; j++) {
					arr[i][j] = str.charAt(j) - '0';
				}
			}
			bfs();
			
			System.out.println("#" + t + " " + dist[n -1][n - 1]);
		}
	}
	
	public static void bfs() {
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(0, 0));
		
		while (!q.isEmpty()) {
			Pair cur = q.poll();
			
			for (int i = 0; i < 4; ++i) {
				int nextX = cur.x + dx[i];
				int nextY = cur.y + dy[i];
				
				if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n) {
					continue;
				}
				
				if (!visit[nextX][nextY] || dist[cur.x][cur.y] + arr[nextX][nextY] < dist[nextX][nextY]) {
					visit[nextX][nextY] = true;
					dist[nextX][nextY] = dist[cur.x][cur.y] + arr[nextX][nextY];
					q.offer(new Pair(nextX, nextY));
				}
			}
		}
	}
}
