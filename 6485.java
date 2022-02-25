// [SWEA] 6485. 삼성시의 버스 노선 (Java)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{
	static StringTokenizer st;
	static int n;
	static int p;
	static int[] station;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(br.readLine());
			
		for(int t = 1; t <= test; t++) {
			n = Integer.parseInt(br.readLine());
			station = new int[5001];
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int ai = Integer.parseInt(st.nextToken());
				int bi = Integer.parseInt(st.nextToken());
				
				for(int j = ai; j <= bi; j++) {
					station[j]++;
				}
			}
			
			StringBuffer sb = new StringBuffer("#" + t + " ");
			p = Integer.parseInt(br.readLine());
			for(int i = 0; i < p; i++) {
				int index = Integer.parseInt(br.readLine());
				sb.append(station[index] + " ");
			}
			
			System.out.println(sb.toString());
		}
	}
}
