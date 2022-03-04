// [SWEA] 5644. 무선 충전 (Java)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Bc{
	int x;
	int y;
	int c;
	int p;
	
	public Bc(int x, int y, int c, int p) {
		this.x = x;
		this.y = y;
		this.c = c;
		this.p = p;
	}
}

class Pair{
	int x;
	int y;
	
	public Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Solution{
	static StringTokenizer st;
	static int m; // 총 이동시간
	static int a; // BC의 개수
	static int[] userA; // A 이동정보
	static int[] userB; // B 이동정보
	static Pair curA; // A 위치
	static Pair curB; // B 위치
	static Bc[] bcList; // BC 정보
	static int result; // 최종 합계
	
	// X,상,우,하,좌
	static int[] dx = {0,-1,0,1,0};
	static int[] dy = {0,0,1,0,-1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= test; t++) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			userA = new int[m + 1];
			userB = new int[m + 1];
			curA = new Pair(0,0);
			curB = new Pair(9,9);
			bcList = new Bc[a];
			result = 0;
			
			// userA 이동 정보
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i < m + 1; i++) {
				userA[i] = Integer.parseInt(st.nextToken());
			}
			
			// userB 이동 정보
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i < m + 1; i++) {
				userB[i] = Integer.parseInt(st.nextToken());
			}
				
			// BC 정보
			for(int i = 0; i < a; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken()) - 1;
				int x = Integer.parseInt(st.nextToken()) - 1;
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				bcList[i] = new Bc(x,y,c,p);
			}
			
			// 이동
			for(int i = 0; i < m + 1; i++) {		
				curA.x = curA.x + dx[userA[i]];
				curA.y = curA.y + dy[userA[i]];
				curB.x = curB.x + dx[userB[i]];
				curB.y = curB.y + dy[userB[i]];
				result += charge(curA.x, curA.y, curB.x, curB.y);
			}
			
			System.out.println("#" + t + " " + result);
		}
	}
	
	public static int charge(int ax, int ay, int bx, int by) {
		int[][] amount = new int[2][a];
		
		// A가 충전할 수 있는 충전소
		for(int i = 0; i < a; i++) {
			amount[0][i] = check(ax,ay,i);
		}

		// B가 충전할 수 있는 충전소
		for(int i = 0; i < a; i++) {
			amount[1][i] = check(bx,by,i);
		}
		
		// 최대값 구하기
		int max = 0;
		for(int i = 0; i < a; i++) {
			for(int j = 0; j < a; j++) {
				int sum = amount[0][i] + amount[1][j];
				
				if(i == j && amount[0][i] == amount[1][j]) {
					sum /= 2;
				}
				if(sum > max) {
					max = sum;
				}
			}
		}
		return max;
	}
	
	static int check(int x, int y, int n) {

		int a = Math.abs(x - bcList[n].x);
		int b = Math.abs(y - bcList[n].y);
		int dist = a + b;
        
        // BC에 포함되는지 ( 맨해튼 거리 )
		if(dist <= bcList[n].c)
			return bcList[n].p;
		else
			return 0;
	}
}
