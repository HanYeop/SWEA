//[SWEA] 1952. 수영장 (Java)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{
	static StringTokenizer st;
	static int[] cost;
	static int[] month;
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= test; t++) {
			
			cost = new int[4];
			month = new int[12];
			
			// 이용권 요금 입력
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 4; i++) {
				cost[i] = Integer.parseInt(st.nextToken());
			}
			
			min = cost[3];
			
			// 이용권 계획 입력
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 12; i++) {
				month[i] = Integer.parseInt(st.nextToken());
			}
			
			find(0,0);
			
			System.out.println("#" + t + " " + min);
		}
	}
	
	public static void find(int x, int sum) {
		if(x >= 12) {
			min = Math.min(min, sum);
			return;
		}
		
		// 당일 이용권 선택 (한 달동안)
		if(month[x] * cost[0] < cost[1] ) {
			find((x + 1), sum + (month[x] * cost[0]));
		}
		
		// 한달 이용권 선택
		else {
			find((x + 1), sum + cost[1]);
		}
		
		// 세달 이용권 선택
		find((x + 3), sum + cost[2]);

	}
}
