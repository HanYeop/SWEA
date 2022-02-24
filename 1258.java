// [SWEA] 1258. 행렬찾기 (Java)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Pair implements Comparable<Pair>{
	int row;
	int col;
	
	public Pair(int row, int col) {
		this.row = row;
		this.col = col;
	}

	// 행과 열 곱한 크기가 작은 순으로, 같다면 행이 작은 순으로
	@Override
	public int compareTo(Pair p) {
		int result = 0;
		
		if((row * col) == (p.row * p.col)) {
			result = row - p.row;
		}
		else {
			result = (row * col) - (p.row * p.col);
		}
		return result;
	}
	
}
public class Solution{
	static StringTokenizer st;
	static int n; // 양의 정수
	static int[][] arr; // 행렬
	static boolean[][] visit; // 행렬
	static PriorityQueue<Pair> queue; // 결과 저장
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= test; t++) {
			
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			visit = new boolean[n][n];
			queue = new PriorityQueue<>();
			
			// 행렬 입력
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());				
				for(int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 전체 탐색
			for(int i = 0; i < n; i++) {			
				for(int j = 0; j < n; j++) {
					// 방문하지 않았고, 0이 아닌 곳에서 탐색 시작
					if(!visit[i][j] && arr[i][j] != 0) {
						solve(i,j);
					}
				}
			}

			StringBuffer sb = new StringBuffer("#" + t + " " + queue.size() + " ");
			while(!queue.isEmpty()) {
				Pair cur = queue.poll();
				
				sb.append(cur.row + " " + cur.col + " ");
			}
			
			System.out.println(sb.toString());
		}
	}
	
	public static void solve(int startX, int startY) {
		// 행 크기 구하기
		int row = 0;
		for(int i = startX; i < n; i++) {
			if(arr[i][startY] == 0) {
				break;
			}	
			row++;
		}
		
		// 열 크기 구하기
		int col = 0;
		for(int i = startY; i < n; i++) {
			if(arr[startX][i] == 0) {
				break;
			}	
			col++;
		}
		
		// 사각형 방문처리
		for(int i = startX; i < startX + row; i++) {
			for(int j = startY; j < startY + col; j++) {
				visit[i][j] = true;
			}
		}
		
		queue.offer(new Pair(row,col));
	}
}
