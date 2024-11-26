/*
You are tasked with securing the legendary Kohinoor diamond inside a high-tech 
security box equipped with a unique 4-wheel lock. Each of the 4 wheels on the 
lock has 10 slots numbered from '0' to '9', which can be rotated freely. 
The lock wraps around, meaning you can rotate from '9' to '0' or from '0' to 
'9' in a single move.

The lock initially displays "0000" when closed, representing the starting 
position of the wheels. However, the diamond is secured in such a way that 
specific combinations on the lock, known as "trap codes," will trigger alarms, 
rendering the lock immovable if any of these combinations are displayed.

You are provided a list of these trap codes. If the lock ever displays any of 
the trap codes, the wheels will freeze in that position, making it impossible 
to unlock. Your goal is to find the minimum number of moves required to reach 
a target combination that will unlock the box and retrieve the Kohinoor diamond. 

If it's impossible to reach the target combination without triggering a trap code, 
return -1.

NOTE:
In one rotation you can choose any one wheel and rotate to its next digit or 
previous digit.


Input Format:
-------------
Line-1: space separated strings, each string of length 4 and 
        contains only digits [0-9]
Line-2: A string, key to unlock.

Output Format:
--------------
Print an integer, the minimum number of rotations required to unlock.


Sample Input-1:
---------------
0302 0202 0203 2323 3003
0303 

Sample Output-1:
----------------
8

Explanation:
------------
To unlock the box the valid rotations are as follows:
0000 > 1000 > 1100 > 1200 > 1201 > 1202 > 1302 > 1303 > 0303.


Sample Input-2:
---------------
6656 6676 6766 6566 5666 7666 6665 6667
6666 

Sample Output-2:
----------------
-1

Explanation:
------------
You can't unlock the box.


 */
public class Day23P2 {
    
}
