/*
write a Query to List Products with No Orders.

Refer the hint for table structure.

Sample output
-------------
ProductID       Name                                                                                                    
103            Headphones  
*/

use fs;
-- write your query below

SELECT Products.ProductID , Products.Name 
FROM Products  LEFT JOIN OrderItems 
ON Products.ProductID = OrderItems.ProductID
WHERE OrderItems.ProductID IS NULL;
