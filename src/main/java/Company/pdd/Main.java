package Company.pdd;


import java.util.Scanner;

/**
 * Created by rui on 2018/8/30.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hp = scanner.nextInt();
        int nAttack = scanner.nextInt();
        int bAttack = scanner.nextInt();
        if (nAttack >= hp) {
            System.out.println(1);
        } else if (2 * nAttack >= bAttack) {
            System.out.println((hp - 1) / nAttack + 1);
        } else {
            int preNum = hp / bAttack * 2;
            int attack = preNum / 2 * bAttack;
            if (attack >= hp) {
                System.out.println(preNum);
            } else if (attack + nAttack >= hp) {
                System.out.println(preNum + 1);
            } else {
                System.out.println(preNum + 2);
            }
        }
    }
}
