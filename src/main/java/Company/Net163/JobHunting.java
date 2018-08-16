package Company.Net163;

import java.util.*;

class Work{
    public int difficulty;
    public int payment;
}

public class JobHunting {
    private static List<Work> workList = new ArrayList<>();
    private static int[][]workArray;
    private static int n;
    private static void init(){
        Collections.sort(workList, new Comparator<Work>() {
            @Override
            public int compare(Work o1, Work o2) {
                return o1.difficulty - o2.difficulty;
            }
        });
        int max = workList.get(0).payment;
        for (int i = 0;i< n;i++){
            if (max > workList.get(i).payment){
                workList.get(i).payment = max;
            } else {
                max = workList.get(i).payment;
            }
            workArray[i][0] = workList.get(i).difficulty;
            workArray[i][1] = workList.get(i).payment;
        }
    }

    private static int jobHunting(int key){
        int low = 0, high = n-1, mid;
        while(low<=high){
            mid = (low+high)/2;
            if (workArray[mid][0] == key|| (workArray[mid][0] < key && workArray[mid+1][0] > key)){
                return workArray[mid][1];
            } else if (workArray[mid][0] < key){
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().trim().split(" ");
        n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        for (int i=0;i<n;i++){
            split = scanner.nextLine().trim().split(" ");
            if (split.length <= 0){
                return;
            }
            Work work = new Work();
            work.difficulty = Integer.parseInt(split[0]);
            work.payment = Integer.parseInt(split[1]);
            workList.add(work);
        }
        workArray = new int[n][2];
        String[] s = scanner.nextLine().split(" ");
        for (int i =0;i<m;i++){
            init();
            int result = jobHunting(Integer.parseInt(s[i]));
            System.out.println(result);
        }
    }
}
