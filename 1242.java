// [SWEA] 1242. 암호코드 스캔 (Java)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n; // 세로 크기
	static int m; // 가로 크기
	static int sum; // 결과 합계
	static int passwordIndex; // 암호코드 숫자 갯수 인덱스
	static int[] password; // 암호코드
	static int[] binaryRow; // 이진수로 변환된 행
	static int[] preBinaryRow; // 이진수로 변환된 이전 행
	static int[][][] ratio = new int[5][5][5]; // 비율
	// 16진수 => 2진수 변환 코드
	static int[][] hexCode = {
            {0, 0, 0, 0}, // 0
            {0, 0, 0, 1}, // 1
            {0, 0, 1, 0}, // 2
            {0, 0, 1, 1}, // 3
            {0, 1, 0, 0}, // 4
            {0, 1, 0, 1}, // 5
            {0, 1, 1, 0}, // 6
            {0, 1, 1, 1}, // 7
            {1, 0, 0, 0}, // 8
            {1, 0, 0, 1}, // 9
            {1, 0, 1, 0}, // A
            {1, 0, 1, 1}, // B
            {1, 1, 0, 0}, // C
            {1, 1, 0, 1}, // D
            {1, 1, 1, 0}, // E
            {1, 1, 1, 1}  // F
	};
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	createRatio();
    	
    	int t = Integer.parseInt(br.readLine());
    	for(int c = 1; c <= t; c++) {
    		
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		n = Integer.parseInt(st.nextToken());
    		m = Integer.parseInt(st.nextToken());
    		
    		sum = 0;
    		passwordIndex = 7;
    		password = new int[8];
    		
    		// 16진수 => 2진수 변환했으므로 4배의 공간이 필요
    		binaryRow = new int[m * 4];
    		preBinaryRow = new int[m * 4];
		
    		String preStr = "";
    		// 한줄 씩 2진수로 변환하여 확인
    		for(int i = 0; i < n; i++) {
    			String tmp = br.readLine();
    			
    			// 중복 제거
    			if(tmp.equals(preStr)) {
    				preStr = tmp;
    				continue;
    			}
    			conversionBinary(tmp);		
				for(int j = m * 4 - 1; j >= 0; j--) {
					// 모든 암호의 끝이 1이므로 끝이 1인지 체크하여 종료점 체크, 중복 제거
    				if(binaryRow[j] == 1 && preBinaryRow[j] == 0) {
    					int x = 0;
    					int y = 0;
    					int z = 0;
    					
    					// 뒤에서부터 연속된 1의 갯수 카운트
    					while(binaryRow[j] == 1) {
    						z++;
    						j--;
    					}
    					// 뒤에서부터 연속된 0의 갯수 카운트
    					while(binaryRow[j] == 0) {
    						y++;
    						j--;
    					}
    					// 뒤에서부터 연속된 1의 갯수 카운트
    					while(binaryRow[j] == 1) {
    						x++;
    						j--;
    					}
    					// 다음 암호코드 숫자 까지 남은 0 이동	
    					if(passwordIndex != 0) {
	    					while(binaryRow[j] == 0) {
	    						j--;
	    					}
    					}
    					j++; // for문에서 -1 또 하므로 위치 조정
    					
    					// 가장 작은 수로 나눠서 비율을 1로 만듦
    					int min = Math.min(Math.min(x, y), z);
                        x /= min; 
                        y /= min; 
                        z /= min; 
                        password[passwordIndex--] = ratio[x][y][z];
 
                        // 코드 탐색이 종료되었으면 암호 맞는지 검사
                        if (passwordIndex == -1) {
                            int correct = 0;
                            int passwordSum = 0;
                            for(int k = 0; k < 8; k++) {
                            	// 짝수번이면 * 3
                				if(k % 2 == 0) {
                					correct = correct + (password[k] * 3);
                				}
                				else {
                					correct += password[k];
                				}
                				passwordSum += password[k];
                            }
                            // 암호가 맞는지 검사, 틀리면 더하지 않음
                        	if(correct % 10 == 0) {
                        		sum += passwordSum;
                        	}
                            passwordIndex = 7;
                        }
    				}
    			}
				// 이전 문자열 저장
				preBinaryRow = binaryRow.clone();
				preStr = tmp;
    			
    		}
    		System.out.println("#" + c + " " + sum);
    	}
    }
    
    public static void createRatio() {
    	// 비율 체크 (뒤에서 부터  탐색하므로 마지막 연속 0은 셀 필요 X)
    	ratio[2][1][1] = 0;
    	ratio[2][2][1] = 1;
    	ratio[1][2][2] = 2;
    	ratio[4][1][1] = 3;
    	ratio[1][3][2] = 4;
    	ratio[2][3][1] = 5;
    	ratio[1][1][4] = 6;
    	ratio[3][1][2] = 7;
    	ratio[2][1][3] = 8;
    	ratio[1][1][2] = 9;	
    }
    
    // 16진수 => 2진수 변환
    public static void conversionBinary(String str) {
    	 for (int i = 0; i < m; i++) {
             int tmp = Character.digit(str.charAt(i), 16);
             for (int k = 0; k < 4; k++) {
            	 binaryRow[i * 4 + k] = hexCode[tmp][k]; 
             }
         }
    }
}
