//[SWEA] 4008. 숫자 만들기 (Java)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{
	static StringTokenizer st;
	static int n; // 숫자의 개수
	static int[] card; // 연산자 카드 개수 ( + , - , * , / )
	static int[] num; // 수식에 들어가는 숫자 
	static int max;
	static int min;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= test; t++) {
			
			n = Integer.parseInt(br.readLine());
			card = new int[4];
			num = new int[n];
			max = -100000000;
			min =  100000000;
			
			// 카드 개수 입력
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 4; i++) {
				card[i] = Integer.parseInt(st.nextToken());
			}
			
			// 숫자 입력
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			
			solve(0,num[0]);
			
			System.out.println("#" + t + " " + (max - min));
		}
	}
	
	// 모든 경우의 수 탐색
	public static void solve(int x, int sum) {
		if(x == n - 1) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		
		// 더하기 카드 사용
		if(card[0] > 0) {
			card[0]--;
			solve(x + 1, sum + num[x + 1]);
			card[0]++;
		}
		
		// 빼기 카드 사용
		if(card[1] > 0) {
			card[1]--;
			solve(x + 1, sum - num[x + 1]);
			card[1]++;
		}
		
		// 곱하기 카드 사용
		if(card[2] > 0) {
			card[2]--;
			solve(x + 1, sum * num[x + 1]);
			card[2]++;
		}
		
		// 나누기 카드 사용
		if(card[3] > 0) {
			card[3]--;
			solve(x + 1, sum / num[x + 1]);
			card[3]++;
		}
	}
}
