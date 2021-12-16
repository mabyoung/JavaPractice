package LeetCode.Simulation;

import Company.Qihoo360.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReadBinaryWatch {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    result.add(h + (m < 10 ? ":0" : ":") + m);
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        ReadBinaryWatch readBinaryWatch = new ReadBinaryWatch();
        List<String> result = readBinaryWatch.readBinaryWatch(1);
        for (String item : result) {
            System.out.println(item);
        }
    }
}
