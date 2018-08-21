package SwordOffer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class PrintMinNumber {
    public static String printMinNumber(int[] numbers) {
        ArrayList<String> numberList = new ArrayList<>();
        for (int number : numbers) {
            numberList.add("" + number);
        }
        numberList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1+o2;
                String s2 = o2+o1;
                return s1.compareTo(s2);
            }
        });
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : numberList) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        String result = printMinNumber(numbers);
        System.out.println(result);
    }
}
