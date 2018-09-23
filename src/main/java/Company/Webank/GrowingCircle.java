package Company.Webank;
import  java.util.*;
/**
 * Created by rui on 2018/9/18.
 */
class Pointer{
    int no;
    int x;
    int y;
    public Pointer(int no, int x, int y){
        this.no = no;
        this.x = x;
        this.y = y;
    }
}
class Distance{
    int no1;
    int no2;
    double dis;
    public Distance(int no1, int no2, double dis){
        this.no1 = no1;
        this.no2 = no2;
        this.dis = dis;
    }
}
public class GrowingCircle {
    public static double getDistance(Pointer p1, Pointer p2){
        return Math.sqrt((p1.x-p2.x)*(p1.x-p2.x)+(p1.y-p2.y)*(p1.y-p2.y));
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Pointer[] input = new Pointer[n];
        for (int i=0;i<n;i++){
            Pointer pointer = new Pointer(i, scanner.nextInt(), scanner.nextInt());
            input[i] = pointer;
        }
        List<Distance> distanceList = new ArrayList<>();
        for (int i=0;i<n;i++){
            Pointer pointerI = input[i];
            for (int j = i+1;j<n;j++){
                Pointer pointerJ = input[j];
                Distance distance = new Distance(i,j,getDistance(pointerI, pointerJ));
                distanceList.add(distance);
            }
        }
        distanceList.sort(new Comparator<Distance>() {
            @Override
            public int compare(Distance o1, Distance o2) {
                if (o1.dis<o2.dis){
                    return -1;
                } else if (o1.dis > o2.dis){
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        Map<Integer, Double> map = new HashMap<>();
        for (Distance distance : distanceList) {
            int no1 = distance.no1;
            int no2 = distance.no2;
            double dis = distance.dis;
            if (!map.containsKey(no1) && map.containsKey(no2)){
                Double no2r = map.get(no2);
                map.put(no1, dis-no2r);
            }else if (map.containsKey(no1) && !map.containsKey(no2)){
                Double no1r = map.get(no1);
                map.put(no2, dis-no1r);
            }else if (!map.containsKey(no1) && !map.containsKey(no2)){
                map.put(no1, dis/2);
                map.put(no2, dis/2);
            }
        }
        for (int i=0;i<n;i++){
            String tmp = ""+(double)Math.round(map.get(i)*1000)/1000;
            System.out.print(tmp);
            if (tmp.length()<5){
                for (int j=0;j<5-tmp.length();j++){
                    System.out.print(0);
                }
            }
            if (i!=n-1){
                System.out.print(" ");
            }
        }
    }

}
