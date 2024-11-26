// 13th Nov
/*
Shakuni playing 'Paramapadasopanam' game with Dharamaraja.
Shakuni wants to win everytime. He has a boon that whenever he used to 
roll the dice, the dice roll to show his desired number. 

Rules
--------
The game is played with a cubic dice of 6 faces numbered 1 to 6.
And Paramapadasopanam of size N*N.
- Starting from square X = 1, reach the square N*N with some rolls of the dice 
- Once Shakuni roll the dice, he will land on one of the followin squares only
  X+1, X+2, X+3, X+4, X+5, X+6.
- If current value at position X is not equal to -1, then there is a ladder 
  or snake.
- If the position of X is at the base of a ladder, the player must climb 
  the ladder. Ladders go up only.
- If the position of X is at the mouth of a snake, the player must go down 
  the snake and come out through the tail. Snakes go down only.

You have to findout, what would be the least number of rolls required 
for shakuni to win.

Note:
Shakuni can only take a snake or ladder at most once per move: 
if the tail of a snake or ladder is the start of another snake or ladder, 
you do not continue moving.


Input Format:
-------------
Line-1: An integer n , size of Paramapadasopanam.
Next N lines: N space separated integers, either -1 or 
              an integer between 1 to n*n. 

Output Format:
--------------
Print an integer, least number of rolls required for shakuni to win.


Sample Input-1:
---------------
6
-1 -1 -1 -1 -1 -1
-1 -1 -1 -1 -1 -1
-1 -1 -1 -1 -1 -1
-1 35 -1 -1 13 -1
-1 -1 -1 -1 -1 -1
-1 15 -1 -1 -1 -1

Sample Output-1:
----------------
4

Explanation: 
------------
At the beginning, you start at square 1.
Roll the dice to land at square 2, and must take the ladder to square 15.
Roll the dice to land at square 17, and must take the snake to square 13.
Roll the dice to land at square 14, and must take the ladder to square 35.
Roll the dice to land at square 36, Shakuni Won.
Total number of rolls are 4.


 */
import java.util.*;

class Day27P1 {
  private static int[] getCoords(int num, int n) {
    int row_from_top = (num - 1) / n;
    int row_from_bottom = (n - 1) - row_from_top;

    int col = (num - 1) % n;

    // If right to left , right to left is when RB is even
    if ((n % 2 == 1 && row_from_bottom % 2 == 1) || (n % 2 == 0 && row_from_bottom % 2 == 0)) {
      col = (n - 1) - col;
    }

    return new int[] { row_from_bottom, col };
  }

  private static int bfs(int start, int[][] board, boolean[][] visited, int n) {
    Queue<Integer> qu = new LinkedList<>();
    qu.offer(start);
    visited[n - 1][0] = true; // mark 1 as visited

    int steps = 0;
    while (!qu.isEmpty()) {
      int size = qu.size();

      for (int cnt = 0; cnt < size; cnt++) {
        int x = qu.poll();

        if (x == n * n)
          return steps; // reached final step

        // now we can traverse till 6 steps
        for (int k = 1; k <= 6; k++) {
          int val = x + k;

          if (val > n * n)
            break;

          int[] coordinates = getCoords(val, n);

          int r = coordinates[0];
          int c = coordinates[1];
          // if already visited continue
          if (visited[r][c] == true)
            continue;

          visited[r][c] = true;

          if (board[r][c] == -1) {
            qu.offer(val);
          } else {
            qu.offer(board[r][c]);
          }

        }
      }
      steps++;
    }

    return -1;

  }

  private static int snakesAndLadders(int[][] board, int n) {

    boolean[][] visited = new boolean[n][n];

    return bfs(1, board, visited, n);

  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.nextLine();

    int[][] board = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        board[i][j] = sc.nextInt();
      }
    }
    System.out.print(snakesAndLadders(board, n));
    sc.close();
  }

}
