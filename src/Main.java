import java.util.*;
import java.util.stream.Stream;

import static java.util.Comparator.*;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        long childCount = persons.stream().filter(person -> person.getAge() < 18).count();
        System.out.println("childrens = " +  childCount);
        long menCount = persons.stream().filter(person -> person.getAge() >= 18 && person.getAge() <= 27).count();
        System.out.println("men = " +  menCount);
        persons.stream()
                .filter(person -> person.getAge() > 18 && person.getAge() <= 60 && person.getEducation().equals(Education.HIGHER))
                .sorted(Comparator.comparing(person -> person.getFamily()))
                .forEach(System.out::println);

    }
}
