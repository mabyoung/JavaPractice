package Basic.Reflect.ExampleOne;

import java.io.InputStream;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws Exception {
        Computer computer = new Computer();
        InputStream resourceAsStream = computer.getClass().getResourceAsStream("/usb.properties");
        Properties properties = new Properties();
        properties.load(resourceAsStream);
        for (int i = 1;i<= 3;i++){
            String className = properties.getProperty("usb"+i);
            if (className != null) {
                USB usb = (USB) Class.forName(className).newInstance();
                computer.useUsb(usb);
            }
        }
    }
}
