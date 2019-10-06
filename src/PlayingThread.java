import java.sql.SQLOutput;

public class PlayingThread extends Thread {
    private SharedBuffer SharedBuffer;

    public PlayingThread(SharedBuffer sharedBuffer) {
        SharedBuffer = sharedBuffer;
    }

    @Override
    public void run() {
        while (true) {
            if(SharedBuffer.getBytesDownloaded() >= 10000) {
                System.out.println("Playing movie...");
                SharedBuffer.readData(10000);
            } else {
                try {
                    System.out.println("Playing Thread is waiting");
                    synchronized (SharedBuffer) {
                        System.out.println("before");
                        this.SharedBuffer.wait();
                        System.out.println("after");
                    }
                    System.out.println("Playing Thread is out");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
