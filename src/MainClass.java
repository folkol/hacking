
public class MainClass {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override public void run() {
                System.out.println("Hello world! From: " + Thread.currentThread().getName());
            }
        }).start();
        new Thread(new Runnable() {
            @Override public void run() {
                System.out.println("Hello world! From: " + Thread.currentThread().getName());
            }
        }).start();
        System.out.println("Hello world! From: " + Thread.currentThread().getName());
    }
}
