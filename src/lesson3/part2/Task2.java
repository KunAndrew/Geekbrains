package lesson3.part2;

import java.util.Set;

public class Task2 {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов", "555");
        phoneBook.add("Иванов", "353");
        phoneBook.add("Сидоров", "684");
        phoneBook.add("Петров", "876");

        for (String name : phoneBook.getAllNames()) {
            System.out.println(name + " " + phoneBook.get(name));
        }
    }
}
