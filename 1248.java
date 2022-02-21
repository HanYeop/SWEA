// [SWEA] 1248. 공통조상 (Java)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution{
	static StringTokenizer st;
	static int v; // 정점 총 수
	static int e; // 간선의 총 수
	static int one; // 공통 조상 찾는 점
	static int two; // 공통 조상 찾는 점
	static int[][] tree; // 트리
	static int[] rev; // 역순 배열
	static int max; // 최대 공통 조상
	static int count; // 서브 트리 크기
	static ArrayList<Integer> listOne; // 찾는 점의 역순 리스트
	static ArrayList<Integer> listTwo; // 찾는 점의 역순 리스트
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(br.readLine());
		for(int t = 1; t <= test; t++) {
			
			// 초기화
			st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			one = Integer.parseInt(st.nextToken());
			two = Integer.parseInt(st.nextToken());
			tree = new int[v + 1][2];
			max = 0;
			count = 0;
			rev = new int[v + 1];
			listOne = new ArrayList<>();
			listTwo = new ArrayList<>();
			
			// 트리 입력
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < e; i++) {
				int index = Integer.parseInt(st.nextToken());
				int value = Integer.parseInt(st.nextToken());
				
				if(tree[index][0] == 0) {
					tree[index][0] = value;
				}
				else {
					tree[index][1] = value;
				}
				
				// 역순 배열 생성
				rev[value] = index;
			}
			
			create(listOne, one);
			create(listTwo, two);
			find();
			order(max);
			System.out.println("#" + t + " " + max + " " + count);
		}
	}
	
	// 찾는 정점의 역순 리스트 만들기
	public static void create(ArrayList<Integer> list, int x) {
		if(rev[x] == 0) {
			return;
		}
		list.add(rev[x]);
		create(list,rev[x]);
	}
	
	// 가장 큰 공통 조상 구하기
	public static void find() {
		for(int i : listOne) {
			if(listTwo.contains(i)) {
				max = i;
				return;
			}
		}
	}
	
	// 최대 공통 조상에서 순회하여 서브 트리 크기 구하기
	public static void order(int x) {
		count++;
		if(tree[x][0] != 0) {
			order(tree[x][0]);
		}
		if(tree[x][1] != 0) {
			order(tree[x][1]);
		}
	}
}
