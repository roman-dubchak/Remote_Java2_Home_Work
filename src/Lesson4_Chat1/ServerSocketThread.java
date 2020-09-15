package Lesson4_Chat1;

public class ServerSocketThread extends Thread{
    private final int port;

    public ServerSocketThread(String name, int port) {
        super(name);
        this.port = port;
        start();
    }

    @Override
    public void run() {
        System.out.println("Server started");
        while (!isInterrupted()) {
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                interrupt();
            }
            System.out.println(getName() + " is running on port " + port);
        }
        System.out.println("Server stopped");
    }
}
