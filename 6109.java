// [SWEA] 6109. 추억의 2048게임 (Java)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{
	static int n; // 한 변의 길이
	static String s; // 이동 방향
	static int[][] arr; // 타일 정보
	static boolean[][] visit; // 합친 값 정보
	static StringTokenizer st;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
       
        for(int x = 1; x <= t; x++) {
        	
        	st = new StringTokenizer(br.readLine());    	
        	n = Integer.parseInt(st.nextToken());
        	s = st.nextToken();
        	
        	arr = new int[n + 2][n + 2];
        	visit = new boolean[n + 2][n + 2];
        	
        	// 외곽 -1 처리
        	for(int i = 0; i < arr.length; i++) {
        		arr[0][i] = -1;
        		arr[i][0] = -1;
        		arr[arr.length-1][i] = -1;
        		arr[i][arr.length-1] = -1;
        	}
        	
        	// 타일 입력
        	for(int i = 1; i <= n; i++) {
        		st = new StringTokenizer(br.readLine());
        		for(int j = 1; j <= n; j++) {
        			arr[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        	
        	// 왼쪽 위 부터 탐색
        	if(s.equals("left")) {	
				for(int i = 1; i <= n; i++) {
		    		for(int j = 2; j <= n; j++) {
		    			left(i,j);
		    		}
				}
        	}
        	
        	// 오른쪽 아래 부터 탐색
        	else if(s.equals("right")) {
        		for(int i = n; i > 0; i--) {
        			for(int j = n - 1; j > 0; j--) {
        				right(i,j);
        			}
        		}
        	}
        	
        	// 왼쪽 위 부터 탐색
			else if(s.equals("up")) {
				for(int i = 2; i <= n; i++) {
		    		for(int j = 1; j <= n; j++) {
		    			up(i,j);
		    		}
				}
			}
        	
        	// 오른쪽 아래 부터 탐색
			else if(s.equals("down")) {
				for(int i = n - 1; i > 0; i--) {
        			for(int j = n; j > 0; j--) {
        				down(i,j);
        			}
        		}
			}
        	      	
        	System.out.println("#" + x);
        	for(int i = 1; i < arr.length - 1; i++) {
        		for(int j = 1; j < arr.length - 1; j++) {
        			System.out.print(arr[i][j] + " ");
        		}
        		System.out.println();
        	}
        }
    }
    public static void left(int i, int j) {	
		// 왼쪽 칸이 0 일 때 현재 칸을 왼쪽으로
		if(arr[i][j-1] == 0) {
			arr[i][j-1] = arr[i][j];
			arr[i][j] = 0;
			left(i,j-1); // 합쳐지거나 갈 곳이 없을 때 까지
		}
		// 왼쪽 칸과 같으면 합쳐서 왼쪽으로
		else if(arr[i][j] == arr[i][j-1] && !visit[i][j-1] ) {
			arr[i][j-1] = (arr[i][j] * 2);
			arr[i][j] = 0;
			visit[i][j-1] = true;
		}
    }
    
    public static void right(int i, int j) {	
		// 오른쪽 칸이 0 일 때 현재 칸을 오른쪽으로
		if(arr[i][j+1] == 0) {
			arr[i][j+1] = arr[i][j];
			arr[i][j] = 0;
			right(i,j+1); // 합쳐지거나 갈 곳이 없을 때 까지
		}
		// 오른쪽 칸과 같으면 합쳐서 오른쪽으로
		else if(arr[i][j] == arr[i][j+1] && !visit[i][j+1] ) {
			arr[i][j+1] = (arr[i][j] * 2);
			arr[i][j] = 0;
			visit[i][j+1] = true;
		}
    }
    
    public static void up(int i, int j) {	
		// 위 칸이 0 일 때 현재 칸을 위로
		if(arr[i-1][j] == 0) {
			arr[i-1][j] = arr[i][j];
			arr[i][j] = 0;
			up(i-1,j); // 합쳐지거나 갈 곳이 없을 때 까지
		}
		// 위 칸과 같으면 합쳐서 위로
		else if(arr[i][j] == arr[i-1][j] && !visit[i-1][j] ) {
			arr[i-1][j] = (arr[i][j] * 2);
			arr[i][j] = 0;
			visit[i-1][j] = true;
		}
    }
    
    public static void down(int i, int j) {	
    	// 아래 칸이 0 일 때 현재 칸을 아래로
		if(arr[i+1][j] == 0) {
			arr[i+1][j] = arr[i][j];
			arr[i][j] = 0;
			down(i+1,j); // 합쳐지거나 갈 곳이 없을 때 까지
		}
		// 아래 칸과 같으면 합쳐서 아래로
		else if(arr[i][j] == arr[i+1][j] && !visit[i+1][j] ) {
			arr[i+1][j] = (arr[i][j] * 2);
			arr[i][j] = 0;
			visit[i+1][j] = true;
		}
    }
}
