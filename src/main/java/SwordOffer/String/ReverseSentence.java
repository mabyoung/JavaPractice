package SwordOffer.String;

public class ReverseSentence {
    public static String reverseSentence(String str) {
        if (str == null || str.trim().equals("")){
            return str;
        }
        String[] split = str.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=split.length-1;i>=0;i--){
            stringBuilder.append(split[i]);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(reverseSentence("student. a am I"));
    }
}
