// [SWEA] 4012. 요리사 (Java)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution{
	static StringTokenizer st;
	static int n; // 식재료의 수
	static int min; // 최소값
	static int[][] arr; // 시너지
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= test; t++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			min = Integer.MAX_VALUE;
			
			// 시너지 정보 입력
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			combi(new ArrayList<Integer>(), 0, 0);

			System.out.println("#" + t + " " + min);
		}
	}
	
	public static void combi(ArrayList<Integer> list, int index, int count) {
		
		// 조합 완성
		if(count >= (n/2)) {
			// 남은 시너지 리스트
			ArrayList<Integer> tmpList = new ArrayList<>();
			for(int i = 0; i < n; i++) {
				if(!list.contains(i)) {
					tmpList.add(i);
				}
			}
			
			// 시너지 총 합계
			int sumOne = 0;
			int sumTwo = 0;
					
			for(int i = 0; i < list.size(); i++) {
				for(int j = 0; j < list.size(); j++) {
					if(i != j) {
						sumOne += arr[list.get(i)][list.get(j)];
						sumTwo += arr[tmpList.get(i)][tmpList.get(j)];
					}
				}
			}
			
			// 최소값 갱신
			int result = Math.abs(sumOne - sumTwo);
			min = Math.min(min, result);
			return;
		}
		
		// 조합 생성
		for(int i = index; i < n; i++) {
			list.add(i);
			combi(list, (i + 1), (count + 1));
			list.remove(list.size() - 1);
		}
	}
}
