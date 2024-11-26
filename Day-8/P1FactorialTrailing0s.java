// 10th Oct

/*
The problem presented to the participants is to find how many zeros appear at 
the end of the factorial of a given number, N. Factorials grow very fast, and 
calculating them directly can be overwhelming, especially for large values of N.

Therefore, students must use efficient strategies to determine the number of 
trailing zeros in the factorial.

For example, the factorial of 5 is 5!=1×2×3×4×5=120, and there 
the end of 120. However, for N=4, the factorial 4!=24 has 0 zeros at the end.

The Olympiad judges are looking for quick and accurate solutions, and the 
participants are tasked with solving multiple such problems under strict time limits.

Constraint : 
============
1<= N <= 10000


Input Format:
-------------
An integer N

Output Format:
--------------
Print an integer, number of 0's at the end.


Sample Input-1:
---------------
5

Sample Output-1:
----------------
1


Sample Input-2:
---------------
4

Sample Output-2:
----------------
0


 */
import java.util.Scanner;

public class P1FactorialTrailing0s {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(trailingZeros(n));
        sc.close();

    }

    private static int trailingZeros(int n) {
        int count = 0;
        for (int i = 5; n / i >= 1; i *= 5) {
            count += n / i;
        }
        return count;
    }
}