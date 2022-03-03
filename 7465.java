// [SWEA] 7465. 창용 마을 무리의 개수 (Java)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution{
	static StringTokenizer st;
	static int n; // 사람의 수
	static int m; // 관계의 수
	static ArrayList<ArrayList<Integer>> list;
	static boolean[] visit;
	static int result;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= test; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			result = 0;
			
			visit = new boolean[n + 1];
			// 연결리스트 초기화
			list = new ArrayList<>();
			for(int i = 0; i <= n; i++) {
				list.add(new ArrayList<>());
			}
			
			// 관계 입력
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				list.get(x).add(y);
				list.get(y).add(x);
			}
			
			// 연결된 리스트 탐색
			for(int i = 1; i <= n; i++) {
				// 방문하지 않은 새로운 사람일 경우
				if(!visit[i]) {
					solve(i);
					result++; // 무리 개수 ++
				}
			}

			System.out.println("#" + t + " " + result);
		}
	}
	
	public static void solve(int index) {
		visit[index] = true; // 방문 처리
		// 연결된 리스트 탐색
		for(int n : list.get(index)) {
			if(!visit[n]) {
				solve(n);
			}
		}
	}
}
