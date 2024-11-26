/*
Write a query to calculate age of each order in weeks

Refer the hint for table structure.

Sample output
-------------
OrderID  CustomerID  OrderDate       WeeksSinceOrder                                                                 
1001     1           2024-10-10      3                                                                                       
1002     2           2024-10-12      3                                                                                       
1003     1           2024-10-15      3                                                                                       

   

*/

use fs;
-- write your query below

SELECT OrderID , CustomerID , OrderDate , CEIL(DATEDIFF('2024-10-30',OrderDate) / 7) AS WeeksSinceOrder  FROM Orders;
-- generally use CURDATE()

