/*
write a Query to Get Total Sales for Each Product

Refer the hint for table structure.

Sample output
-------------
Name          TotalSales                                                                                                      
Laptop           2400.00                                                                                                         
Keyboard         375.00                                                                                                  
Smartphone       1600.00                                                                                                 
Mouse            320.00                                                                                                          
 
*/

use fs;
-- write your query below

SELECT Products.Name , SUM(OrderItems.Quantity * OrderItems.UnitPrice) AS TotalSales
FROM Products JOIN OrderItems
ON Products.ProductID = OrderItems.ProductID
GROUP BY Products.ProductID;
