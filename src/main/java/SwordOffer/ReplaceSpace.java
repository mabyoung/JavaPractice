package SwordOffer;

/**
 * Created by rui on 2018/8/18.
 */
public class ReplaceSpace {
    public static String replaceSpace(StringBuffer str) {
        char[] charArray = str.toString().toCharArray();
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < charArray.length; i++) {
            if(charArray[i] == ' '){
                result.append("%20");
            }else{
                result.append(charArray[i]);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("We Are Happy");
        String result = replaceSpace(str);
        System.out.println(result);
    }
}
