public class DownloadingThread extends Thread{
    private SharedBuffer SharedBuffer;

    public DownloadingThread(SharedBuffer SharedBuffer) {
        this.SharedBuffer = SharedBuffer;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Thread is downloading...");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Thread completed downloading");
            this.SharedBuffer.putData(500);

            if (this.SharedBuffer.getBytesDownloaded() >= 10000) {
                synchronized (this.SharedBuffer) {
                    SharedBuffer.notifyAll();
                }
            }
        }
    }
}
