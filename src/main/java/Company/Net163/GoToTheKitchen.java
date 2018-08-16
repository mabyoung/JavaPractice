package Company.Net163;

import java.util.HashSet;
import java.util.Scanner;

public class GoToTheKitchen {
    public static void main(String[] args) {
        HashSet<String> material = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String[] split = scanner.nextLine().trim().split(" ");
            for (String item : split) {
                material.add(item);
            }
        }
        System.out.println(material.size());
    }
}
