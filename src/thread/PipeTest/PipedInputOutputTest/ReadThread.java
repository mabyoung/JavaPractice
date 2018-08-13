package thread.PipeTest.PipedInputOutputTest;

import java.io.PipedInputStream;

public class ReadThread extends Thread{
    private ReadData read;
    private PipedInputStream input;

    public ReadThread(ReadData read, PipedInputStream input) {
        super();
        this.read = read;
        this.input = input;
    }

    @Override
    public void run() {
        read.readMethod(input);
    }
}
