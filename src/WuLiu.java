import java.util.Scanner;

class Point{
    int px;
    int py;
    boolean visited;

    public Point(int px, int py) {
        this.px = px;
        this.py = py;
        this.visited = false;
    }

    public int getLength(Point p){
        return Math.abs(px - p.px) + Math.abs(py - p.py);
    }
}
public class WuLiu {
    static final Point START = new Point(0,0);
    static int minpath = Integer.MAX_VALUE;

    public static int DFS(Point start, Point[] points, int sum, int count){
        if(count == points.length){
            minpath = Math.min(minpath, sum +start.getLength(START));
            return minpath;
        }
        for(int i = 0; i<points.length; i++){
            if(!points[i].visited){
                sum += points[i].getLength(start);
                if(sum < minpath){
                    points[i].visited = true;
                    DFS(points[i], points, sum, count+1);
                }
                sum -= points[i].getLength(start);
                points[i].visited = false;
            }
        }
        return minpath;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int inpuNum = Integer.parseInt(input.nextLine());
        Point[] points = new Point[inpuNum];
        for(int index = 0; index<inpuNum; index++){
            String[] locations = input.nextLine().split(",");
            points[index] = new Point(Integer.parseInt(locations[0]), Integer.parseInt(locations[1]));
        }
        int min = DFS(START, points, 0, 0);
        System.out.println(min);
    }
}
