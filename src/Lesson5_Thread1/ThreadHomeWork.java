package Lesson5_Thread1;

import java.util.Arrays;

class ThreadHomeWork {
    static final int SIZE = 10000000;
    static final int h = SIZE / 2;
    private static final float[] arrOne = new float[SIZE];
    private static final float[] arrTwo = new float[SIZE];

    public static void main (String[] arg){
        Arrays.fill(arrOne,1);
        Arrays.fill(arrTwo,1);

        long a = System.currentTimeMillis();
        methodWithoutThread(arrOne);
        System.out.println("Method execution time with one thread: " + (System.currentTimeMillis() - a));

        a = System.currentTimeMillis();
        methodWithThread(arrTwo);
        System.out.println("Method execution time with two thread: " + (System.currentTimeMillis() - a));

        if (Arrays.equals(arrOne, arrTwo)){
            System.out.println("Arrays are equals");
        } else System.out.println("Arrays are not equals");

    }

    public static void methodWithoutThread(float[] arrOne) {
        for (int i = 0; i < arrOne.length; i++) {
            arrOne[i] = (float) (arrOne[i] *
                    Math.sin(0.2f + i / 5) *
                    Math.cos (0.2f + i / 5) *
                    Math.cos (0.4f + i / 2));
        }
    }

    public static void methodWithThread(float[] arr) {
        float[] arr1 = new float[h];
        float[] arr2 = new float[h];

        System.arraycopy(arr, 0, arr1,0, h);
        System.arraycopy(arr, h, arr2,0, h);

        MyThread m1 = new MyThread("Thread #1", arr1, 0);
        MyThread m2 = new MyThread("Thread #2",arr2, h);
        try {
            m1.join();
            m2.join();
        } catch (InterruptedException e){
             e.getStackTrace();
        }
        System.arraycopy(arr1, 0, arr,0, h);
        System.arraycopy(arr2, 0, arr, h, h);
    }
}