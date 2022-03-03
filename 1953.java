// [SWEA] 1953. 탈주범 검거 (Java)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{
	static StringTokenizer st;
	static int n; // 지도 세로 크기
	static int m; // 지도 가로 크기
	static int r; // 맨홀 세로 위치
	static int c; // 맨홀 가로 위치
	static int l; // 탈출 후 소요된 시간
	static int[][] map; // 지도 정보
	static boolean[][] visit; // 방문 정보
	static boolean[][] check; // 갈 수 있는 장소 체크
	static int result;
	
	// 상하좌우
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	// 터널 타입
	static int[][] type = {
			{0,0,0,0},
			{1,1,1,1},
			{1,1,0,0},
			{0,0,1,1},
			{1,0,0,1},
			{0,1,0,1},
			{0,1,1,0},
			{1,0,1,0}
	};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= test; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			map = new int[n][m];
			visit = new boolean[n][m];
			check = new boolean[n][m];
			result = 0;
			
			// 지도 입력
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < m; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			visit[r][c] = true;
			dfs(r,c,1);
			
			// 체크된 장소 개수 세기
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(check[i][j]) {
						result++;
					}
				}
			}
			
			System.out.println("#" + t + " " + result);
		}
	}
	
	public static void dfs(int x, int y, int count) {
		check[x][y] = true; // 장소 체크
		
		// 시간 도달 시 리턴
		if(count == l) {
			return;
		}
		
		int curType = map[x][y]; // 현재 터널 타입
		
		for(int i = 0; i < 4; i++) {
			
			// 갈 수 없는 방향이면 무시
			if(type[curType][i] == 0) {
				continue;
				
			}
			
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			
			// null check
			if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
				continue;
			}
			
			// 이미 방문한 곳이라면 무시
			if(visit[nextX][nextY]) {
				continue;
			}
						
			int nextType = map[nextX][nextY]; // 다음 터널 타입
			
			// 다음 파이프가 없다면 무시
			if(nextType == 0) {
				continue;
			}
			
			// 위로 갈 때 연결되지 않은 경우 무시
			if (i == 0 && (nextType == 3 || nextType == 4 || nextType == 7)) {
				continue;
			}
			// 아래로 갈 때 연결되지 않은 경우 무시
			else if (i == 1 && (nextType == 3 || nextType == 5 || nextType == 6)) {
				continue;
			}
			// 왼쪽으로 갈 때 연결되지 않은 경우 무시
			else if (i == 2 && (nextType == 2 || nextType == 6 || nextType == 7)) {
				continue;
			}
			// 오른쪽으로 갈 때 연결되지 않은 경우 무시
			else if (i == 3 && (nextType == 2 || nextType == 4 || nextType == 5)) {
				continue;
			}
			
			visit[nextX][nextY] = true;
			dfs(nextX, nextY, count + 1);
			visit[nextX][nextY] = false;
		}
	}
}
