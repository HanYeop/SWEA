// [SWEA] 1288. 새로운 불면증 치료법 (Java)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{
	static StringTokenizer st;
	static int n;
	static boolean[] check;
	static int count;
	static String result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(br.readLine());
			
		for(int t = 1; t <= test; t++) {
			n = Integer.parseInt(br.readLine());
			check = new boolean[10];
			count = 1;
			
			while(true) {
				int cur = n * count;
				String str = String.valueOf(cur);
				
				for(int i = 0; i < str.length(); i++) {
					int index = str.charAt(i) - '0';
					check[index] = true;
				}
				count++;
				
				if(end()) {
					result = str;
					break;
				}
			}
			
			System.out.println("#" + t + " " + result);
		}
	}
	
	public static boolean end() {
		for(int i = 0; i < 10; i++) {
			if(!check[i]) {
				return false;
			}
		}
		return true;
	}
}
