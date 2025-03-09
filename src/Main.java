import java.util.*;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(5, 8, 12, 3, 15);
        System.out.println("1. Filter Even Numbers: "+nums.stream().filter(x -> x%2==0).toList());

        List<String> names = Arrays.asList("Alice", "Adam", "Bob", "Alex");
        System.out.println("2. Convert to Uppercase: "+names.stream().map(x -> x.toUpperCase()).toList());

        System.out.println("3. Find Maximum Value: "+nums.stream().max((a,b) -> a-b).get());

        System.out.println("4. Count Strings Starting with 'A': " +names.stream()
                .filter(x-> x.startsWith("A")).count());

        List<String> fruits = Arrays.asList("Banana", "Apple", "Orange");
        System.out.println("5. Sort a List of Strings: "+ fruits.stream().sorted().toList());

        List<List<Integer>> listOfLists = List.of(List.of(1, 2), List.of(3, 4));
        System.out.println("6. Flatten a List of Lists: "+ listOfLists.stream()
                .flatMap(x -> x.stream()).toList());

        List<Integer> dups = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        System.out.println("7. Remove Duplicates: "+dups.stream().distinct().toList());

        System.out.println("8. Find the First Match greater than 10: "+ nums.stream()
                .filter(x->x>10).findFirst().get());

        List<String> words = Arrays.asList("cat", "elephant", "dog", "tiger");
        System.out.println("9. Group by String Length: "+ words.stream()
                .collect(Collectors.groupingBy(String::length))); //x -> x.length()

        List<String> fruitsDups = Arrays.asList("apple", "banana", "apple", "orange", "banana");
        System.out.println("10. Calculate Frequency of Elements: "+ fruitsDups.stream()
                .collect(Collectors.toMap(k->k, v->1, (x,y) -> x +y)));

        System.out.println("11. Given a list of integers, filter out all even numbers and collect the odd numbers " +
                "into a new list.");
        System.out.println(nums.stream().filter(x -> x%2 != 0).collect(Collectors.toList()));
//        System.out.println(nums.stream().collect(Collectors.partitioningBy(x ->x%2 == 0)));

        System.out.println("12. From a list of Employee objects with id, name, and salary fields, " +
                "find the employee with the highest salary");
        Employee emp1 = new Employee(1, "Rutuja", 10000, "Computer");
        Employee emp2 = new Employee(2, "Yash", 45000, "Electronics");
        Employee emp3 = new Employee(3, "Navneet", 43000, "Computer");
        Employee emp4 = new Employee(4, "Geeta", 32000, "Chemical");

        List<Employee> empList = List.of(emp1, emp2, emp3, emp4);
        System.out.println("Max salary: "+empList.stream()
                .max((a,b) -> Double.compare(a.getSalary(), b.getSalary())).get());

        System.out.println("Min Salary: "+empList.stream()
                .min(Comparator.comparing(Employee::getSalary)).get());

        System.out.println("13. Given a list of Person objects with name and age fields, group them by age.");
        List<Person> personList = List.of(new Person("Gautami", 20),
                new Person("Geetika", 22),
                new Person("Yash", 20),
                new Person("Navneet", 22),
                new Person("Rutuja", 25),
                new Person("Random", -1));

        System.out.println(personList.stream().collect(Collectors.groupingBy(Person::getAge)));

        //Can also use map.sum OR map.reduce
        //summingInt -- It combines mapping and reducing into one operation. Slightly more efficient than separate map and reduce.
        System.out.println("14. Sum of Squares: "+ nums.stream().collect(Collectors.summingInt(x-> x*x)));

        System.out.println("15. Given a list of strings, count how many strings have a length greater than 5.");
        System.out.println(words+": "+words.stream().filter(x -> x.length() > 5).count());

        System.out.println("16. Sort a list of Student objects based on their grades, and if two grades are equal, " +
                "sort by their names");
        Student s1 = new Student("Suresh", 'A');
        Student s2 = new Student("Ramesh", 'D');
        Student s3 = new Student("Geeta", 'C');
        Student s4 = new Student("Vanita", 'B');
        Student s5 = new Student("Tanisha", 'B');

        List<Student> studentsList = Arrays.asList(s1, s2, s3, s4, s5);
        System.out.println(studentsList.stream()
                .sorted(Comparator.comparing(Student::getGrade).thenComparing(Student::getName))
                .toList());

        //IN-PLACE SORTING using sort()
//        studentsList.sort(Comparator.comparing(Student::getGrade)
//                .thenComparing(Student::getName));
//        System.out.println(studentsList);

        System.out.println("17. Convert a list of Book objects with id and title fields into a map " +
                "where the key is the id and the value is the title.");
        Book b1 = new Book(12, "Java");
        Book b2 = new Book(11, "Python");
        Book b3 = new Book(32, "C-Programming");
        Book b4 = new Book(53, "English textbook");
        Book b5 = new Book(66, "Physics");

        List<Book> booksList = Arrays.asList(b1, b2, b3, b4, b5);
//        System.out.println(booksList.stream()
//                .collect(Collectors.toMap(k -> k.getId(), v -> v.getTitle())));
        System.out.println(booksList.stream()
                .collect(Collectors.toMap(Book::getId, Book::getTitle)));

        System.out.println("18. From a list of Employee objects with id, name, and salary, " +
                "find the employee with the second-highest salary");
        System.out.println(empList+" Second-highest salary: "+empList.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .skip(1).limit(1).toList());

        System.out.println("19. Given a list of strings, find the longest string.");
        System.out.println(words+": "+words.stream().max(Comparator.comparing(String::length)).get());

        System.out.println("20. From a list of Employee objects, count how many employees belong to each department.");
        System.out.println(empList.stream()
                .collect(Collectors.toMap(Employee::getDepartment, v -> 1, Integer::sum)));
    }
}