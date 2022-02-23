// [SWEA] 1221. GNS (Java)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{
	static StringTokenizer st;
	static int[] arr;
	static String num[] = 
		{"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
	static StringBuffer sb;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= test; t++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			
			int n = Integer.parseInt(st.nextToken());
			arr = new int[10];
			sb = new StringBuffer();
			sb.append("#" + t + "\n");
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				counting(st.nextToken());
			}
			
			// 0부터 카운팅한 갯수만큼 출력
			int cur = 0;
			for(int i = 0; i < n; i++) {
				if(arr[cur] == 0) {
					cur++;
				}
				
				sb.append(num[cur] + " ");
				arr[cur]--;
			}
			
			System.out.println(sb.toString());
		}
	}
	
	// 나온 숫자 갯수 카운팅
	public static void counting(String str) {
		if(str.equals("ZRO")) {
			arr[0]++;
		}
		else if(str.equals("ONE")){
			arr[1]++;
		}
		else if(str.equals("TWO")){
			arr[2]++;
		}
		else if(str.equals("THR")){
			arr[3]++;
		}
		else if(str.equals("FOR")){
			arr[4]++;
		}
		else if(str.equals("FIV")){
			arr[5]++;
		}
		else if(str.equals("SIX")){
			arr[6]++;
		}
		else if(str.equals("SVN")){
			arr[7]++;
		}
		else if(str.equals("EGT")){
			arr[8]++;
		}
		else if(str.equals("NIN")){
			arr[9]++;
		}
	}
}
