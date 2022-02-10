// [SWEA] 1244. 최대 상금 (Java)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution{
	static int[] numArr; // 숫자판
	static int n; // 교환 횟수
	static String str; // 출력할 결과
	static int[] check; // 중복 확인 (0 ~ 9)
	static ArrayList<Integer> arr; // 중복된 수 index
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		for(int c = 1; c <= t; c++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			str = "";
			arr = new ArrayList<>();
			check = new int[10];
			for(int i = 0; i < 10; i++) {
				check[i] = -1;
			}
			
			String numTmp = st.nextToken();
			n = Integer.parseInt(st.nextToken());
			
			// 배열에 숫자판 저장
			numArr = new int[numTmp.length()];
			for(int i = 0; i < numArr.length; i++) {
				numArr[i] = numTmp.charAt(i) - '0';
				
				// 이미 나온 숫자라면
				if(check[numArr[i]] != -1) {
					// 최초 중복 시
					if(check[numArr[i]] < 100) {
						arr.add(check[numArr[i]]);
						check[numArr[i]] = 100;
					}
					arr.add(i);
					
				}
				// 숫자 나온 위치 체크
				else {
					check[numArr[i]] = i;
				}
			}
			
			for(int i = 0; i < numArr.length - 1; i++) {
				// 교환 횟수만큼 진행하면 종료
				if(n == 0) {
					break;
				}
				int maxIndex = i;
				int max = numArr[i];
				// 가장 뒤부터 탐색하여 가장 큰 수 찾기
				for(int j = numArr.length - 1; j > i; j--) {
					if(max < numArr[j]) {
						maxIndex = j;
						max = numArr[j];
					}
				}
				
				// 가장 큰 수가 i가 아니라면 i와 큰 수 swap
				if(maxIndex != i) {
					swap(i,maxIndex);
					n--;
				}
			}
			
			// 중복 숫자가 있을 때 순서 맞춰주기
			if(arr.size() > 0) {
				ArrayList<Integer> tmp = new ArrayList<>();
				for(int i = 0; i < arr.size(); i++) {
					tmp.add(numArr[arr.get(i)]);
				}
				Collections.sort(tmp, Collections.reverseOrder());
				for(int i = 0; i < arr.size(); i++) {
					numArr[arr.get(i)] = tmp.get(i);
				}
			}
			
			// 남은 교환횟수가 홀수이고 중복 숫자가 없을 때
			if(n % 2 == 1 && arr.size() == 0) {
				swap(numArr.length - 1, numArr.length - 2);
			}
			
			// 결과 출력
			for(int num : numArr) {
				str += String.valueOf(num);
			}	
			
			System.out.println("#" + c + " " + str);
		}
	}
	
	public static void swap(int x, int y) {
		int tmp = numArr[y];
		numArr[y] = numArr[x];
		numArr[x] = tmp;
	}
}
