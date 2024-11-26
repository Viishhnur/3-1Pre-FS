// 3rd Oct

/*
You are participating in a token distribution game with three decks of tokens, 
each containing x, y, and z tokens, respectively. Your goal is to maximize your 
number of passes by distributing tokens according to the following rules:

In each move, you must pick two different non-empty decks, take 1 token from each, 
and distribute them to a shared pot. For each move, you earn 1 pass.
The game ends when there are fewer than two non-empty decks 
(i.e., no more moves can be made).

Your objective is to find the maximum number of passes you can achieve by optimally
distributing tokens. Given three integers x, y, and z representing the sizes of 
the three decks, return the maximum possible passes you can earn.

Input Format:
-------------
Three space separated integers, X,Y, Z.

Output Format:
--------------
Print an integer, maximum possible passes you can earn.


Sample Input-1:
---------------
3 5 7

Sample Output-1:
----------------
7

Explanation:
------------
The game begins with (3, 5, 7). One optimal set of moves is:
Take from the 1st and 3rd decks, state becomes (2, 5, 6)
Take from the 1st and 3rd decks, state becomes (1, 5, 5)
Take from the 1st and 3rd decks, state becomes (0, 5, 4)
Take from the 2nd and 3rd decks, state becomes (0, 4, 3)
Take from the 2nd and 3rd decks, state becomes (0, 3, 2)
Take from the 2nd and 3rd decks, state becomes (0, 2, 1)
Take from the 2nd and 3rd decks, state becomes (0, 1, 0)

At this point, there are fewer than two non-empty decks, and 
the game ends with a total of 7 passes.


Sample Input-2:
---------------
4 4 5

Sample Output-2:
----------------
6

Explanation:
------------
One optimal set of moves:
Take from the 1st and 2nd decks, state becomes (3, 3, 5)
Take from the 1st and 3rd decks, state becomes (2, 3, 4)
Take from the 1st and 3rd decks, state becomes (1, 3, 3)
Take from the 1st and 3rd decks, state becomes (0, 3, 2)
Take from the 2nd and 3rd decks, state becomes (0, 2, 1)
Take from the 2nd and 3rd decks, state becomes (0, 1, 0)

The game ends with a total of 6 passes.
*/
import java.util.*;

public class tokenDistribution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[3];
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        while(arr[1]>0 && arr[2]>0){
            sum+=1;
            arr[1]--;
            arr[2]--;
            Arrays.sort(arr);
        }
        System.out.println(sum);
        sc.close();
    }
}