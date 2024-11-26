/*
Mr Sudhakar is playing a game on checkerboard of size INF*INF (INF -infinity), 
where the indices starts from (-INF,-INF) and ends at (INF,INF). In one step, 
he can move the box from position (p,q) to one of the following positions in L 
shape like as follows: 
	- (p-2, q-1), (p-2, q+1), (p+2, q-1), (p+2, q+1)
	- (p-1, q+2), (p+1, q+2), (p-1, q-2), (p+1, q-2)

Initially the box is at (0,0) position, and need to move the box to position (m,n).
You will be given two integers m and n indicates the position(m,n).

Now your task is to help by Mr Sudhakar to find the minimum number of steps 
required to move the box from (0,0) to (m,n).


Input Format:
-----------------
Two space separated integers, m and n, position.

Output Format:
------------------
Print an integer, minimum number of steps to reach (m,n).


Sample Input-1:
---------------
2 4

Sample Output-1:
----------------
2

Explanation:
-------------
Initially, you are at (0,0) position, you can reach (2,4) as follows:
(0,0) -> (1, 2) -> (2, 4) 


Sample Input-2:
---------------
4 7

Sample Output-2:
----------------
5

Explanation:
------------
Initially, you are at (0,0) position, you can reach (4,7) as follows:
(0,0) -> (1, 2) -> (2, 4) -> (1, 6) -> (3, 5) -> (4, 7)

 */
import java.util.*;

class Cell{
    int first;
    int second;
    int distance;
    public Cell(int first,int second,int distance){
        this.first = first;
        this.second = second;
        this.distance = distance;
    }
}
public class Day28P1{
    private static int[][] dirs = {{-2,-1} , {-1,2} , {-2,1} , {1,2} , {2,-1} , {-1,-2} , {2,1} , {1,-2}};
    
    // private static int getMinMovesDFS(int x,int y,int m,int n,HashSet<String> visited,int steps,int[] minSteps){
        
    //     if(x == m && y == n) {
    //         minSteps[0] = Math.min(steps,minSteps[0]);
    //         return steps;
    //     }
    //     visited.add(x + "," + y); // it means (x,y) is visited
        
    //     // now traverse through all other directions 
    //     for(int[] dir : dirs){
    //         int nx = x + dir[0];
    //         int ny = y + dir[1];
            
    //         if(!visited.contains(nx + "," + ny)){

    //             minSteps[0] = Math.min(minSteps[0],getMinMovesDFS(nx,ny,m,n,visited,steps+1,minSteps));
                
    //         }
    //     }
        
    //     // backtrack
    //     visited.remove(x+","+y);
        
    //     return minSteps[0];
    // }
    private static int getMinMovesBFS(int x,int y,int m,int n){
        HashSet<String> visited = new HashSet<>();
        visited.add(x + "," + y); // (x,y)
        
        Queue<Cell> qu = new LinkedList<>();
        qu.offer(new Cell(x,y,0)); // this is from where we have to start 
        
        while(!qu.isEmpty()){
            Cell c = qu.poll();
            int curr_x = c.first;
            int curr_y = c.second;
            int curr_dist = c.distance;
            
            // if we are at target position it is well and good 
            if(curr_x == m && curr_y == n) return curr_dist;
            
            // now traverse through all possibilities 
            for(int[] dir : dirs){
                int nx = curr_x + dir[0];
                int ny = curr_y + dir[1];
                if(!visited.contains(nx + "," + ny)){
                    visited.add(nx + "," + ny);
                    qu.offer(new Cell(nx,ny,curr_dist + 1));
                }
            }
        }
        
        return -1; // if target is unreachable if we are moving like horse
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt() , n = sc.nextInt();
        sc.close();
        
        // (m,n) is the required target for us to reach
        System.out.print(getMinMovesBFS(0,0,m,n));
        
        // HashSet<String> visited = new HashSet<>();
        // int[] minSteps = {Integer.MAX_VALUE};
        // int res = getMinMovesDFS(0,0,m,n,visited,0,minSteps);
        // System.out.print(res == Integer.MAX_VALUE ? -1 : res);

    }
}
        
        