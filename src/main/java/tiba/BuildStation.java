package tiba;

/**
 * 有10^8个村庄排在一条公路上，依次编号为0~10^8-1，相邻村庄距离为1，其中有n个村庄居住着牛牛，居住着牛牛的村庄从小到大依次为a0~an-1，其中保证a0=0.
 * 现在需要建设车站，有两个要求必须被满足：
 * 1、每个有牛牛居住的村庄必须修建车站。
 * 2、相邻车站的距离必须为1或为某个质数。
 * 现给出n和a数组，求需要建设车站的最小数量。
 * 1、当该非质数为偶数时，可以表示为两个质数的和（根据哥德巴赫猜想）；
 * 2、当该非质数为奇数时，分解为p=(p-2)+2：
 * 若p-2为质数，则可表示为两个质数的和
 * 若p-2为非质数，则可表示为三个质数的和（为什么，就是这么神奇！！！）
 */
public class BuildStation {
    /**
     * @param n int整型
     * @param a int整型一维数组
     * @return int整型
     */
    public int work(int n, int[] a) {
        int result = n;
        for (int i = 1; i < n; i++) {
            result += primeAnalyse(a[i] - a[i - 1]) - 1;
        }
        return result;
    }

    /**
     * 给定一个正数，拆解为n个质数之和，要求拆解的个数最小,结果返回n
     * 1.当给定数为质数，返回1
     * 2.当给定数为非质数
     * 2.1如果给定数为偶数，返回2（根据哥德巴赫猜想，一个大于2的偶数可以拆分为2个质数之和）
     * 2.2如果给定数为奇数
     * 2.2.1如果给定数-2后为质数，则给定数可以拆分为num = （num-2） + 2
     * 2.2.2如果给定数-2后为非质数，则给定数可以拆分为num = (两个质数和)+3
     */
    private int primeAnalyse(int num) {
        if (isPrime(num)) {
            return 1;
        }
        if (num % 2 == 0) {
            return 2;
        }
        if (isPrime(num - 2)) {
            return 2;
        } else {
            return 3;
        }
    }

    /**
     * 判断是否是质数
     */
    private boolean isPrime(int num) {
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        BuildStation buildStation = new BuildStation();
        int result = buildStation.work(3, new int[]{0, 7, 11});
        System.out.println(result);
    }
}
