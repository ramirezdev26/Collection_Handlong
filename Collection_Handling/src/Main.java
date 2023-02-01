import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    static int count = 0;
    static List<Integer> numList = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,12);
    static List<String> stringList = Arrays.asList("apple", "melon", "pinneapple", "mango", "lemon", "blueberry", "banana", "strawberry", "kiwi", "maracuya", "pitahaya", "sun", "san", "sen", "sin");
    static List<People> peopleList = List.of(new People("Alvarado", 23, "M", "doctor"),
            new People("Espinosa", 25, "M", "teacher"),
            new People("Flores", 27, "F", "teacher"),
            new People("Gómez", 27, "M", "dancer"),
            new People("Giraldo", 17, "M", "dancer"),
            new People("de Maria", 53, "F", "doctor"),
            new People("Espinosa", 53, "M", "writer"),
            new People("Díaz", 23, "F", "saxophonist"),
            new People("Chávez", 11, "M", "student"),
            new People("Alvarado", 33, "F", "student"));

    public static Optional<Integer> primeNumber(List<Integer> list) {
        Optional<Integer> number = list.stream().filter(i -> i > 10).findFirst();
        return number;
    }

    public static void main(String[] args) {

        // EX 1
        int sum = numList.stream()
                        .filter(i -> i % 2 == 0)
                        .map(i -> i * i )
                        .reduce(0, Integer::sum);
        System.out.println(sum);


        // EX 2
        stringList.stream()
                .filter(i -> i.length() > 5)
                .map(String::toUpperCase)
                .forEach(System.out::println);


        // EX 3
        Map<String, Integer> stringMap = stringList.stream()
                .collect(Collectors.toMap(
                        value
                        -> value,
                        value -> value.length()
                ));
        System.out.println(stringMap);

        // EX 4
        Map<String, List<String>> string = stringList.stream()
                .collect(Collectors.groupingBy(s -> s.substring(0,1)));

        System.out.println(string);

        // EX 5
        Map<Integer, List<People>>  peopleListByAge = peopleList.stream()
                .collect(Collectors.groupingBy(People::getAge));

        System.out.println(peopleListByAge);

        // EX 6
        List<String> reverStringList = stringList.stream()
                .filter(i -> i.length() < 4)
                .map(i -> { StringBuilder reverseString = new StringBuilder(i);
                return reverseString.reverse().toString();
                }).toList();
        System.out.println(reverStringList);

        // EX 7
        List<People> olderThanFourty = peopleList.stream()
                .filter(i -> i.getAge() > 40)
                .sorted(Comparator.comparingInt(People::getAge).reversed())
                .toList();
        olderThanFourty.forEach(person -> System.out.println(person.lastName + " " + person.getAge()));

        // EX 8
        Function<List<Integer>, Optional<Integer>> firstPrimeNumber = Main::primeNumber;
        Optional<Integer> number = firstPrimeNumber.apply(numList);
        System.out.println(number);

        // EX 9
        Map<String, List<People>>  peopleByLastName = peopleList.stream()
                .collect(Collectors.groupingBy(People::getLastName));
        peopleByLastName.forEach((key, value) -> System.out.println(key + " : " + value));

        // EX 10
        Map<String, List<People>>  peopleByGender = peopleList.stream()
                .collect(Collectors.groupingBy(People::getGender));
        peopleByGender.forEach((key, value) -> System.out.println(key + " : " + value));

        // EX 11
        numList.stream().collect(Collectors.groupingBy(w -> w, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(System.out::println);

        // EX 12
        Map<String, Double> map = peopleList
                .stream()
                .collect(Collectors.groupingBy(
                        user -> user.getOccupation(),
                        Collectors.averagingInt(People::getAge)));
        System.out.println(map);

    }




}