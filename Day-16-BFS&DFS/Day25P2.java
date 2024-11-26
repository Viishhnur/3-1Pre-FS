/*
ABC Township has acquired a plot of land that contains both lakes and usable land. 
The layout of the land is represented by a 2D grid, gridLand[][], of size M * N, 
where each cell is marked as either land (0) or water (1).

Before HMDA can approve the layout, engineers need to design the number of floors 
for each building according to the guidelines below:
    - Buildings can only be constructed on land cells (0).
    - The number of floors in each building must be non-negative.
    - Construction is not allowed on lake cells (1), so the floor count for 
      those cells must be 0.
    - The absolute difference in the number of floors between any two adjacent 
      buildings should not exceed 1. Two buildings are considered adjacent 
      if they share a side (north, east, south, or west).

Your task is to assign floor counts for each building cell to maximize the 
tallest building (i.e., the building with the most floors). Print the maximum 
number of floors in any building within the grid.

Input Format:
-------------
Line 1: Two space-separated integers, M and N, representing the dimensions of the land.
Next M lines: N space-separated integers, each either 0 or 1, 
              representing land and lake cells.

Output Format:
--------------
Print a single integer representing the maximum number of floors in any building.


Sample Input-1:
---------------
3 3
1 0 0
1 1 0
1 1 1

Sample Output-1:
----------------
2

Explanation:
------------
One of the possibility of layout of the buildings is:
0 1 2
0 0 1
0 0 0
So, the maximum number of floors of a building is 2.


Sample Input-2:
---------------
3 4
1 0 0 0
1 0 0 0
1 1 0 0

Sample Output-2:
----------------
3

Explanation:
------------
One of the possibility of layout of the buildings is:
0 1 2 3
0 1 2 3
0 0 1 2
So, the maximum number of floors of a building is 3.

 */
import java.util.*;

public class Day25P2 {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    private static int bfs(int[][] grid, int x, int y, boolean[][] visited, int m, int n, int[][] heights) {
        int maxHeight = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        heights[x][y] = 1; // The height of the current land cell starts from 1

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cx = curr[0], cy = curr[1];

            // Try all 4 directions (north, south, east, west)
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i], ny = cy + dy[i];

                // Check if the next cell is within bounds and is land (0) and not visited
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 0 && !visited[nx][ny]) {
                    heights[nx][ny] = heights[cx][cy] + 1;  // Increment the height based on the current cell
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                    maxHeight = Math.max(maxHeight, heights[nx][ny]);
                }
            }
        }
        return maxHeight;
    }

    private static int maxBuildingHeight(int[][] grid, int m, int n) {
        boolean[][] visited = new boolean[m][n];
        int[][] heights = new int[m][n];

        int maxHeight = 0;

        // Start BFS from each land cell (0) that hasn't been visited
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    maxHeight = Math.max(maxHeight, bfs(grid, i, j, visited, m, n, heights));
                }
            }
        }
        return maxHeight;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input the dimensions of the grid
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[][] grid = new int[M][N];

        // Input the grid
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        // Calculate the result and print the maximum building height
        int result = maxBuildingHeight(grid, M, N);
        System.out.println(result);

        sc.close();
    }
}
