package OldExams2016.Dynamic;

import java.util.Scanner;

public class OffenderTransfer {
    public static int getTransferWay(int[] criminalValues, int maxValueSum, int transferNum) {
        int transferWay = 0;
        int valueSum = 0;
        for (int i = 0; i < transferNum; i++) {
            valueSum += criminalValues[i];
        }
        for (int i = transferNum-1; i < criminalValues.length; i++) {
            if (i >= transferNum) {
                valueSum += criminalValues[i];
                valueSum -= criminalValues[i - transferNum];
            }
            if (valueSum <= maxValueSum) {
                transferWay++;
            }
        }
        return transferWay;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int criminalCount = scanner.nextInt();
            int maxValueSum = scanner.nextInt();
            int traferNum = scanner.nextInt();
            int[] criminalValues = new int[criminalCount];
            for (int i = 0; i < criminalCount; i++) {
                criminalValues[i] = scanner.nextInt();
            }
            System.out.println(getTransferWay(criminalValues, maxValueSum, traferNum));
        }
    }
}
