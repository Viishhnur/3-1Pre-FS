// 22nd Oct

/*
You have a list of employee objects representing the company's staff, 
with each object containing the following attributes:
    - name (String)
    - age (int)
    - department (String)
    - salary (double)

Write a Java program that reads the number of employees and their details 
from user input, where each employee’s data is entered on a single line 
in the format: name age department salary.

Your task is to perform the following operations Using the Streams API:
    - Filter the list to include only employees with a salary greater than 50,000.
    - Map the remaining employees to a new list of their names only.
    - Reduce the salaries of the remaining employees to calculate the 
      total salary expenditure for these employees.
    - Partition the list of employees into two groups: 
        - one with employees above 30 years of age.
        - another with employees 30 years or younger.

Implement each operation using the appropriate Java Streams methods.

Expected Outcome:
----------------
    - A filtered list of employee names whose salary is greater than 50,000.
    - The total salary expenditure of employees earning above 50,000.
    - Two partitioned groups of employees: 
        one with age > 30, and the other with age <= 30.
        
Sample Input:
-------------
6
Alice 25 IT 60000
Bob 35 Finance 45000
Charlie 28 IT 52000
David 40 HR 70000
Eve 30 Finance 49000
Frank 32 IT 80000

Sample Output:
--------------
Names of Employees with Salary > 50,000:
[Alice, Charlie, David, Frank]
Total Salary Expenditure for Employees with Salary > 50,000:
262000.0
Employees above 30 years of age:
[Employee{name='Bob', age=35, department='Finance', salary=45000.0}, Employee{name='David', age=40, department='HR', salary=70000.0}, Employee{name='Frank', age=32, department='IT', salary=80000.0}]
Employees 30 years or younger:
[Employee{name='Alice', age=25, department='IT', salary=60000.0}, Employee{name='Charlie', age=28, department='IT', salary=52000.0}, Employee{name='Eve', age=30, department='Finance', salary=49000.0}]

 */
import java.util.*;
import java.util.stream.Collectors;

class Employee {
    String name;
    int age;
    String department;
    double salary;

    public Employee(String name, int age, String department, double salary) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age + ", department='" + department + "', salary=" + salary + "}";
    }
}

    
public class PartitionEmployee{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine(); 

        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            String[] details = input.split(" ");

            String name = details[0];
            int age = Integer.parseInt(details[1]);
            String dept = details[2];
            double sal = Double.parseDouble(details[3]);

            employees.add(new Employee(name, age,dept, sal));
        }
        sc.close();

        // - A filtered list of employee names whose salary is greater than 50,000.

        List<Employee> employeesWithSalaryGreaterThan50k = employees.stream()
            .filter(e -> e.getSalary() > 50000)
            .collect(Collectors.toList());
            
        // print the filtered emp names
        System.out.println("Names of Employees with Salary > 50,000:\n" + employeesWithSalaryGreaterThan50k.stream()
            .map(Employee::getName)
            .collect(Collectors.toList()));
        
        // calc their total exp
        double totalExpenditure = employeesWithSalaryGreaterThan50k.stream()
            .map(Employee::getSalary)
            .reduce(0.0, Double::sum);
        System.out.println("Total Salary Expenditure for Employees with Salary > 50,000:\n" + totalExpenditure);
        
        
        // Now filter based on age 
        Map<Boolean, List<Employee>> partitionedEmployees = employees.stream()
            .collect(Collectors.partitioningBy(e -> e.getAge() > 30));

        System.out.println("Employees above 30 years of age:\n" + partitionedEmployees.get(true)); // since cond was > 30 get the list where ever the key is true
        System.out.println("Employees 30 years or younger:\n" + partitionedEmployees.get(false)); 
        
    }
}