package Coderwars.Kyu6;

import java.util.List;

public class BinaryArrayToNumber {
    public static int ConvertBinaryArrayToInt(List<Integer> binary) {
        int result = 0;
        for (int i = binary.size()-1;i>=0;i--){
            result += binary.get(i)*Math.pow(2,binary.size()-i-1);
        }
        return result;
    }
}
