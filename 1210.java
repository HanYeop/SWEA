import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] arr = new int[100][100];
		int x = 0;
		
		
		for(int test =0; test<10; test++) {
			int t = Integer.parseInt(br.readLine());
			
			for(int i=0; i<100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					// 도착점 위치
					if(arr[i][j] == 2) {
						x = j;
					}
				}
			}
			
			int i = 98;
			boolean left = true; // 왼쪽으로 갈 수 있는지
			boolean right = true; // 오른쪽으로 갈 수 있는지
			while(true) {
				// 목적지 도달
				if(i == 0) {
					break;
				}
				
				if (x>0) {
					// 왼쪽이 연결되어있으면
					if (arr[i][x-1] == 1 && left) {
						x--;
						right = false;
						continue;
					}
				}
				
				if(x<99) {
					// 오른쪽이 연결되어있으면
					if (arr[i][x+1] == 1 && right) {
						x++;
						left = false;
						continue;
					}
				}
				
				// 둘다 연결되어 있지 않다면
				i--;
				right = true;
				left = true;
			}
			System.out.println("#"+t+" "+x);
		}
		
		br.close();
	}
}
