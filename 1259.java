// [SWEA] 1259. 금속막대 (Java)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Pair{
	int front;
	int rear;
	
	public Pair(int front, int rear) {
		this.front = front;
		this.rear = rear;
	}
}
public class Solution{
	static StringTokenizer st;
	static int n; // 금속막대 갯수
	static boolean[] visit;
	static Pair[] arr;
	static ArrayList<Integer> result;
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= test; t++) {
			
			n = Integer.parseInt(br.readLine());
			arr = new Pair[n];
			visit = new boolean[n];
			result = new ArrayList<>();
			max = 0;
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				int front = Integer.parseInt(st.nextToken());
				int rear = Integer.parseInt(st.nextToken());
				arr[i] = new Pair(front,rear);	
			}
			
			// DFS
			for(int i = 0; i < n; i++) {
				visit[i] = true;
				
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(i);
				solve(i,1,list);
				
				visit[i] = false;
			}

			StringBuffer sb = new StringBuffer("#" + t + " ");
			
			for(int n : result) {
				sb.append(arr[n].front + " " + arr[n].rear + " ");
			}
			
			System.out.println(sb.toString());
		}
	}
	
	public static void solve(int cur, int count, ArrayList<Integer> list) {
		
		// 최댓값 일때
		if(list.size() >= max) {
			max = list.size();
			result = new ArrayList<Integer>();
			// 결과리스트 갱신
			for(int n : list) {
				result.add(n);
			}
		}
		
		// 전체 탐색
		for(int i = 0; i < n; i++) {
			if(!visit[i] && arr[cur].rear == arr[i].front) {
				visit[i] = true;
				
				// 현재 리스트 복사
				ArrayList<Integer> tmpList = new ArrayList<>();
				for(int n : list) {
					tmpList.add(n);
				}
				tmpList.add(i);
				
				solve(i, count + 1, tmpList);
				visit[i] = false;
			}
		}	
	}
}
