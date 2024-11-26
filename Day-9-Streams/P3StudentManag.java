
/*
You are tasked with building a Student Score Management System that sorts 
students based on their scores. Each student has multiple test scores: 
a coding test score, MCQ test score, and a total score.

The students should be sorted according to the following rules:
	- Primary Sorting: By total score in descending order.
	- Secondary Sorting: If two students have the same total score, 
	  sort them by coding test score in descending order.
	- Tertiary Sorting: If the coding test scores are also the same, 
	  sort them by MCQ test score in descending order.
	
You must use Java Streams to perform the sorting operation.

Sample Input:
-------------
3               //no of students
Alice,80,70     // name, codingScore, mcqScore
Bob,85,60
Charlie,90,60

Sample Output:
--------------
Charlie: 90, 60, 150
Alice: 80, 70, 150
Bob: 85, 60, 145

*/
import java.util.*;
import java.util.stream.Collectors;

class Student {
    private String name;
    private int codingScore;
    private int mcqScore;
    private int totalScore;

    public Student(String name, int codingScore, int mcqScore) {
        this.name = name;
        this.codingScore = codingScore;
        this.mcqScore = mcqScore;
        this.totalScore = this.codingScore + this.mcqScore;
    }

    public String getName() {
        return name;
    }

    public int getCodingScore() {
        return codingScore;
    }

    public int getMcqScore() {
        return mcqScore;
    }

    public int getTotalScore() {
        return totalScore;
    }

    @Override
    public String toString() {
        return name + ": " + codingScore + ", " + mcqScore + ", " + totalScore;
    }

}

public class P3StudentManag {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine(); // consume the remaining newline character

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            String[] details = input.split(",");
            String name = details[0];
            int codingScore = Integer.parseInt(details[1]);
            int mcqScore = Integer.parseInt(details[2]);

            students.add(new Student(name, codingScore, mcqScore));
        }

        List<Student> sortedStudents = students.stream()
                .sorted(
                        Comparator.comparing(Student::getTotalScore).reversed()
                                .thenComparing(
                                        Comparator.comparing(Student::getCodingScore).reversed())
                                .thenComparing(
                                        Comparator.comparing(Student::getMcqScore).reversed()

                                ))
                .collect(Collectors.toList());

        sortedStudents.forEach(System.out::println);

        sc.close();
    }
}
