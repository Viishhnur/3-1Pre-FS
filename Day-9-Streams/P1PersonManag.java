// 14th Oct

/*
You are tasked with building a Person Management System that processes a list 
of Person objects using Java Streams. Each Person object contains the following 
attributes:
	Name: (String) The name of the person
	Age: (int) The age of the person
	Location: (String) The location where the person lives

Your goal is to sort by age, filter who atre above 20, and group by location 
using Java Stream operation.


Sample Input:
-------------
4                   //number of persons
Alice,23,New York   //name, age, location of a person
Bob,34,Los Angeles
Charlie,18,New York
David,29,Los Angeles

Sample Output:
-------------
New York => 
Person{name='Alice', age=23, location='New York'}
Los Angeles => 
Person{name='David', age=29, location='Los Angeles'}
Person{name='Bob', age=34, location='Los Angeles'}

*/
/*
You are tasked with building a Person Management System that processes a list 
of Person objects using Java Streams. Each Person object contains the following 
attributes:
	Name: (String) The name of the person
	Age: (int) The age of the person
	Location: (String) The location where the person lives

Your goal is to sort by age, filter who atre above 20, and group by location 
using Java Stream operation.


Sample Input:
-------------
4                   //number of persons
Alice,23,New York   //name, age, location of a person
Bob,34,Los Angeles
Charlie,18,New York
David,29,Los Angeles

Sample Output:
-------------
New York => 
Person{name='Alice', age=23, location='New York'}
Los Angeles => 
Person{name='David', age=29, location='Los Angeles'}
Person{name='Bob', age=34, location='Los Angeles'}

*/
import java.util.*;
import java.util.stream.Collectors;
class Person{
    private String name;
    private int age;
    private String location;
    
    public Person(String name,int age,String location){
        this.name = name;
        this.age = age;
        this.location = location;
    }
    
    public String getName(){return name;}
    
    public int getAge(){return age;}
    
    public String getLocation() {return location;}
    
    
    @Override
    public String toString(){
        return "Person{name='" + name + ", " + "age=" + age + ", " + "location='" + location + "'}";
    }
}
public class P1PersonManag{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<Person> persons = new ArrayList<>();
        
        for(int i = 0 ; i < n ; i++){
            String details = sc.nextLine();
            String[] input = details.split(",");
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            String loc = input[2];
            
            persons.add(new Person(name,age,loc));
        }
        
        Map<String,List<Person>> groupByLocation = persons.stream()
                .filter(person -> person.getAge() > 20)
                .sorted(Comparator.comparingInt(Person :: getAge))
                .collect(Collectors.groupingBy(Person :: getLocation));
                
        groupByLocation.forEach((location,personList) -> {
            System.out.println(location + " => ");
            personList.forEach(System.out::println);
        });

        sc.close();
    }
}

