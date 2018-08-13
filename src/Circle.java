class Circle {
    private  double radius = 0;
    public Circle(double radius){
        this.radius = radius;
    }
    private Draw getDrawInstance(){
        int i = 0;
        return new Draw();
    }
    class Draw {
        public void drawShape(){
            System.out.println(radius);
        }
    }

    public static void main(String[] args) {
        Circle circle = new Circle(2);
        Draw drawInstance = circle.getDrawInstance();
        drawInstance.drawShape();
    }
}
