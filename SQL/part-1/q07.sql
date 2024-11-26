/*

write a Query to Get All Cancelled Orders with Product Details
 
Refer the hint for table structure.

Sample output
-------------
OrderID Name       Quantity        UnitPrice                                                                               
1004    Mouse        1               40.00                                                                                           
1007    Smartwatch   1               250.00                                                                                  
                                                                                         

*/

use fs;
-- write your query below

SELECT OrderItems.OrderID , Products.Name , OrderItems.Quantity , OrderItems.UnitPrice
FROM OrderItems 
JOIN Products ON OrderItems.ProductID = Products.ProductID
JOIN Orders ON Orders.OrderID = OrderItems.OrderID
WHERE Orders.Status = "Cancelled";


