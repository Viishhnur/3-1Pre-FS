/*
Write a query to find the maximum and minimum salary among people below 40 years
group them based on their location, and sort them in descending 
order of thier location and Limit the results to 5 people.

Sample output
-------------
location   	MAX(salary)	MIN(salary)	
Surat	    61000.00	61000.00	
Pune	    62000.00	60000.00                                                                            


Table:   
======
indianPeople
    - name VARCHAR(100),
    - age INT,
    - gender VARCHAR(10),
    - phone_number VARCHAR(15),
    - location VARCHAR(50),
    - salary DECIMAL(10, 2)

*/

use fs;
-- write your query below
SELECT location , MAX(salary) , MIN(salary) FROM indianPeople
WHERE age < 40
GROUP BY location
ORDER BY location DESC
LIMIT 5;

