import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.io.FileInputStream;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
         
        Scanner sc = new Scanner(System.in);
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int n = sc.nextInt(); // 덤프 횟수
            ArrayList<Integer> list = new ArrayList<>();
            for(int i=0; i<100; i++) {
                list.add(sc.nextInt());
            }
             
            for(int i=0; i<n; i++) {
                int min = Collections.min(list);
                int max = Collections.max(list);
                list.set(list.indexOf(min), min+1);
                list.set(list.indexOf(max), max-1);
            }
            System.out.println("#" + test_case + " " + (Collections.max(list) - Collections.min(list)));
        }
    }
}
