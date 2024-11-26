/*
Write a query to display customer names in reverse order along with 
their email domain


Refer the hint for table structure.

Sample output
-------------
ReversedName    EmailDomain                                                                                             
nosnhoJ ecilA   example.com                                                                                             
htimS boB       example.com                                                                                             
sivaD eilrahC   example.com

*/

use fs;
-- write your query below

SELECT REVERSE(SUBSTRING(Customers.Email, 1 , Locate('@',Customers.Email) - 1)) AS ReversedName , SUBSTRING(Customers.Email , Locate('@',Customers.Email) + 1) AS EmailDomain ;

