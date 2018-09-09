package Company.JD;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Created by rui on 2018/9/9.
 */
class Product{
    public long a;
    public long b;
    public long c;
}
public class Compare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Product> list = new ArrayList<>();
        for (int i=0;i<n;i++){
            Product product = new Product();
            product.a = scanner.nextLong();
            product.b = scanner.nextLong();
            product.c = scanner.nextLong();
            list.add(product);
        }
        int count = 0;
        for (int i=0;i<n;i++){
            for (int j =0;j<n;j++){
                Product productI = list.get(i);
                Product productJ = list.get(j);
                if (productI.a<productJ.a && productI.b <productJ.b && productI.c <productJ.c){
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
