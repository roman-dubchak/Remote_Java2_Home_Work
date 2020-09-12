package Lesson5_Thread1;

public class MyThread extends Thread{
    private final float[] arr;
    private int offset;

    public MyThread (String name, float [] arr, int offset){
        super(name);
        this.arr = arr;
        this.offset = offset;
        start();
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] *
                    Math.sin(0.2f + (i + offset) / 5) *
                    Math.cos (0.2f + (i + offset) / 5) *
                    Math.cos (0.4f + (i + offset) / 2));
        }
        System.out.println(Thread.currentThread().getName() + " stopped");
    }
}
