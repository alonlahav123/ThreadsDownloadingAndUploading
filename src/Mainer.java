public class Mainer {
    public static void main(String[] args) {

        SharedBuffer buffer = new SharedBuffer();
        DownloadingThread downloadingThread = new DownloadingThread(buffer);
        PlayingThread playingThread = new PlayingThread(buffer);

        downloadingThread.start();
        playingThread.start();

        try {
            playingThread.join();
            downloadingThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main finished");
    }
}
