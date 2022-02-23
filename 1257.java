// [SWEA] 1257. K번째 문자열 (Java)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {
	static StringTokenizer st;
	static ArrayList<String> list; // 접미사 배열
	static int[] lcs; // (최장 공통 부분 수열)  index [1] => 0과 1사이의 LCS
	static StringBuffer sb;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		
		for(int c = 1; c <= test; c++) {
			int k = Integer.parseInt(br.readLine());
			String str = br.readLine();
			list = new ArrayList<>();
			lcs = new int[str.length()];
			sb = new StringBuffer("#" + c + " ");
			
			// 접미사 배열 만들기
			for(int i = str.length() - 1; i >= 0; i--) {
				list.add(str.substring(i,str.length()));
			}
			
			// 사전순 정렬
			list.sort(Comparator.naturalOrder());
			
			// 두 접미사 사이의 LCS 구하기
			createLCS();
			
			// LCS 활용하여 중복 값 제거 후 K번째 문자열 찾기
			for(int i = 0; i < list.size(); i++) {
				int len = list.get(i).length() - lcs[i];
				if(k > len) {
					k -= len;
				}
				else{
					sb.append(list.get(i).substring(0, k + lcs[i]));
					break;
				}
			}
			
			System.out.println(sb.toString());
		}
	}
	
	
	public static void createLCS() {
		lcs[0] = 0;
		for(int i = 0; i < list.size() - 1; i++) {
			int count = 0;

			while(true) {
				String strOne = list.get(i);
				String strTwo = list.get(i + 1);
				
				if(strOne.length() <= count || strTwo.length() <= count) {
					break;
				}
				
				if(strOne.charAt(count) == strTwo.charAt(count)) {
					count++;
				}
				else {
					break;
				}
			}
			lcs[i + 1] = count;
		}
	}
	
	
}
