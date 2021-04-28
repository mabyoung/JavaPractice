package CrackingTheCodingInterview.String;

public class Substr {
    public boolean[] chkSubStr(String[] p, int n, String s) {
        boolean[] result = new boolean[p.length];
        for (int i = 0; i < p.length; i++) {
            result[i] = s.contains(p[i]);
        }
        return result;
    }
}
