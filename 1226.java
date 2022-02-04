// [SWEA] 1226. 미로 (Java)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 좌표를 저장할 Pair 클래스
class Pair {
    int x;
    int y;
    
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
	static int N = 16;
	static char[][] arr;
	// 상하좌우
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static Queue<Pair> queue;
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	for(int t = 1; t <= 10; t++) {
    		int test = Integer.parseInt(br.readLine());
    		queue = new LinkedList<Pair>();
    		arr = new char[N][N];
    		
    		// 미로 입력
    		for(int i = 0; i < N; i++) {
    			String str = br.readLine();
    			for(int j = 0; j < N; j++) {
    				arr[i][j] = str.charAt(j);
    			}
    		}
    		
    		System.out.print("#" + test + " ");
    		bfs(1,1);
    	}
    }
    
    public static void bfs(int x, int y) {
    	queue.offer(new Pair(x,y)); // 자기자신 큐에 삽입
    	arr[x][y] = '1'; // 방문처리
    	
    	while(!queue.isEmpty()) {
    		Pair cur = queue.poll();
  		
    		// 상하좌우 탐색
    		for(int i = 0; i < 4; i++) {
    			int curX = cur.x + dx[i];
    			int curY = cur.y + dy[i];
    			
    			// 길이 있다면 queue에 추가, 방문처리
    			if(arr[curX][curY] == '0') {
    				queue.offer(new Pair(curX,curY));
    				arr[curX][curY] = '1';
    			}
    			// 탐색한 길이 도착점이라면 리턴
    			if(arr[curX][curY] == '3') {
    				System.out.println("1");
        			return;
    			}
    		}
    	}
    	
    	System.out.println("0");
    }
}
