/*
A dangerous virus, "Ebola," is spreading across several African countries. 
People are positioned in a grid of size p * q, where some positions in the grid 
are empty.

The grid is represented with three values: 0, 1, and 2, where:
    - 0 indicates an empty position,
    - 1 indicates a healthy person, and
    - 2 indicates an infected person.
    - Each minute, any healthy person who is 4-directionally adjacent (up, down, 
      left, or right) to an infected person becomes infected.

Your task is to determine the minimum amount of time, in minutes, for the virus 
to spread to all people in the grid. 
If it is impossible to infect everyone, return -1.

Input Format:
-------------
Line 1: Two integers, P and Q, representing the dimensions of the grid.
Next P lines: Each line contains Q space-separated integers, either 0, 1, or 2, 
              representing the grid.

Output Format:
--------------
An integer, the minimum amount of time in minutes


Sample Input-1:
---------------
3 3
2 1 1
1 1 0
0 1 1

Sample Output-1:
----------------
4

Explanation-1: (Refer the hint)
--------------
There is an infected person at position (0, 0).
In the first minute: people at positions (0, 1) and (1, 0) are infected.
In the second minute: people at positions (0, 2) and (1, 1) are infected.
In the third minute: the person at position (1, 2) is infected.
In the fourth minute: the person at position (2, 2) is infected.


Sample Input-2:
---------------
3 3
2 1 1
0 1 1
1 0 1

Sample Output-2:
----------------
-1

Explanation-2:
--------------
The healthy person at the bottom left corner (row 2, column 0) cannot be 
infected because infection only spreads in the four primary directions.

Sample Input-3:
---------------
1 2
0 2

Sample Output-3:
----------------
0

Explanation-3: 
-------------
Since there are no healthy people at minute 0, the answer is simply 0.

 */
public class Day25P3 {
    public static void main(String[] args) {
        
    }
}
