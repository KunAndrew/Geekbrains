package lesson3.part2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneBook {
    Map<String, Set<String>> phoneBook = new HashMap<>();

    public void add(String name, String number) {
        Set<String> phones = phoneBook.computeIfAbsent(name, key -> new HashSet<>());
        phones.add(number);
    }

    public Set<String> get(String name) {
        return phoneBook.computeIfAbsent(name, key -> new HashSet<>());
    }

    public Set<String> getAllNames() {
        return phoneBook.keySet();
    }
}
