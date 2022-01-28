// [SWEA] 1217. 거듭 제곱 (Java)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int test =0; test<10; test++) {
			int t = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int result = pow(n, m);
			
			System.out.println("#" + t + " " + result);
		}
		
		br.close();
	}
	
	public static int pow(int n, int m) {
		if(m == 0) {
			return 1;
		}
		
		return n * pow(n, m-1);
	}
}
