/*
Write a query to find orders placed in the last 20 days.


Refer the hint for table structure.

Sample output
-------------
OrderID  CustomerID      OrderDate       TotalCost                                                                       
1001     1               2024-10-10      1250.00                                                                                 
1002     2               2024-10-12      850.00                                                                                  
  

*/

use fs;
-- write your query below
SELECT OrderID, CustomerID, OrderDate, TotalCost
FROM Orders
WHERE OrderDate >= '2024-09-30' - INTERVAL 20 DAY; -- this test case was generated on 30th Oct so use that date only
-- If it was today u can use some other sql functions

