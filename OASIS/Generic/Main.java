import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create test data
        Person person1 = new Person("Nguyen A", 22, "Hanoi");
        Person person2 = new Person("Nguyen A", 20, "Ho Chi Minh");
        Person person3 = new Person("Le B", 20, "Da Nang");
        Person person4 = new Person("Tran C", 25, "Hue");
        Person person5 = new Person("Le B", 18, "Can Tho");

        // Add to list
        List<Person> people = new ArrayList<>();
        people.add(person1);
        people.add(person2);
        people.add(person3);
        people.add(person4);
        people.add(person5);

        // Print before sorting
        System.out.println("Before sorting:");
        printList(people);

        // Sort using sortGeneric
        people = person1.sortGeneric(people);

        // Print after sorting
        System.out.println("\nAfter sorting:");
        printList(people);

        // Expected order:
        // Le B (18) < Le B (20) < Nguyen A (20) < Nguyen A (22) < Tran C (25)
    }

    private static void printList(List<Person> list) {
        for (int i = 0; i < list.size(); i++) {
            Person p = list.get(i);
            System.out.println((i + 1) + ". " + p.getName() + 
                             ", age=" + p.getAge() + 
                             ", address=" + p.getAddress());
        }
    }
}
