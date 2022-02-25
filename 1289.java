// [SWEA] 1289. 원재의 메모리 복구하기 (Java)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(br.readLine());
			
		for(int t = 1; t <= test; t++) {
			String str = br.readLine();
			char cur = str.charAt(0);
			int count = 0;
			if(cur == '1') {
				count = 1;
			}
			
			for(int i = 1; i < str.length(); i++) {
				if(cur != str.charAt(i)) {
					count++;
					cur = str.charAt(i);
				}
			}
			
			System.out.println("#" + t + " " + count);
		}
	}
}
