/*
Write a Query to Extract the month and year from the order date


Refer the hint for table structure.

Sample output
-------------
OrderID  CustomerID      OrderMonth     OrderYear                                                                       
1001     1               10             2024                                                                                            
1002     2               10             2024                                                                                            
1003     1               10             2024                                                                                            
1004     3               10             2024                                                                                            


*/

use fs;
-- write your query below


SELECT Orders.OrderID , Orders.CustomerID , DATE_FORMAT(Orders.OrderDate,'%m') AS OrderMonth , DATE_FORMAT(Orders.OrderDate,'%Y') AS OrderYear FROM Orders;
