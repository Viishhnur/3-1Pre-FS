/*
write a Query to List Customers Who Never Placed an Order

Refer the hint for table structure.

Sample output
-------------
CustomerID      Name                                                                                                    
8              Henry Taylor                                                                                                    
9              Irene Green 

*/

use fs;
-- write your query below

SELECT Customers.CustomerID , Customers.Name 
FROM Customers LEFT JOIN Orders
ON Customers.CustomerID = Orders.CustomerID
WHERE Orders.OrderID IS NULL;
