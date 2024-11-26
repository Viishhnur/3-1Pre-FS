/*
In a township of size N×N, each 1x1 area is either a villa or a swimming pool. 
The layout of the township is represented as a 2D matrix of size N×N, 
filled with 0's and 1's, where:
    - 0 represents a swimming pool,
    - 1 represents a villa.

Your task is to identify a swimming pool such that its distance to the nearest 
villa(s) is maximized, and return this distance.

If the township contains only villas or only swimming pools, return -1.

Note: The distance used in this problem is the Manhattan distance: the distance 
between two cells (a0, b0) and (a1, b1) is defined as |a0 - a1| + |b0 - b1|

Input Format:
-------------
- The first line contains an integer N, the size of the 2D matrix
- The next N lines each contain N space-separated integers, either 0 or 1, 
  representing the township matrix.

Output Format:
--------------
Print an integer, representing the maximum distance from any swimming pool to 
the nearest villa.


Sample Input-1:
---------------
4
1 0 1 1
0 0 0 0
1 0 1 0
1 0 0 1

Sample Output-1:
----------------
2

Explanation: 
------------
The swimming pool at (1, 1) is with distance 2 from the nearest villas.


Sample Input-2:
---------------
4
1 0 0 0
0 0 0 0
1 0 0 0
0 1 0 1

Sample Output-2:
----------------
3

Explanation: 
------------
The swimming pool at (0,3) or (1, 2) are with distance 3 from the nearest villas.

 */
import java.util.*;

public class Day24P1 {
    private static final int[] dirX = { -1, 1, 0, 0 };
    private static final int[] dirY = { 0, 0, -1, 1 };

    private static void bfs(Queue<int[]> qu, int[][] distance, int N) {
        // Perform BFS
        while (!qu.isEmpty()) {
            int[] curr = qu.poll();
            int x = curr[0], y = curr[1];

            // Explore all four directions
            for (int i = 0; i < 4; i++) {
                int nx = x + dirX[i], ny = y + dirY[i];

                // Check if the new position is within bounds and not visited yet
                if (nx >= 0 && ny >= 0 && nx < N && ny < N && distance[nx][ny] == -1) {
                    distance[nx][ny] = distance[x][y] + 1;
                    qu.offer(new int[] { nx, ny });
                }
            }
        }
    }

    private static int maxDistance(int N, int[][] mat) {

        Queue<int[]> qu = new LinkedList<>();

        int[][] distance = new int[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(distance[i], -1);
        }

        // collect all villas and set their inital distance to 0
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (mat[i][j] == 1) {
                    qu.offer(new int[] { i, j });
                    distance[i][j] = 0;
                }
            }
        }

        boolean allVillas = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (mat[i][j] == 0) {
                    allVillas = false;
                    break;
                }
            }
        }
        if (qu.isEmpty() || allVillas)
            return -1;

        bfs(qu, distance, N); // do bfs

        int maxDist = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (mat[i][j] == 0) { // It's a swimming pool
                    maxDist = Math.max(maxDist, distance[i][j]);
                }
            }
        }

        return maxDist;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input
        int N = sc.nextInt();
        int[][] matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // Output
        System.out.println(maxDistance(N, matrix));
    }
}
