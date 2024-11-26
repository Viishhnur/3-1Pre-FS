/*
Write a query to calculate the number of days since each order was placed


Refer the hint for table structure.

Sample output
-------------
OrderID   CustomerID   OrderDate       DaysSinceOrder                                                                  
1001      1            2024-10-10      20                                                                                      
1002      2            2024-10-12      18                                                                                      
1003      1            2024-10-15      15                                                                                      
1004      3            2024-10-14      16                                                                                      
1005      4            2024-10-13      17                                                                                      


*/

use fs;
-- write your query below

SELECT Orders.OrderID , Orders.CustomerID , Orders.OrderDate , DATEDIFF('2024-10-30' , Orders.OrderDate) AS DaysSinceOrder FROM Orders;
-- This is according to 2024-10-30 , as formatted for 30th Oct , 2024 
