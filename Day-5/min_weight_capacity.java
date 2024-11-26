// 
/*
A warehouse stores boxes of different weights that need to be transported to 
different distribution centers across multiple cities. The boxes are stored in 
the order in which they were manufactured, and they must be transported in 
this specific order. Each day, a truck is sent to pick up a load of boxes from 
the warehouse. However, the truck has a limited carrying capacity based on its 
maximum weight limit.

You are tasked with determining the minimum weight capacity of the truck that 
will allow all the boxes to be shipped in the given number of days without 
violating the order in which the boxes are loaded. Each day, the truck can load
as many boxes as possible without exceeding its weight capacity.

Input Format:
-------------
line-1: two space separated integers, N boxes, and number of days.
line-2: N space separated integers, weights of boxes.

Sample Input-1: 
---------------
5 2
7 2 5 10 8

Sample Output-1:
----------------
18

Explanation:
-------------
A truck capacity of 18 is the minimum to transport all the boxes 
in 2 days as follows:

1st day: 7, 2, 5 (total weight: 14)
2nd day: 10, 8 (total weight: 18)
With a capacity less than 18, it is impossible to ship all the boxes in 
the given number of days without exceeding the truck's weight capacity.


Sample Input-2: 
---------------
8 4
1 5 6 7 3 2 9 4

Sample Output-2:
----------------
12

Explanation:
------------
A truck capacity of 12 is the minimum to transport all the boxes in 4 days as follows:

1st day: 1, 5, 6 (total weight: 12)
2nd day: 7, 3, 2 (total weight: 12)
3rd day: 9 (total weight: 9)
4th day: 4 (total weight: 4)
*/
import java.util.*;
public class min_weight_capacity{
    public static int binarySearch(int[] arr, int right, int days){
        int left = 1;
        while(left<=right){
            int mid = (left+right)/2;
            if(findDays(arr,mid)<=days){
                right = mid-1;
            }
            else{
                left = mid + 1;
            }
        }
        return left;
    }
    public static int findDays(int[] arr, int i){
        int temp = 0;
        int days = 0;
        for(int j = 0;j<arr.length;j++){
            if((i-temp) >= arr[j]){
                temp += arr[j];
            }
            else{
                days++;
                temp = 0;
                j--;
            }
        }
        if(temp != 0){
            days++;
        }
        return days;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int days = sc.nextInt();
        int[] arr = new int[n];
        int daysTotal = 0;
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
            daysTotal += arr[i];
        }
        System.out.println(binarySearch(arr,daysTotal,days));
        sc.close();
    }
}