package thread.PipeTest.PipedInputOutputTest;

import java.io.PipedOutputStream;

public class WriteThread extends Thread{
    private WriteData write;
    private PipedOutputStream out;

    public WriteThread(WriteData write, PipedOutputStream out) {
        super();
        this.write = write;
        this.out = out;
    }

    @Override
    public void run() {
        write.writeMethod(out);
    }
}
