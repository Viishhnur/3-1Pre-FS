/*
For a Movie Premiere in US, advance booking is opened,
At Quad Cinema theater, each ticket costs $25.
And issue only one ticket per head. 

People are standing in a queue to buy from Quad Cinema counter, 
and order one at a time. And they are paying with either a $25, $50, or $100 notes.

You will be given, an array of notes[], the people are carrying with them.
Your task is to issue ticket and settle the balance to each person, 
If a person given a $50 note, Issue the ticket worth $25 and settle the balance $25.

Print true, if and only if you can provide tickets and settle the balance 
for all the people in the queue. Otherwise, false.

Note: Initially you don't have any amount in hand.

Input Format:
-------------
Line-1: An integer N, number of persons
Line-2: N space separated integers, notes with the persons.

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
5
25 25 25 50 100

Sample Output-1:
----------------
true

Explanation:
-----------
- The first three people pay with $25, so no change is needed.
- The fourth person pays with $50, and you return $25 as change.
- The fifth person pays with $100, and you return $75 as change ($50 + $25).
- Since every person gets their ticket and correct change, the answer is true.

Sample Input-2:
---------------
5
25 25 50 50 100

Sample Output-2:
----------------
false

Explanation:
-----------
- The first two people pay with $25, so no change is needed.
- The third and fourth people pay with $50, and you return $25 as change.
- The fifth person pays with $100, but you cannot return $75 as change 
(you only have $50 bills).
Since not everyone can receive their correct change, the answer is false.

 */
import java.util.Scanner;
public class P3TicketChange {
    private static boolean canProvideTickets2(int[] notes){
        int twentyFive = 0, fifty = 0;
        for(int i=0;i<notes.length;i++){
            // this is called as rule switch case
            switch (notes[i]) {
                case 25 -> twentyFive++;
                case 50 -> {
                    if(twentyFive == 0) return false;
                    twentyFive--;
                    fifty++;
                }
                default -> {
                    if(fifty > 0 && twentyFive > 0){
                        fifty--;
                        twentyFive--;
                    }
                    else if(twentyFive >= 3){
                        twentyFive -= 3;
                    }
                    else return false;
                }
            }
        }
        return true;
    }
    private static boolean canProvideTickets1(int[] notes){
        int twentyFive = 0, fifty = 0;
        for(int i = 0 ;i < notes.length ; i++){
            switch (notes[i]) {
                case 25:
                    twentyFive++;
                    break;
                case 50:
                    if(twentyFive == 0) return false;
                    fifty++;
                    twentyFive--;
                    break;
                default:
                    // we got a 100rs note
                    if(twentyFive > 0 && fifty > 0){
                        // we can give 25 + 50 as change
                        twentyFive--;
                        fifty--;
                    }
                    else if(twentyFive >= 3){
                        // we can give 25 + 25 + 25 as change
                        twentyFive-=3;
                    }
                    else return false; // we can't provide change
                    break;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] notes = new int[n];
        for (int i = 0; i < n; i++) {
            notes[i] = sc.nextInt();
        }
        System.out.println(canProvideTickets2(notes));
        sc.close();
    }
}
