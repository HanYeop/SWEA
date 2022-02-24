package algorithm;
//[SWEA] 1260. 화학물질2 (Java)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Pair{
	int row;
	int col;
	
	public Pair(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	public int area(){
		return row * col;
	}
}
public class Solution{
	static StringTokenizer st;
	static int n; // 양의 정수
	static int[][] arr; // 행렬
	static boolean[][] visit; // 행렬 방문 여부
	static ArrayList<Pair> results; // 결과 저장
	static boolean[] rVisit; // 결과 방문 여부
	static int[][] dp;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= test; t++) {
			
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			visit = new boolean[n][n];
			results = new ArrayList<>();
			
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
						findArr(i,j);
					}
				}
			}
			
			// 행렬 순서 찾기
			rVisit = new boolean[results.size()];
			for(int i = 0; i < results.size(); i++) {
				Pair cur = results.get(i);
				ArrayList<Pair> tmp = new ArrayList<>();
				tmp.add(cur);
				rVisit[i] = true;
				order(cur, 1, tmp);			
				rVisit[i] = false;
			}
			
			// dp 초기화
			dp = new int[results.size()][results.size()];
			for(int i = 0; i < results.size(); i++) {				
				for(int j = 0; j < results.size(); j++) {
					dp[i][j] = -1;
				}
			}
				
			System.out.println("#" + t + " " + solve(0, results.size() - 1));	
		}
	}
	
	// 결과 행렬 찾기
	public static void findArr(int startX, int startY) {
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
		
		results.add(new Pair(row,col));
	}
	
	// 행렬 순서 찾기
	public static void order(Pair pair, int count, ArrayList<Pair> list) {
		if(results.size() == count) {
			results = list;
			return;
		}
		
		for(int i = 0; i < results.size(); i++) {
			Pair cur = results.get(i);
			if(!rVisit[i] && pair.col == cur.row) {
				ArrayList<Pair> tmp = new ArrayList<>();
				
				// 리스트 복사
				for(Pair p : list) {
					tmp.add(p);
				}
				
				tmp.add(cur);
				rVisit[i] = true;
				order(cur, count + 1, tmp);		
				rVisit[i] = false;
			}
		}
	}
	
	public static int solve(int l, int r) {

		if(l == r) {
			return 0;
		}
		
		if (dp[l][r] != -1) {
			return dp[l][r];
		}
		else {
			int min = 0x7FFFFFFF;

			for (int i = l; i < r; i++) {
				int lResult = solve(l, i);
				int rResult = solve(i + 1, r);
				int num = (results.get(l).row * results.get(i).col * results.get(r).col);
				min = Math.min(min, (lResult + rResult + num) );
			}

			return dp[l][r] = min;
		}
	}
}
