package Basic.Thread.PipeTest.PipedInputOutputTest;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Main {
    public static void main(String[] args) {
        try {
            WriteData writeData = new WriteData();
            ReadData readData = new ReadData();

            PipedInputStream inputStream = new PipedInputStream();
            PipedOutputStream outputStream = new PipedOutputStream();

            /**
             * outputStream.connect(inputStream)或inputStream.connect(outputStream)都可以使两个管道流产生链接
             */
             inputStream.connect(outputStream);
//            outputStream.connect(inputStream);

            ReadThread threadRead = new ReadThread(readData, inputStream);
            threadRead.start();

            Thread.sleep(2000);

            WriteThread threadWrite = new WriteThread(writeData, outputStream);
            threadWrite.start();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
