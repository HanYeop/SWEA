// [SWEA] 1219. 길찾기 (Java)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static final int size = 100;
	static int[][] arr;
	static int result;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int test = 1; test <= 10; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken()); // 테스트 케이스 번호
			int n = Integer.parseInt(st.nextToken()); // 길의 총 개수
			
			arr = new int[size][2];
			result = 0;
			
			// 순서쌍 입력
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				int index = Integer.parseInt(st.nextToken()); // 순서쌍 인덱스
				int value = Integer.parseInt(st.nextToken()); // 순서쌍 값
				
				// 이미 길이 하나 있다면 두번째 배열에 저장
				if(arr[index][0] != 0) {
					arr[index][1] = value;
				} else {
					arr[index][0] = value;
				}				
			}
			
			// 두 방향 탐색 시작
			solve(arr[0][0]);
			solve(arr[0][1]);
			
			System.out.println("#" + t + " " + result);
		}
		br.close();
	}
	
	public static void solve(int index) {
		
		// 더이상 길이 없다면
		if(index == 0) {
			return;
		}
		
		// 도착점에 도착했다면
		if(index == 99) {
			result = 1;
			return;
		}	
		
		// 두 방향 탐색
		solve(arr[index][0]);
		solve(arr[index][1]);
	}
}
