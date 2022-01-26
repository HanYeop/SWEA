import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
 
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int n = sc.nextInt(); // 테스트 케이스 길이
            int[] arr = new int[n]; // 빌딩 정보
            int sum = 0; // 세대 수 합계
             
            // 정보 입력
            for(int i =0; i<n; i++){
                arr[i] = sc.nextInt();
            }
             
            for(int i=2; i<n-2; i++){
                int max = 0;
                max = Math.max(arr[i-2],arr[i-1]);
                max = Math.max(max,arr[i+1]);
                max = Math.max(max,arr[i+2]);
                // 조망권 확보
                if(max < arr[i]){
                    sum += (arr[i] - max);   
                }
            }
             
            System.out.println("#"+test_case+" "+sum);
        }
    }
}
