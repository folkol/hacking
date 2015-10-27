public class ConsumeInOrder extends Thread {

    public ConsumeInOrder(Runnable r) {
        super(r);
    }

    public static void main(String[] args) {
        new ConsumeInOrder(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world");
            }
        }).start();
    }

}
