package Basic.Thread.ThreadPriority;

public class ThreadPriorityTest {
    public static class High extends Thread
    {
        static int count = 0;
        @Override
        public void run()
        {
            while (true)
            {
                synchronized (ThreadPriorityTest.class)
                {
                    count++;
                    if (count > 10000000)
                    {
                        System.out.println("High");
                        break;
                    }
                }
            }
        }
    }
    public static class Low extends Thread
    {
        static int count = 0;
        @Override
        public void run()
        {
            while (true)
            {
                synchronized (ThreadPriorityTest.class)
                {
                    count++;
                    if (count > 10000000)
                    {
                        System.out.println("Low");
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException
    {
        High high = new High();
        Low low = new Low();
        high.setPriority(Thread.MAX_PRIORITY);
        low.setPriority(Thread.MIN_PRIORITY);
        low.start();
        high.start();
    }
}
