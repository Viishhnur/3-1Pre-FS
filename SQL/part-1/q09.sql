/*
write a Query to Get Monthly Sales Summary

Refer the hint for table structure.

Sample output
-------------
Month      MonthlySales                                                                                                    
2024-10    6475.00

*/

use fs;
-- write your query below

SELECT DATE_FORMAT(Orders.OrderDate,'%Y-%m') AS Month , SUM(TotalCost) AS MonthlySales FROM Orders
GROUP BY Month;
