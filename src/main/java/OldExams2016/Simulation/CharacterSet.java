package OldExams2016.Simulation;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CharacterSet {
    public static String getCharacterSet(String line) {
        StringBuilder stringBuilder = new StringBuilder();
        Set<Character> set = new HashSet<>();
        for (char item : line.toCharArray()) {
            if (!set.contains(item)) {
                set.add(item);
                stringBuilder.append(item);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            System.out.println(getCharacterSet(line));
        }
    }
}
