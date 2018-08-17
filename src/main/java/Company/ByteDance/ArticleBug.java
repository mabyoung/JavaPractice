package Company.ByteDance;

import java.util.*;

/**
 * Created by rui on 2018/8/12.
 */
class Bug{
    public long begin;
    public long end;
}

public class ArticleBug {
    private static int article;
    private static List<Bug> bugList = new ArrayList<>();
    private static List<Bug> resultList = new ArrayList<>();
    private static void init(){
        Collections.sort(bugList, new Comparator<Bug>() {
            @Override
            public int compare(Bug o1, Bug o2) {
                if (o1.begin>o2.begin)
                    return 1;
                else if (o1.begin==o2.begin)
                    return 0;
                else
                    return -1;
            }
        });
//        for (Bug bug : bugList) {
//            System.out.println(bug.begin+"_"+bug.end);
//        }
    }
    private static void articleBug(){
        init();
        Bug bug = new Bug();
        bug.begin = bugList.get(0).begin;
        bug.end = bugList.get(0).end;
        for (int i=1;i<=bugList.size();i++){
            if (i == bugList.size()){
                if (bugList.get(i-1).begin>bug.end){
                    bug.begin = bugList.get(i-1).begin;
                    bug.end = bugList.get(i-1).end;
                    resultList.add(bug);
                } else if (bugList.get(i-1).end >bug.end){
                    bug.end = bugList.get(i-1).end;
                    resultList.add(bug);
                } else {
                    resultList.add(bug);
                }
                return;
            }
            if (bug.end < bugList.get(i).begin){
                Bug tmp = new Bug();
                tmp.begin = bug.begin;
                tmp.end = bug.end;
                resultList.add(tmp);
                if (i+1<bugList.size()){
                    bug.begin = bugList.get(i).begin;
                    bug.end = bugList.get(i).end;
                }
            } else if (bugList.get(i).end >bug.end){
                bug.end = bugList.get(i).end;
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = Integer.parseInt(scanner.nextLine().trim());
        for (int i =0;i<m;i++){
            String[] split = scanner.nextLine().trim().split(";");
            for (int j = 0;j<split.length;j++){
                Bug bug = new Bug();
                String[] split1 = split[j].split(",");
                bug.begin = Integer.parseInt(split1[0]);
                bug.end = Integer.parseInt(split1[1]);
                bugList.add(bug);
            }
        }
        articleBug();
        for (int i=0;i<resultList.size();i++){
            if (i>0){
                System.out.print(";");
            }
            System.out.print(resultList.get(i).begin+","+resultList.get(i).end);
        }
    }
}
