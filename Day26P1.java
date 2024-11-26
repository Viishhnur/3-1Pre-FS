
/*
Mahalakshmi is participating in a treasure hunt that includes N boxes, each 
numbered sequentially from 0 to N-1. Initially, all the boxes are locked with 
unique passcodes, except for Box-0, which is unlocked.

Each box in the treasure hunt contains a list of envelopes, with each envelope 
holding the passcode to unlock a different box. The envelope is labeled with 
the box number it can unlock.

Mahalakshmi can open the boxes in any order, but she must start with Box-0.

The goal of the treasure hunt is to unlock all the boxes. Your task is to 
determine if Mahalakshmi can open every box and win the game.

If she can unlock all the boxes, print "Win". Otherwise, print "Lost".

Input Format:
-------------
Line-1: An integer, number of boxes.
Next N lines: space separated integers, box numbers.

Output Format:
--------------
Print a string value, Win or Lost


Sample Input-1:
---------------
5
1
2
3
4
3

Sample Output-1:
----------------
Win

Sample Input-2:
---------------
4
1 3
3 0 1
2
0

Sample Output-2:
----------------
Lost

*/
import java.util.*;
import java.util.stream.Collectors;

public class Day26P1 {
    private static boolean can_unlock_all_boxes_bfs(List<List<Integer>> boxes, int n) {
        // use a traversal technique
        // use bfs
        boolean[] visited = new boolean[n];
        Queue<Integer> qu = new LinkedList<>();
        qu.offer(0);
        visited[0] = true;
        while (!qu.isEmpty()) {
            int curr = qu.poll();
            // get adjacent elements of curr
            for (int nbr : boxes.get(curr)) {
                if (!visited[nbr]) {
                    visited[nbr] = true;
                    qu.offer(nbr);
                }
            }

        }

        // check if all are visited
        for (int i = 0; i < n; i++) {
            if (!visited[i])
                return false;
        }

        return true;
    }

    private static boolean can_unlock_all_boxes_dfs(List<List<Integer>> boxes, int n){
        boolean[] visited = new boolean[n];
        dfs(0, visited, boxes, n);
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }

    private static void dfs(int i, boolean[] visited, List<List<Integer>> boxes, int n) {
        visited[i] = true;

        // go to nbrs
        for (int nbr : boxes.get(i)) {
            if (!visited[nbr]) {
                dfs(nbr, visited, boxes, n);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<List<Integer>> boxes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> row = Arrays.stream(sc.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            boxes.add(row);

        }
        // System.out.println(can_unlock_all_boxes_bfs(boxes,n) ? "Win" : "Lost");
        
        // using dfs
        System.out.println(can_unlock_all_boxes_dfs(boxes,n) ? "Win" : "Lost");

        sc.close();
    }
}