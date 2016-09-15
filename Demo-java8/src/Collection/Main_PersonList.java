package Collection;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import utils.Person;

public class Main_PersonList {

    static String newLine = System.getProperty("line.separator");

    public static void main(String[] args) {

        // final List<Person> listPerson = PersonsDB.PERSONS;

    }

    /**
     * EXTRACT : MAP -> COLLECT
     */

    public static void ExtractFirstNameList(final List<Person> listPerson) {
        System.out.println("------------------ stream not distinct ------------------- ");

        List<String> mesPrenom = listPerson.stream().map(mp -> mp.getFirstname()).collect(Collectors.toList());
        // ou collect(Collectors.toCollection(ArrayList::new))

        mesPrenom.forEach(System.out::println);

    }

    /**
     * EXTRACT : MAP -> DISTINC -> COLLECT
     */
    public static void ExtractFirstNameListDistinct(final List<Person> listPerson) {
        System.out.println("------------------ stream distinct ------------------- ");

        List<String> mesPrenomdsitinct = listPerson.stream().map(mp -> mp.getFirstname()).distinct()
                .collect(Collectors.toList());
        for (String item : mesPrenomdsitinct) {
            System.out.println(item);
        }
    }

    /**
     * FILTER -> COLLECT
     */
    public static List<Person> filterByStartLetter(final List<Person> listPerson) {
        final List<Person> subList = listPerson.stream().filter((p) -> p.getLastname().startsWith("D"))
                .collect(Collectors.toList());

        return subList;
    }

    /**
     * FILTER -> MAP -> REDUCE
     */
    public static void filterandCountSum(final List<Person> listPerson) {
        System.out.println(newLine + "----- accumulated Ages -------- " + newLine);
        final int accumulatedAges = listPerson.stream().filter((person) -> person.getLastname().startsWith("D"))
                .map((person) -> person.getAge()).reduce(0, (x, y) -> x + y);
        
        System.out.println(accumulatedAges);

    }

    /**
     * STREAM -> COLLECT -> SUM
     */
    public static Integer filterandCountSum2(final List<Person> listPerson) {
        System.out.println(newLine + "----- Total sum of Ages -------- " + newLine);
        Integer ageTotal = listPerson.stream().collect(Collectors.summingInt(Person::getAge));

        return ageTotal;
    }

    /**
     * STREAM -> Sorted -> FindFirst
     */
    public static Person filterFirstElement(final List<Person> listPerson) {
        System.out.println(newLine + "----- First element in Stream " + newLine);
        Optional<Person> person = listPerson.stream().sorted((p1, p2) -> p1.getHireDate().compareTo(p2.getHireDate()))
                .findFirst();
        
        return person.isPresent() ? person.get() : null;

    }

}
