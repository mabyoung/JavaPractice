package Company.Didi;

import java.util.*;
class Node implements Comparable<Node>{
    String val;
    int simi;
    public Node(String val, int simi) {
        super();
        this.val = val;
        this.simi = simi;
    }
    public int getSimi() {
        return simi;
    }
    public void setSimi(int simi) {
        this.simi = simi;
    }
    @Override
    public int compareTo(Node o) {
        // TODO Auto-generated method stub
        if(this.simi>o.simi){
            return 1;
        }else if(this.simi<o.simi){
            return -1;
        }else{
            return 0;
        }
    }


}
public class Main {
    public static int getSimi(String A,String B){
        String str1 = "qwertasdfgzxcv";
        String str2 = "yuiophjklbnm";
        if(A.equals(B)) {
            return 0;
        }
        //dp[i][j]表示源串A位置i到目标串B位置j处最低需要操作的次数
        int[][] dp = new int[A.length() + 1][B.length() + 1];
        for(int i = 1;i <= A.length();i++)
            dp[i][0] = i;
        for(int j = 1;j <= B.length();j++)
            dp[0][j] = j;
        for(int i = 1;i <= A.length();i++) {
            for(int j = 1;j <= B.length();j++) {
                if(A.charAt(i - 1) == B.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else {
//                	int len1 = dp[i - 1][j] + 3;
//                	int len2 = dp[i][j - 1] + 3;
//                	int len3=0;
//                	char ch1 = A.charAt(i-1);
//                	char ch2 = A.charAt(j-1);
//                	int c1 = str1.indexOf(ch1);
//                	int c2 = str1.indexOf(ch1);
//                	if(c1!=-1 && c2!=-1){
//                		len3 = dp[i-1][j - 1] + 1;
//                	}else if(c1==-1 && c2==-1){
//                		len3 = dp[i-1][j - 1] + 1;
//                	}else{
//                		len3 = dp[i-1][j - 1] + 2;
//                	}
//                    dp[i][j] = Math.min(len1,Math.min(len2,len3));
                    dp[i][j] = Math.min(dp[i - 1][j] + 1,
                            Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1));
                }
            }
        }
        return (dp[A.length()][B.length()]);

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String[] strlist = str1.split(" ");
        int size = strlist.length-1;
        str1 = strlist[0];
        String[] strl = new String[size];
        for(int i=1;i<=size;i++){
            strl[i-1] = strlist[i];
        }
        int[] similist = new int[size];
        for(int i=0;i<size;i++){
            int simi = getSimi(str1,strl[i]);
            similist[i] = simi;
        }

        List<Node> arrLi = new ArrayList<>();
        for(int i=0;i<size;i++){
            String st = strl[i];
            int simi = similist[i];
            Node node = new Node(st, simi);
            arrLi.add(node);
        }
        Collections.sort(arrLi);
        if(arrLi.size()>3){
            for(int i=0;i<3;i++){
                System.out.println(arrLi.get(i).val);
            }
        }else{
            for(int i=0;i<arrLi.size();i++){
                System.out.println(arrLi.get(i).val);
            }
        }


    }

}

