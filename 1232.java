// [SWEA] 1232. 사칙연산 (Java)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 트리 노드
class Node{
	int index;
	String data;
	Node leftNode;
	Node rightNode;
	
	public Node(int index) {
		this.index = index;
		this.data = " ";
		leftNode = null;
		rightNode = null;
	}
}

// 트리 클래스
class Tree{
	Node root = null;
	
	public void add(int index, String data, int leftIndex, int rightIndex) {
		// 트리 최초 생성 시
		if(root == null) {
			root = new Node(index);
			root.data = data;
			if(leftIndex != 0) root.leftNode = new Node(leftIndex);
			if(rightIndex != 0) root.rightNode = new Node(rightIndex);
		}
		else {
			search(root,index,data,leftIndex,rightIndex);
		}
	}
	
	// 이미 존재하는 노드에 연결
	public void search(Node root, int index, String data, int leftIndex, int rightIndex) {	
		// 찾았을 때 좌우 연결
		if(root.index == index) {
			root.data = data;
			if(leftIndex != 0) root.leftNode = new Node(leftIndex);
			if(rightIndex != 0) root.rightNode = new Node(rightIndex);
		}
		
		// 못 찾으면 좌우 탐색
		else {
			if(root.leftNode != null) search(root.leftNode,index,data,leftIndex,rightIndex);
			if(root.rightNode != null) search(root.rightNode,index,data,leftIndex,rightIndex);
		}
	}
	
	// 중위 순회 (왼쪽 자식, 루트, 오른쪽 자식)
	public double inOrder(Node root) {
		String curData = root.data;
		double left = 0;
		double right = 0;
		double result = 0;
		
		// left 결정 (마지막 레벨에 있는 숫자부터 연산)
		if(root.leftNode.leftNode == null) {
			left = Double.parseDouble(root.leftNode.data);
		}
		else {
			left = inOrder(root.leftNode);
		}
		
		// right 결정 (마지막 레벨에 있는 숫자부터 연산)
		if(root.rightNode.rightNode == null) {
			right = Double.parseDouble(root.rightNode.data);
		}
		else {
			right = inOrder(root.rightNode);
		}

		// 연산
		if(curData.equals("+")) {
			result = left + right;
		}
		else if(curData.equals("-")) {
			result = left - right;
		}
		else if(curData.equals("*")) {
			result = left * right;
		}
		else if(curData.equals("/")) {
			result = left / right;
		}
		return result;
	}
}

public class Solution {
	static int n; // 정점의 총 수
	static Tree tree; // 트리
	
 public static void main(String[] args) throws IOException{
 	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 	tree = new Tree();
 	
 	for(int t = 1; t <= 10; t++) {
 		n = Integer.parseInt(br.readLine());
 		
 		for(int i = 1; i <= n; i++) {
 			StringTokenizer st = new StringTokenizer(br.readLine());
 			st.nextToken();
 			String data = st.nextToken();
 			int leftIndex = 0;
 			int rightIndex = 0;
 			
 			if (st.countTokens() == 2) {
 				
 				leftIndex = Integer.parseInt(st.nextToken());
 				rightIndex = Integer.parseInt(st.nextToken());
 			}
 			
 			tree.add(i, data, leftIndex, rightIndex);
 		}
 		
 		System.out.println("#" + t + " " + (int)tree.inOrder(tree.root));
 	}
 }
}
