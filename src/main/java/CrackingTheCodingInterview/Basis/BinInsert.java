package CrackingTheCodingInterview.Basis;

public class BinInsert {
    public int binInsert(int n, int m, int j, int i) {
        return n + m * (int)Math.pow(2, j);
    }

    public static void main(String[] args) {
        BinInsert binInsert = new BinInsert();
        System.out.println(binInsert.binInsert(4355, 4, 2, 7));
    }
}
