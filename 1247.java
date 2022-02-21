// [SWEA] 1247. 최적 경로 (Java)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Pair{
	int x;
	int y;
	
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Solution{
	static StringTokenizer st;
	static int n; // 고객의 수
	static Pair start; // 회사 좌표
	static Pair end; // 집의 좌표
	static ArrayList<Pair> list; // 고객의 좌표
	static boolean[] visit; // 방문 여부
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(br.readLine());
		for(int t = 1; t <= test; t++) {
			
			// 회사,집 위치 입력
			n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			start = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			end = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			// 다음 테스트케이스 위해 초기화
			list = new ArrayList<>();
			visit = new boolean[n];
			min = 10000;
			
			// 고객 위치 입력
			for(int i = 0; i < n; i++) {
				list.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			
			// 회사에서 시작하여 DFS 진행
			for(int i = 0; i < n; i++) {
				int one = Math.abs(start.x - list.get(i).x);
				int two = Math.abs(start.y - list.get(i).y);
				
				visit[i] = true;
				solve(list.get(i).x, list.get(i).y, one + two, 1);
				visit[i] = false;
			}
			
			System.out.println("#" + t + " " + min);
		}
	}
	
	public static void solve(int x, int y, int sum, int count) {
		// 이미 거리가 최솟값보다 크다면 리턴
		if(sum >= min) {
			return;
		}
		
		// 모든 고객을 방문했다면 집을 방문하고 최솟값 리턴
		if(count == n) {
			int one = Math.abs(end.x - x);
			int two = Math.abs(end.y - y);
			sum += one+two;
			min = Math.min(min, sum);
			return;
		}
		
		// DFS
		for(int i = 0; i < n; i++) {
			if(visit[i] == false) {
				int one = Math.abs(x - list.get(i).x);
				int two = Math.abs(y - list.get(i).y);
		
				visit[i] = true;
				solve(list.get(i).x, list.get(i).y, sum + one + two, count + 1);
				visit[i] = false;
			}
		}
	}
}
