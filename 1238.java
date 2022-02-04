// [SWEA] 1238. Contact (Java)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int l; // 데이터의 길이
	static int start; // 시작점
	static int size = 100 + 1; // 연락인원 (100) + 1
	static int[] visit; // 연락받은 인원 체크
	static int[][] graph; // 연락망
	static Queue<Integer> queue;
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	for(int t = 1; t <= 10; t++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		graph = new int[size][size];
    		queue = new LinkedList<>();
    		visit = new int[size];
    		
    		l = Integer.parseInt(st.nextToken());
    		start = Integer.parseInt(st.nextToken());
    		
    		st = new StringTokenizer(br.readLine());
    		
    		// 연락망 입력
    		for(int i = 0; i < l/2; i++) {
    			int from = Integer.parseInt(st.nextToken());
    			int to = Integer.parseInt(st.nextToken());
    			
    			graph[from][to] = 1;
    		}	
    		
    		System.out.print("#" + t + " ");
    		bfs(start);
    	}
    }
    
    public static void bfs(int x) {
    	queue.offer(x); // 자기자신 큐에 삽입
    	visit[x] = 1; // 방문처리
    	int max = 0; // 번호가 가장 큰 사람
    	ArrayList<Integer> list = new ArrayList<>(); // max 값 저장
    	
    	while(!queue.isEmpty()) {
    		int queueSize = queue.size();
    		max = 0;
    		
    		// 같은 레벨에서 반복하여 레벨 별로 최대값 찾기
    		for(int t = 0; t < queueSize; t++) {
				int cur = queue.poll();
				for(int i = 1; i < size; i++) {
					// 연락 가능하다면 큐에 삽입하고 방문처리
					if(graph[cur][i] == 1 && visit[i] == 0) {
						queue.offer(i);
						visit[i] = 1;
						max = Math.max(max, i);
					}
				}
    		}
    		list.add(max); // 최대값 추가
    	}
    	
    	// 최대 레벨의 최댓값 출력
    	System.out.println(list.get(list.size()-2));
    }
}
