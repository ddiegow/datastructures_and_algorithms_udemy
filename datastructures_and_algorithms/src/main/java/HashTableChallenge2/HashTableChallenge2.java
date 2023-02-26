package HashTableChallenge2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class HashTableChallenge2 {
    public static void main(String[] args) {

        LinkedList<Employee> employees = new LinkedList<>();
        HashMap<Integer, Employee> duplicateRemover = new HashMap<>();
        employees.add(new Employee("Jane", "Jones", 123));
        employees.add(new Employee("John", "Doe", 5678));
        employees.add(new Employee("Mike", "Wilson", 45));
        employees.add(new Employee("Mary", "Smith", 5555));
        employees.add(new Employee("John", "Doe", 5678));
        employees.add(new Employee("Bill", "End", 3948));
        employees.add(new Employee("Jane", "Jones", 123));
        // use the fact that hashmap does not store duplicates.  if we use the same key for different values, it overrides the value
        // but in this case each employee id is unique, so we don't need to worry about it.
        employees.forEach(e -> {
            duplicateRemover.put(e.getId(), e);
        });
        employees.clear();
        for (Map.Entry<Integer, Employee> me: duplicateRemover.entrySet()) {
            employees.add(me.getValue());
        }

        employees.forEach(e -> System.out.println(e));
    }

}
