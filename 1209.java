import java.util.Scanner;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int[][] arr = new int[100][100];
            int max = 0;
            int sum1 = 0;
            int sum2 = 0;
            int sum3 = 0;
            int sum4 = 0;
            int t = sc.nextInt();
             
            // 배열 입력
            for(int i =0; i<100; i++){
                for(int j=0; j<100; j++){
                    arr[i][j] = sc.nextInt();
                }
            }
             
            for(int i =0; i<100; i++){
                sum1 = 0;
                sum2 = 0;
                sum3 += arr[i][i];
                sum4 += arr[i][99-i];
               
                for(int j=0; j<100; j++){
                    sum1 += arr[i][j];
                    sum2 += arr[j][i];
                }
                max = Math.max(max,sum1);
                max = Math.max(max,sum2);
            }
            max = Math.max(max,sum3);
            max = Math.max(max,sum4);
        
            System.out.println("#" + t + " " + max);
        }
    }
}
