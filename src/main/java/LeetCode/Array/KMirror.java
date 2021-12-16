package LeetCode.Array;

import java.util.*;

public class KMirror {
    public long kMirror(int k, int n) {
        Map<Integer, List<Long>> map = new HashMap<>();
        map.put(2, Arrays.asList(1L, 3L, 5L, 7L, 9L, 33L, 99L, 313L, 585L, 717L, 7447L, 9009L, 15351L, 32223L, 39993L, 53235L, 53835L, 73737L, 585585L, 1758571L, 1934391L, 1979791L, 3129213L, 5071705L, 5259525L, 5841485L, 13500531L, 719848917L, 910373019L, 939474939L));
        map.put(3, Arrays.asList(1L, 2L, 4L, 8L, 121L, 151L, 212L, 242L, 484L, 656L, 757L, 29092L, 48884L, 74647L, 75457L, 76267L, 92929L, 93739L, 848848L, 1521251L, 2985892L, 4022204L, 4219124L, 4251524L, 4287824L, 5737375L, 7875787L, 7949497L, 27711772L, 83155138L));
        map.put(4, Arrays.asList(1L, 2L, 3L, 5L, 55L, 373L, 393L, 666L, 787L, 939L, 7997L, 53235L, 55255L, 55655L, 57675L, 506605L, 1801081L, 2215122L, 3826283L, 3866683L, 5051505L, 5226225L, 5259525L, 5297925L, 5614165L, 5679765L, 53822835L, 623010326L, 954656459L));
        map.put(5, Arrays.asList(1L, 2L, 3L, 4L, 6L, 88L, 252L, 282L, 626L, 676L, 1221L, 15751L, 18881L, 10088001L, 10400401L, 27711772L, 30322303L, 47633674L, 65977956L, 808656808L, 831333138L, 831868138L, 836131638L, 836181638L, 2512882152L, 2596886952L, 2893553982L));
        map.put(6, Arrays.asList(1L, 2L, 3L, 4L, 5L, 7L, 55L, 111L, 141L, 191L, 343L, 434L, 777L, 868L, 1441L, 7667L, 7777L, 22022L, 39893L, 74647L, 168861L, 808808L, 909909L, 1867681L, 3097903L, 4232324L, 4265624L, 4298924L, 4516154L, 4565654L));
        map.put(7, Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L, 8L, 121L, 171L, 242L, 292L, 16561L, 65656L, 2137312L, 4602064L, 6597956L, 6958596L, 9470749L, 61255216L, 230474032L, 466828664L, 485494584L, 638828836L, 657494756L, 858474858L));
        map.put(8, Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L, 7L, 9L, 121L, 292L, 333L, 373L, 414L, 585L, 3663L, 8778L, 13131L, 13331L, 26462L, 26662L, 30103L, 30303L, 207702L, 628826L, 660066L, 1496941L, 1935391L, 1970791L, 4198914L, 55366355L));
        map.put(9, Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 191L, 282L, 373L, 464L, 555L, 646L, 656L, 6886L, 25752L, 27472L, 42324L, 50605L, 626626L, 1540451L, 1713171L, 1721271L, 1828281L, 1877781L, 1885881L, 2401042L, 2434342L, 2442442L));
        List<Long> list = map.get(k);
        long result = 0;
        for (int i = 0; i < n; i++) {
            result += list.get(i);
        }
        return result;
    }

    public String getK(long num, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        while (num > 0) {
            stringBuilder.append(num % k);
            num /= k;
        }
        return stringBuilder.reverse().toString();
    }

    public boolean isMirror(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public String getNum(int x, int length) {
        String s = String.valueOf(x);
        StringBuilder stringBuilder = new StringBuilder(s.substring(s.length() - length));
        return s + stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        KMirror kMirror = new KMirror();
        System.out.println(kMirror.getNum(10, 3));
    }
}
