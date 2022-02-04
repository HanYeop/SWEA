// [SWEA] 1267. 작업순서 (Java)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int v; // 정점의 총 수
	static int e; // 간선의 총 수
	static int[][] graph; // 관계 그래프
	static int[] visit; // 방문 그래프
	static int[] degree; // 차수 그래프
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	for(int t = 1; t <= 10; t++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		
    		v = Integer.parseInt(st.nextToken());
    		e = Integer.parseInt(st.nextToken());
    		graph = new int[v+1][v+1];
    		visit = new int[v+1];
    		degree = new int[v+1];
    				
    		st = new StringTokenizer(br.readLine());
    		
    		// 그래프 반대로 연결
    		for(int i = 0; i < e; i++) {
    			int x = Integer.parseInt(st.nextToken());
        		int y = Integer.parseInt(st.nextToken());
        		
        		degree[x]++;
    			graph[y][x] = 1;
    		}
    		
    		System.out.print("#" + t + " ");
    		// 반대지점에서 출발 (차수가 0인 것)
    		for(int i = 1; i <= v; i++) {
    			if(degree[i] == 0) {
    				dfs(i);
    			}
    		}
    		System.out.println();
    	}
    }
    
    // 제일 나중에 도착한 지점이 먼저 나옴 (stack)
    public static void dfs(int x) {
    	visit[x] = 1;
    	
    	for(int i = 1; i <= v; i++) {
    		if(graph[x][i] == 1 && visit[i] == 0) {
    			dfs(i);
    		}
    	}
    	
    	System.out.print(x + " ");
    }
}
