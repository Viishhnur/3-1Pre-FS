/*
Implement a function calculate_total_balance that accepts a list of N transaction 
amounts and the number of threads as input. The function should divide the 
transactions equally among the specified number of threads, where each thread 
processes its assigned transactions and computes the partial balance. 

The function should then aggregate the partial balances from all threads and 
return the total balance. Ensure proper synchronization to prevent data 
inconsistencies.

Sample Input:
-------------
10          // N transactions
150 -50 200 -100 250 -75 300 -125 400 -200      // amounts[]
3           //threads

Sample Output:
--------------
750


*/

public class TransactionThread{
    
}