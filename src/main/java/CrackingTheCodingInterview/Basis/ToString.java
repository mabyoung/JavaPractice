package CrackingTheCodingInterview.Basis;

public class ToString {
    String[] belowTwenty = new String[]{"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] belowHundred = new String[]{"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String toString(int x) {
        String result = "";
        if (x < 20) {
            return belowTwenty[x-1];
        } else if (x < 100) {
            return belowHundred[(x / 10) - 2] + " " + toString(x % 10);
        }
        return result;
    }

    public static void main(String[] args) {
        ToString toString = new ToString();
        System.out.println(toString.toString(19));
    }
}
