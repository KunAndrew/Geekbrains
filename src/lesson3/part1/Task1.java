package lesson3.part1;

import java.util.HashMap;
import java.util.Map;

public class Task1 {
    public static void main(String[] args) {
        String wordsArray[] = new String[10];
        wordsArray[0] = "клен";
        wordsArray[1] = "клен";
        wordsArray[2] = "дуб";
        wordsArray[3] = "дуб";
        wordsArray[4] = "дуб";
        wordsArray[5] = "береза";
        wordsArray[6] = "клен";
        wordsArray[7] = "вишня";
        wordsArray[8] = "орех";
        wordsArray[9] = "вишня";

        Map<String, Integer> map = new HashMap();
        for (String s : wordsArray) {
            Integer frequency = map.getOrDefault(s, 0);
            map.merge(s, 1, Integer::sum);
        }
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }
}
