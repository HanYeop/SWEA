// [SWEA] 2805. 농작물 수확하기 (Java)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution{
	static int n; // 농장의 크기
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(br.readLine());
			
		for(int t = 1; t <= test; t++) {
			
			n = Integer.parseInt(br.readLine());
			
			int start = n / 2;
			int count = 1;
			int sum = 0;
			
			for(int i = 0; i < n; i++) {
				String str = br.readLine();
				
				for(int j = start; j < start + count; j++) {
					sum += str.charAt(j) - '0';
				}	
				
				if(i < n / 2) {
					count += 2;
					start--;
				}
				else {
					count -= 2;
					start++;
				}
			}
			
			System.out.println("#" + t + " " + sum);
		}
	}
}
