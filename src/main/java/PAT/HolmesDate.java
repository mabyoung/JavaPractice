package PAT;

import java.util.Scanner;

/**
 * 大侦探福尔摩斯接到一张奇怪的字条：“我们约会吧！ 3485djDkxh4hhGE 2984akDfkkkkggEdsb s&hgsfdk d&Hyscvnm”。大侦探很
 * 快就明白了，字条上奇怪的乱码实际上就是约会的时间“星期四 14:04”，因为前面两字符串中第1对相同的大写英文字母（大小写有区分）是
 * 第4个字母'D'，代表星期四；第2对相同的字符是'E'，那是第5个英文字母，代表一天里的第14个钟头（于是一天的0点到23点由数字0到9、
 * 以及大写字母A到N表示）；后面两字符串第1对相同的英文字母's'出现在第4个位置（从0开始计数）上，代表第4分钟。现给定两对字符串，
 * 请帮助福尔摩斯解码得到约会的时间。
 */
public class HolmesDate {
    public static String dataToDate(char[] data, int minute) {
        StringBuilder sb = new StringBuilder(3);
        String[] week = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
        String[] hour = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"};
        if (data[0] >= 'A' && data[0] <= 'G') {
            sb.append(week[data[0] - 'A']).append(" ");
        }
        if (data[1] >= '0' && data[1] <= '9') {
            sb.append(hour[data[1] - '0']);
        } else if (data[1] >= 'A' && data[1] <= 'N') {
            sb.append(hour[data[1] - 'A' + 10]);
        }
        if (minute < 10) {
            sb.append(":").append("0").append(minute);
        } else {
            sb.append(":").append(minute);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] charsA = scanner.nextLine().toCharArray();
        char[] charsB = scanner.nextLine().toCharArray();
        char[] charsC = scanner.nextLine().toCharArray();
        char[] charsD = scanner.nextLine().toCharArray();
        int length1 = Math.min(charsA.length, charsB.length);
        char[] data = new char[2];
        int minute = 0;
        int index = 0;
        for (int i = 0; i < length1 && index < 2; i++) {
            if (index == 0 && charsA[i] == charsB[i] && charsA[i] >= 'A' && charsA[i] <= 'Z') {
                data[index++] = charsA[i];
            }else if (index == 1 && charsA[i] == charsB[i] && (charsA[i] >= 'A' && charsA[i] <= 'Z' || charsA[i] >= '0' && charsA[i] <= '9')) {
                data[index++] = charsA[i];
            }
        }
        int length2 = Math.min(charsC.length, charsD.length);
        for (int i = 0; i < length2 && index < 3; i++) {
            if (charsC[i] == charsD[i] && (charsC[i] >= 'A' && charsC[i] <= 'Z' || charsC[i] >= '0' && charsC[i] <= '9' || charsC[i] >= 'a' && charsC[i] <= 'z')) {
                minute = i;
                break;
            }
        }
        System.out.println(dataToDate(data, minute));
    }
}
