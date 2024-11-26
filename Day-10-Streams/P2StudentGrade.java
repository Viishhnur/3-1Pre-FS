
/*
You are given a list of Student objects, where each Student has the following fields:
	name (String): The name of the student
	subject (String): The subject the student is studying
	grade (double): The student’s grade
	school (String): The school the student belongs to

Tasks to Perform:
	Filter: Select students with a grade greater than 75.
	Map: Add 5 points bonus to their grades.
	GroupBy: Group the students by their school.
	Reduce/Aggregate: Calculate the average grade for each school.
	Aggregator: Identify the student with the highest grade in each school.


Sample Input:
-------------
5					// number of students
Alice Math 80 HPS	// each student infomation.
Bob Science 60 DPS 
Charlie Math 75 HPS
David Science 85 DPS 
Eva Math 95 HPS
	
Sample Output:
--------------
HPS: Eva with grade 100.0
DPS: David with grade 90.0

*/
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

class Student {
    private String name;
    private String subject;
    private Double grade;
    private String school;

    public Student(String name, String subject, Double grade, String school) {
        this.name = name;
        this.subject = subject;
        this.grade = grade;
        this.school = school;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public Double getGrade() {
        return grade;
    }

    public String getSchool() {
        return school;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return name + " with grade " + grade;
    }

}

public class P2StudentGrade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine(); // consume the remaining newline character

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            String[] details = input.split(" ");
            String name = details[0];
            String sub = details[1];
            Double grade = Double.parseDouble(details[2]);
            String school = details[3];

            students.add(new Student(name, sub, grade, school));
        }

        // Filter: Select students with a grade greater than 75.
        // Increase grade by 5
        List<Student> modifiedStudents = students.stream()
                .filter(student -> student.getGrade() > 75)
                .peek(student -> student.setGrade(student.getGrade() + 5))
                .collect(Collectors.toList());

        // Now calc avg grade for each school
        // Map<String, Double> schoolAvg = modifiedStudents.stream()
        //         .collect(Collectors.groupingBy(
        //                 Student::getSchool,
        //                 Collectors.averagingDouble(Student::getGrade)));

        Map<String, Optional<Student>> topStudentsInEachSchool = modifiedStudents.stream()
                .collect(Collectors.groupingBy(
                        Student::getSchool,
                        Collectors.maxBy(Comparator.comparing(Student::getGrade))));

        topStudentsInEachSchool.forEach((school, topStudent) -> {
            topStudent.ifPresent(student -> {
                System.out.println(school + ": " + student);
            });
        });

        sc.close();

    }
}
