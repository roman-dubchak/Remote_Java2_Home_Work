package Lesson5_Thread1;

import java.util.Arrays;

class ThreadHomeWork {
    static final int SIZE = 10000000;
    static final int h = SIZE / 2;

    public static void main (String[] arg){
        methodWithoutThread();
        methodWithThread();
    }

    public static void arrUnit (float[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
    }

    public static void methodWithoutThread() {
        float[] arr = new float[SIZE];
        arrUnit(arr);

        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
          arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos (0.2f + i / 5) * Math.cos (0.4f + i / 2));
        }
        System.out.println("Method execution time with one thread: " + (System.currentTimeMillis() - a));
    }

    public static void methodWithThread() {
        float[] arr = new float[SIZE];
        arrUnit(arr);

        long a = System.currentTimeMillis();

        float[] arr1 = new float[h];
        float[] arr2 = new float[h];

        System.arraycopy(arr, 0, arr1,0, h);
        System.arraycopy(arr, h, arr2,0, h);

        // var 1
        threadTwoArr(arr1);
        threadTwoArr(arr2);

        System.arraycopy(arr1, 0, arr,0, h);
        System.arraycopy(arr2, 0, arr, h, h);

        System.out.println("Method execution time with two thread (method Runnable) var 1: " + (System.currentTimeMillis() - a));

        // var2
        long b = System.currentTimeMillis();
        float[] arr3 = new float[h];
        float[] arr4 = new float[h];
//        threadTwoArr2 (arr3, arr4);

        MyThread m1 = new MyThread("Thread #1", arr3);
        m1.start();
        try {
            m1.join();
        } catch (InterruptedException e){
             e.getStackTrace();
        }

        MyThread m2 = new MyThread("Thread #2",arr4);
        m2.start();
        try {
            m2.join();
        } catch (InterruptedException e){
            e.getStackTrace();
        }

        System.out.println(Arrays.equals(arr, arr1));

        System.arraycopy(arr3, 0, arr,0, h);
        System.arraycopy(arr4, 0, arr, h, h);

        System.out.println("Method execution time with two thread (class Thread) var 2: " + (System.currentTimeMillis() - b));

    }

    public static void threadTwoArr(float[] arr) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "1 start");
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos (0.2f + i / 5) * Math.cos (0.4f + i / 2));
                }
                System.out.println(Thread.currentThread().getName() + "1 stopped");
            }
        };
        new Thread (r).start();
    }

    public static void threadTwoArr2(float[] arr1, float[] arr2) {

        Runnable r = new Runnable() {
            @Override
            public void run() {
                arrFill(arr1, arr2);
            }
            };
        new Thread (r, "Thread #1").start();
        try {
            new Thread(r, "Thread #1").join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Thread #1 stop");
    }

    private static synchronized void arrFill (float[] arr1, float[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = (float) (arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = (float) (arr2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}