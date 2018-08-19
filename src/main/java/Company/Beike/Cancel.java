package Company.Beike;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Created by rui on 2018/8/18.
 */
public class Cancel {
    public static List<Group> groupList = new ArrayList<>();
    public static class Group{
        int begin;
        int end;
    }
    public static boolean isOk(List<Group> groupList){
        for (int i =0;i< groupList.size()-1;i++){
            if ((groupList.get(i).end <groupList.get(i).begin)||(groupList.get(i).end > groupList.get(i+1).begin)){
                return false;
            }
        }
        return true;
    }
    public static void solve(){
        List<Integer> result = new ArrayList<>();
        for (int i=0;i<groupList.size();i++){
            List<Group> tmp = new ArrayList<>();
            for (Group group : groupList) {
                Group item = new Group();
                item.begin = group.begin;
                item.end = group.end;
                tmp.add(group);
            }
            tmp.remove(i);
            if (isOk(tmp)){
                result.add(i+1);
            }
        }
        System.out.println(result.size());
            for (int i =0;i<result.size();i++){
                if (i==0){
                    System.out.print(result.get(0));
                }else{
                    System.out.print(" "+result.get(i));
                }
            }
//        int count = 0;
//        for (int i=0;i<groupList.size();i++){
//            if (i+1<groupList.size() && groupList.get(i).end > groupList.get(i+1).begin){
//                count++;
//                result.add(i+1);
//                if (i+2<groupList.size() && groupList.get(i).end < groupList.get(i+2).begin){
//                    count++;
//                    result.add(i+2);
//                }
//            }
//        }
//        if (count == 1){
//            System.out.println(1);
//            System.out.println(result.get(0));
//        }else if (count ==0){
//            System.out.println(groupList.size());
//            for (int i =1;i<=groupList.size();i++){
//                if (i==1){
//                    System.out.print(1);
//                }else{
//                    System.out.print(" "+i);
//                }
//            }
//        }else{
//            System.out.println(result.size());
//            for (int i =0;i<result.size();i++){
//                if (i==0){
//                    System.out.print(result.get(0));
//                }else{
//                    System.out.print(" "+result.get(i));
//                }
//            }
//        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0;i<n;i++){
            Group group = new Group();
            group.begin = scanner.nextInt();
            group.end = scanner.nextInt();
            groupList.add(group);
        }
        groupList.sort(new Comparator<Group>() {
            @Override
            public int compare(Group o1, Group o2) {
                long tmp = o1.begin- o2.begin;
                if (tmp >0){
                    return 1;
                }else if (tmp ==0){
                    long tmp2 = o1.end- o2.end;
                    if (tmp2>0){
                        return 1;
                    }else if (tmp2 == 0){
                        return 0;
                    }else {
                        return -1;
                    }
                }else{
                    return -1;
                }
            }
        });
        solve();
        System.gc();
    }
}
