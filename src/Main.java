import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(5, 8, 12, 3, 15);
        System.out.println("1. Filter Even Numbers: "+nums.stream().filter(x -> x%2==0).toList());

        List<String> names = Arrays.asList("Alice", "Adam", "Bob", "Alex");
        System.out.println("2. Convert to Uppercase: "+names.stream().map(x -> x.toUpperCase()).toList());

//        Lambda Expression (a, b) -> a - b:
//        1. Subtracts b from a.
//        2. If the result is positive (a > b), a is considered bigger.
//        3. If the result is negative (a < b), b is bigger.
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
    }
}