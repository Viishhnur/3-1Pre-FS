// 25th September

/*
In a treasure hunt adventure, you are tasked with finding a hidden treasure 
buried somewhere along a path of numbered stones. The stones are numbered 
sequentially from 1 to n, and you need to guess where the treasure is buried. 
Each guess you make represents a numbered stone on the path.

Your guide will help you by giving you hints after each guess:
	- If your guess is higher than the treasure's location, 
	  the guide will tell you to "look lower."
	- If your guess is lower than the treasure's location, 
	  the guide will tell you to "look higher."
	- If your guess is correct, the guide will confirm that 
	  you've found the treasure!

You are provided with a pre-defined hint API called int giveHint(int guess), 
which will return one of the following results:

	-1: The treasure is located at a lower-numbered stone than the guessed stone 
	    (i.e., guess > treasure).
	 1: The treasure is located at a higher-numbered stone than the guessed stone 
	    (i.e., guess < treasure).
 	 0: You've found the treasure (i.e., guess == treasure).

Your task is to determine at which numbered stone the treasure is buried.

NOTE:
-----
You need to implement the method "int yourGuess(int n)" in class Solution.

Input Format:
-------------
Two space separated integers, N and P

Output Format:
--------------
Print the value of P.


Sample Input-1:
---------------
21 18

Sample Output-1:
----------------
18


Sample Input-2:
---------------
21 3

Sample Output-2:
----------------
3
*/
public class Guess{
    // refer below code for solution
}


/* 
class guess extends TreasureHunt {
    public int yourGuess(int n) {
        int left = 1;
        int right = n;
        int mid = 0;
        while(right>=left){
            mid = left+(right-left)/2;
            int res = giveHint(mid);
            if(res == 0){
                return mid;
            }
            else if(res == 1){
                left = mid+1;
            }
            else if(res == -1){
                right = mid-1;
            }
        }
        return mid;
    }
}

*/