package CrackingTheCodingInterview.Basis;

public class Bipartition {
    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point() {
            this.x = 0;
            this.y = 0;
        }
    }

public double[] getBipartition(Point[] A, Point[] B) {
    double centA_x = (A[0].x + A[1].x + A[2].x + A[3].x) / 4.0;
    double centA_y = (A[0].y + A[1].y + A[2].y + A[3].y) / 4.0;
    double centB_x = (B[0].x + B[1].x + B[2].x + B[3].x) / 4.0;
    double centB_y = (B[0].y + B[1].y + B[2].y + B[3].y) / 4.0;
    double slope = (centB_y - centA_y) / (centB_x - centA_x);
    double intercept = centA_y - slope * centA_x;
    return new double[]{slope, intercept};
}

    public static void main(String[] args) {
        Bipartition bipartition = new Bipartition();
        Point[] A = new Point[]{new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 0)};
        Point[] B = new Point[]{new Point(1, 0), new Point(1, 1), new Point(2, 0), new Point(2, 1)};
        double[] result = bipartition.getBipartition(A, B);
        System.out.println(result);
    }
}
