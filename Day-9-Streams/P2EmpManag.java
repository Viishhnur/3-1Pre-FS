/*

You are required to build an Employee Management System that processes a list 
of Employee objects to group them by their department and calculate the average 
salary for each department. Each Employee object has the following attributes:
    - Name: (String) The name of the employee
    - Department: (String) The department in which the employee works
    - Salary: (double) The salary of the employee
    
Your task is to group employees by their department and find the average salary 
for each department using Java Streams.

Sample Input:
-------------
4                   //no of employees
Alice,IT,60000      //name, department,salary
Bob,HR,50000
Charlie,IT,70000
David,HR,55000

Sample Output:
-------------
HR : 52500.00
IT : 65000.00

*/

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

class Employee {
    String name;
    String dept;
    double salary;

    public Employee(String name, String dept, double salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", dept=" + dept + ", salary=" + salary + "]";
    }

}

public class P2EmpManag {
    private static Map<String, Double> customSortEmp(List<Employee> employees) {
        Map<String, Double> res = employees.stream()
                .collect(Collectors.groupingBy(
                        employee -> employee.dept, // classifier function group by dept this is key
                        Collectors.averagingDouble(employee -> employee.salary) // this is agg func
                ));
        return res;
        
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine(); // consume the remaining newline character

        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            String[] details = input.split(",");
            String name = details[0];
            String dept = details[1];
            double sal = Double.parseDouble(details[2]);

            employees.add(new Employee(name, dept, sal));
        }

        // Now we should group by dept Name and find avg sal for each dept

        Map<String, Double> res = customSortEmp(employees);
        // Now traverse throguh the map and print the avg sal of each dept
        res.forEach((dept, avgSal) -> System.out.printf("%s : %.2f%n", dept, avgSal));  
        // System.out.println("Map is " + res);

        sc.close();
    }
}
