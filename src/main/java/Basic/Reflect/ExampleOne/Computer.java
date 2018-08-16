package Basic.Reflect.ExampleOne;

public class Computer {
    public void run(){
        System.out.println("电脑开机中...");
    }
    public void close(){
        System.out.println("电脑关机中...");
    }
    public void useUsb(USB usb){
        if (usb != null) {
            usb.connection();
            usb.close();
        }
    }
}
