// [SWEA] 1959. 두 개의 숫자열 (Java)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{
	static StringTokenizer st;
	static int n;
	static int m;
	static int[] aArr;
	static int[] bArr;
	static int dir;
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(br.readLine());
			
		for(int t = 1; t <= test; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			aArr = new int[n];
			bArr = new int[m];
			max = -1;
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				aArr[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < m; i++) {
				bArr[i] = Integer.parseInt(st.nextToken());
			}
			
			// 더 작은 쪽에서 시작지점 옮기기
			if(n <= m) {
				dir = m - n;
				for(int i = 0; i <= dir; i++) {
					int sum = 0;
					for(int j = 0; j < n; j++) {
						sum += aArr[j] * bArr[j + i];
					}
					max = Math.max(max, sum);
				}
			}
			else {
				dir = n - m;
				for(int i = 0; i <= dir; i++) {
					int sum = 0;
					for(int j = 0; j < m; j++) {
						sum += aArr[j + i] * bArr[j];
					}
					max = Math.max(max, sum);
				}
			}
			
			System.out.println("#" + t + " " + max);
		}
	}
}
