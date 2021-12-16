package LeetCode;

public class MinSpeedOnTime {
    public int minSpeedOnTime(int[] dist, double hour) {
        if (dist.length - 1 > hour) {
            return -1;
        }
        int left = 1;
        int right = 10000000;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (isOk(dist, hour, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean isOk(int[] dist, double hour, int speed) {
        double sumHour = 0;
        for (int d : dist) {
            sumHour = Math.ceil(sumHour);
            sumHour += (d * 1.0) / speed;
            if (sumHour > hour) {
                break;
            }
        }
        return sumHour <= hour;
    }

    public static void main(String[] args) {
        MinSpeedOnTime minSpeedOnTime = new MinSpeedOnTime();
        int result = minSpeedOnTime.minSpeedOnTime(new int[]{1,1,10000}, 2.01);
        System.out.println(result);

    }
}
