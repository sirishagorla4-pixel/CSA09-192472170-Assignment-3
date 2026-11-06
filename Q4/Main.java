class ScannerStation extends Thread {
    private String station;
    ScannerStation(String station) {
        this.station = station;
    }
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(
                    station + " scanned script " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(
                station + " completed.");
    }
}
class ScannerTask implements Runnable {
    private String station;
    ScannerTask(String station) {
        this.station = station;
    }
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(
                    station + " scanned script " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(
                station + " completed.");
    }
}
public class Main {
    public static void main(String[] args)
            throws InterruptedException {
        System.out.println(
                "Using Thread class:");
        Thread t1 =
                new ScannerStation("Station 1");
        Thread t2 =
                new ScannerStation("Station 2");
        Thread t3 =
                new ScannerStation("Station 3");
        Thread t4 =
                new ScannerStation("Station 4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        System.out.println(
                "Station 1 alive: " + t1.isAlive());
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        System.out.println(
                "\nUsing Runnable:");
        Thread r1 =
                new Thread(
                        new ScannerTask("Station 1"));
        Thread r2 =
                new Thread(
                        new ScannerTask("Station 2"));
        Thread r3 =
                new Thread(
                        new ScannerTask("Station 3"));
        Thread r4 =
                new Thread(
                        new ScannerTask("Station 4"));
        r1.start();
        r2.start();
        r3.start();
        r4.start();
        r1.join();
        r2.join();
        r3.join();
        r4.join();
        System.out.println(
                "\nAll scanner stations completed.");
    }
}
