/*
As a Dance Instructor, you are choreographing a complex routine for a high-profile 
performance. The routine consists of a series of N steps, each of which must be executed 
perfectly for the overall routine to succeed. During the review process, you 
discovered that one particular step was performed incorrectly, and unfortunately, 
this misstep was replicated in all subsequent practices, leading to a significant 
flaw in the routine.

Your task is to efficiently determine the first instance in the sequence of 
practice sessions where the misstep occurred effectively, given the tight schedule 
of the performers.

Your Development Setup Includes:

    - A total of n recorded practice sessions of the routine, numbered from 1 to n.
    - An automated function called isMisstep(session) that takes a session 
      number as input and returns a boolean indicating whether the misstep is 
      present in that session (true means the misstep is present, false means 
      the session is clear).

NOTE:
-----
You need to implement the method "int findFirstMisstepSession(int n)" in class 
Solution.

Input Format:
-------------
Two space separated integers, N and MisStep.

Output Format:
--------------
Print an integer result, MisStep.


Sample Input-1:
---------------
7 3

Sample Output-1:
----------------
3


Sample Input-2:
---------------
15 3

Sample Output-2:
----------------
3


 */
public class Day25P1 {
    // refer to below code for solution
}

/*
class Solution extends MisStepFinder {
    public int findFirstMisstepSession(int n) {
        //implement your logic here.
        // use binary search concept 
        int low = 1;
        int high = n;
        
        while(low < high){
            int mid = low + (high - low)/2;
            
            if(isMisstep(mid)){
                // go left and search 
                high = mid;
            }
            else{
                low = mid + 1;
            }
        }
        
        return low;
    }
}

 */
