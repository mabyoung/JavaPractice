package OldExams2016.Simulation;

public class Apple {
    public int getInitial(int n) {
        if (n == 1){
            return 1;
        }
        int i = 0;
        while(true){
            int result = getResult(i, n);
            if (result != -1){
                return result;
            }
            i++;
        }
    }

    private int getResult(int result, int n) {
        for (int i = 0; i < n; i++) {
            if (isValid(result, n)) {
                result = getNextValue(result, n);
            } else {
                return -1;
            }
        }
        return result;
    }

    private boolean isValid(int result, int n) {
        return result == 0 ||(result % (n - 1) == 0);
    }

    private int getNextValue(int result, int n) {
        return result * n / (n - 1) + 1;
    }

    public static void main(String[] args) {
        Apple apple = new Apple();
        for (int i = 1; i < 10; i++) {
            System.out.println(apple.getInitial(i));
        }
    }
}
