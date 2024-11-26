/*
Brahmi and his gang have been chased by a group of police officers and are now 
trapped in a building with M×N rooms, arranged in a grid format. Each room is 
connected to its adjacent rooms both horizontally and vertically, forming a 
complex layout. Fortunately, some rooms in the building are designated as 
"safe zones," providing a possible escape for Brahmi and his gang.

The building's rooms are marked with the following values:
    -1 : Danger Zone - an area that Brahmi and his gang cannot enter.
    0 : Safe Zone - an area that provides a possible escape.
    -2 : Occupied by a gang member.
    
Your task is to help Brahmi and his gang reach the nearest safe zones by 
calculating the minimum distance from each gang member's room to a safe zone, 
avoiding danger zones. If a gang member is unable to reach any safe zone, 
mark their room with -2.

Input Format:
-------------
Line-1 -> two integers M and N, size of the grid of rooms.
Next M Lines -> N space separated integers, from this set [-2,-1,0] only.

Output Format:
--------------
Print an integer as result.


Sample Input-1:
---------------
4 4
-2 -1 0 -2
-2 -2 -2 -1
-2 -1 -2 -1
0 -1 -2 -2

Sample Output-1:
----------------
3 -1 0 1
2 2 1 -1
1 -1 2 -1
0 -1 3 4

NOTE: Please refer the hint.

 */
public class Day23P1 {
    
}
