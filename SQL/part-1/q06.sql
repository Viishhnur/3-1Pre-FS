/*
write a Query to Get Products Ordered More Than 3 Times

Refer the hint for table structure.

Sample output
-------------
Name        TimesOrdered                                                                                                    
Keyboard        4                                                                                                       
Mouse           6                                                                                                               

*/

use fs;
-- write your query below

SELECT Products.Name , COUNT(OrderItems.ProductID) AS TimesOrdered
FROM OrderItems JOIN Products
ON OrderItems.ProductID = Products.ProductID
Group BY Products.Name
HAVING TimesOrdered > 3;
