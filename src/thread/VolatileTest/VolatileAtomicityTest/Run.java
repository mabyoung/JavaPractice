package thread.VolatileTest.VolatileAtomicityTest;

public class Run {
    public static void main(String[] args) {
        Mythread[] mythreadArray = new Mythread[100];
        for (int i = 0; i < mythreadArray.length; i++) {
            mythreadArray[i] = new Mythread();
        }
        for (Mythread mythread : mythreadArray) {
            mythread.start();
        }
    }
}
