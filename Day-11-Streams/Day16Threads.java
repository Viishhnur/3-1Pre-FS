import java.util.*;
import java.util.concurrent.*;
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

public class Day16Threads {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Reading number of employees
        int n = sc.nextInt();
        sc.nextLine(); 

        List<Employee> employees = new ArrayList<>();

        // Reading employee details from input
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            String[] details = input.split(" ");

            String name = details[0];
            int age = Integer.parseInt(details[1]);
            String dept = details[2];
            double sal = Double.parseDouble(details[3]);

            employees.add(new Employee(name, age, dept, sal));
        }
        sc.close();

        // Creating ExecutorService with 4 threads
        ExecutorService executor = Executors.newFixedThreadPool(4);

        // Task-1: Filter employees with salary > 50,000 and map filtered employees to their names
        Callable<List<String>> mappingTask = () -> employees.parallelStream()
            .filter(emp -> emp.getSalary() > 50000)
            .map(Employee::getName)
            .collect(Collectors.toCollection(ArrayList::new));

        // Task-2: Compute total salary expenditure for employees with salary > 50,000
        Callable<Double> totalExpTask = () -> employees.parallelStream()
            .filter(emp -> emp.getSalary() > 50000)
            .map(Employee::getSalary)
            .reduce(0.0, Double::sum);

        // Task-3: Partition employees by age
        Callable<Map<Boolean, List<Employee>>> partitionedEmployeesTask = () -> employees.parallelStream()
            .collect(Collectors.partitioningBy(e -> e.getAge() > 30));

        // Create a list of callable tasks
        List<Callable<?>> callList = new ArrayList<>();
        callList.add(mappingTask);
        callList.add(totalExpTask);
        callList.add(partitionedEmployeesTask);

        // Create a Future array to store the results of the tasks
        List<Future<?>> futures = new ArrayList<>();

        // Submit tasks for execution
        callList.forEach(task -> futures.add(executor.submit(task)));

        try {
            // Retrieve the results after the tasks are completed
            List<String> empWithSalMoreThan50k = (List<String>) futures.get(0).get();
            System.out.println("Names of Employees with Salary > 50,000:\n" + empWithSalMoreThan50k);

            double totalExp = (double) futures.get(1).get();
            System.out.println("Total Salary Expenditure for Employees with Salary > 50,000:\n" + totalExp);

            Map<Boolean, List<Employee>> partitionResult = (Map<Boolean, List<Employee>>) futures.get(2).get();
            System.out.println("Employees above 30 years of age:\n" + partitionResult.get(true));
            System.out.println("Employees 30 years or younger:\n" + partitionResult.get(false));

        } catch (InterruptedException | ExecutionException e) {
            // Handle exceptions
            System.err.println("Error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            executor.shutdown();  // Shutdown the executor service
        }
    }
}
