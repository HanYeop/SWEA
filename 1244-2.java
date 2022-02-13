package algorithm;
//[SWEA] 1244. 최대 상금 (Java)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{
	static int n; // 교환 횟수
	static int len; // 문자열 길이
	static int max;
	static int [][] state; // 중복 연산 체크
	static int t[] = { 1, 10, 100, 1000, 10000, 100000 }; // 자릿수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		for(int c = 1; c <= t; c++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			state = new int [11][720];
			max = 0;
		
			int num = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			len = (int)(Math.log10(num)+1);
				
			findMax(num,n);
			System.out.println("#" + c + " " + max);
		}
	}
	
	public static void findMax(int num, int count) {
		if (count > 0)
			{
				for (int i = 0; i < 720; i++)
				{
					if (state[count][i] == 0)
					{
						state[count][i] = num;
						break;
					}
					else if (state[count][i] == num) return;
				}
			}
		
		// 교환 종료 시
		if (count == 0)
		{
			if (num > max) {
				max = num;
			}
		}
		
		else
		{
			for (int i = 1; i <= len - 1; i++) {
				for (int j = i + 1; j <= len; j++)
				{
					int ii = ((num / t[len - i]) % 10);
					int jj = ((num / t[len - j]) % 10);
					int xx = num - ii * t[len - i] - jj * t[len - j] + ii * t[len - j] + jj * t[len - i];
					findMax(xx, count - 1);
				}
			}
		}
	}
}
