/*
write a Query Using Subquery to Get Customers with More Than 2 Orders.


Refer the hint for table structure.

Sample output
-------------
Name            Email                                                                                                           
Alice Johnson   alice.johnson@example.com                                                                               
Bob Smith       bob.smith@example.com 
*/

use fs;
-- write your query below

SELECT Customers.Name , Customers.Email FROM Customers
WHERE (SELECT COUNT(*) FROM Orders WHERE Orders.CustomerID = Customers.CustomerID) > 2;
