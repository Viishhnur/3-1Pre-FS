/*
Write a query to find customers whose email domain is 'example.com'


Refer the hint for table structure.

Sample output
-------------
CustomerID      Name    Email                                                                                           
1       Alice Johnson   alice.johnson@example.com                                                                       
2       Bob Smith       bob.smith@example.com                                                                           

*/

use fs;
-- write your query below

SELECT Customers.CustomerID , Customers.Name , Customers.Email FROM Customers
WHERE Customers.Email LIKE "%example.com";


