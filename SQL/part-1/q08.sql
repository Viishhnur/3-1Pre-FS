/*
write a Query Using a Correlated Subquery to Get the Latest Order for Each Customer

Refer the hint for table structure.

Sample output
-------------
OrderID   CustomerID      OrderDate       TotalCost                                                                       
1006        5            2024-10-12        550.00                                                                                  
1007        6            2024-10-14        250.00                                                                                  
1008        7            2024-10-15        1200.00                                                                                 


*/

use fs;
-- write your query below

SELECT Orders.OrderID , Orders.CustomerID , Orders.OrderDATE , Orders.TotalCost FROM Orders 
WHERE OrderDATE = (
    SELECT MAX(o.OrderDate) FROM Orders o
    WHERE o.CustomerID = Orders.CustomerID
    
);

