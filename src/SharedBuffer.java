public class SharedBuffer {
    public int num;

    public SharedBuffer() {
        this.num = 0;
    }

    public void putData(int numOfBytes) {
        synchronized (this) {
            this.num += numOfBytes;
            System.out.println("Size of buffer: " + this.num);
        }
    }

    public void readData(int numOfBytes) {
        synchronized (this) {
            this.num -= numOfBytes;
        }
    }

    public int getBytesDownloaded() {
        synchronized (this) {
            return num;
        }
    }

}
