package CrackingTheCodingInterview.String;

public class Zipper {
    public String zipString(String iniString) {
        if (iniString == null || iniString.length() == 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        for (int i = 0; i < iniString.length(); i++) {
            if (i == 0) {
                count = 1;
                stringBuilder.append(iniString.charAt(i));
            } else if (iniString.charAt(i) == iniString.charAt(i - 1)) {
                count++;
            } else {
                stringBuilder.append(count).append(iniString.charAt(i));
                count = 1;
            }
        }
        stringBuilder.append(count);
        return stringBuilder.length() >= iniString.length() ? iniString : stringBuilder.toString();
    }

    public static void main(String[] args) {
        Zipper zipper = new Zipper();
        System.out.println(zipper.zipString("aabcccccaaa"));
        System.out.println(zipper.zipString("welcometonowcoderrrrr"));
    }
}
