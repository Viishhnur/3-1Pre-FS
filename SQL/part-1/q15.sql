/*
Write a query to find orders that were placed on weekends

Refer the hint for table structure.

Sample output
-------------
OrderID  CustomerID   OrderDate                                                                                       
1002     2            2024-10-12                                                                                              
1005     4            2024-10-13                                                                                              
                                                                                              
*/

use fs;
-- write your query below
SELECT Orders.OrderID , Orders.CustomerID , Orders.OrderDate FROM Orders
WHERE DAYOFWEEK(Orders.OrderDate) = 1 OR DAYOFWEEK(Orders.OrderDate) = 7;
-- DAYOFWEEK() returns a number between 1 to 7 , 1-> Sunday , 2-> Monday ...... 7 -> Saturday

