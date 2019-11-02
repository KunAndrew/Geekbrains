package lesson5;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;

public class HomeWork {
    public static void main(String[] args) {
        float[] arr1 = consistentlyMethod();
        float[] arr2 = parallelMethod();
        testMethod(arr1, arr2);
    }

    public static float[] consistentlyMethod() {
        final int SIZE = 10000000;
        float[] arr = new float[SIZE];
        for (float i : arr) {
            i = 1;
        }
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Время работы " + (System.currentTimeMillis() - a));
        return arr;
    }

    public static float[] parallelMethod() {
        final int SIZE = 10000000;
        final int HALF = SIZE / 2;
        float[] arr = new float[SIZE];
        for (float i : arr) {
            i = 1;
        }
        long a = System.currentTimeMillis();
        float[] a1 = new float[HALF];
        float[] a2 = new float[HALF];
        System.arraycopy(arr, 0, a1, 0, HALF);
        System.arraycopy(arr, HALF, a2, 0, HALF);
        Thread thread1 = new Thread(new MyRunnableClass(a1, 0));
        Thread thread2 = new Thread(new MyRunnableClass(a2, HALF));
        thread1.start();
        thread2.start();
        System.arraycopy(a1, 0, arr, 0, HALF);
        System.arraycopy(a2, 0, arr, HALF, HALF);
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Время работы паралельно " + (System.currentTimeMillis() - a));
        return arr;
    }

    public static void testMethod(float[] a1, float[] a2) {
        boolean noError = true;
        for (int i = 0; i < a1.length; i++) {
            if (!(Math.abs(a1[i] - a2[i]) < 0.000001f)) {
                System.out.println("не равны " + i);
                noError = false;
                break;
            }
        }
        if (noError) System.out.println("Результаты равны!");
    }

    static class MyRunnableClass implements Runnable {
        private float[] arr;
        private int interval;

        public MyRunnableClass(float[] arr, int interval) {
            this.arr = arr;
            this.interval = interval;
        }

        @Override
        public void run() {
            method(arr, interval);
        }

        public float[] method(float[] arr, int interval) {
            for (int i = 0 + interval; i < arr.length; i++) {
                arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            return arr;
        }
    }
}
