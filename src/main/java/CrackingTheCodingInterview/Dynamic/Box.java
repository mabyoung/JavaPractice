package CrackingTheCodingInterview.Dynamic;

import java.util.ArrayList;
import java.util.List;

public class Box {
    public class BoxWithMaxHeight {
        public int w;
        public int l;
        public int h;
        public int maxHeight;

        BoxWithMaxHeight(int w, int l, int h, int maxHeight) {
            this.w = w;
            this.l = l;
            this.h = h;
            this.maxHeight = maxHeight;
        }
    }

    public int getHeight(int[] w, int[] l, int[] h, int n) {
        List<BoxWithMaxHeight> boxList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            boxList.add(new BoxWithMaxHeight(w[i], l[i], h[i], h[i]));
        }
        boxList.sort((o1, o2) -> {
            if (o1.w != o2.w) {
                return o1.w - o2.w;
            } else if (o1.l != o2.l) {
                return o1.l - o2.l;
            } else {
                return o1.h - o2.h;
            }
        });
        int result = 0;
        for (int i = 1; i < boxList.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (boxList.get(j).l < boxList.get(i).l && boxList.get(j).w < boxList.get(i).w && boxList.get(j).maxHeight + boxList.get(i).h > boxList.get(i).maxHeight) {
                    boxList.get(i).maxHeight = boxList.get(j).maxHeight + boxList.get(i).h;
                    result = Math.max(result, boxList.get(i).maxHeight);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Box box = new Box();
        int result = box.getHeight(new int[]{191,883,2543,485,2551,605,2023,1768,770,196,739,2440,2248,1171,1090},
                new int[]{74,521,65,1660,1113,1530,885,220,120,1717,2443,2828,327,64,1537},
                new int[]{2096,2514,2362,1935,1230,24,658,2076,2033,655,271,2977,1018,959,633}, 15);
        System.out.println(result);
    }
}
