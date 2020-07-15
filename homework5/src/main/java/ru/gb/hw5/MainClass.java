package ru.gb.hw5;

public class MainClass {
    private static final int size = 10_000_000;
    private static final double arrayFiller = 1;

    private static void fillArray(double[] arr, double filler){
        int s = arr.length;
        for(int i = 0; i < s; i++){
            arr[i] = filler;
        }
    }

    private static long calcArray(double[] arr, int prefix){
        long startTime = System.currentTimeMillis();
        int s = arr.length;
        for(int i = 0; i < s; i++){
            double workIndex = i + prefix;
            arr[i] = arr[i] * Math.sin(0.2f + workIndex / 5) * Math.cos(0.2f + workIndex / 5) * Math.cos(0.4f + workIndex / 2);
        }
        return System.currentTimeMillis() - startTime;
    }

    private static void joinThreads(Thread[] threads){
        try {
            for (Thread t : threads) {
                t.join();
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    private static long multiThreadCalc(double[] arr, int threadNumber){
        if (threadNumber < 2) {
            return  calcArray(arr, 0);
        }

        long startTime = System.currentTimeMillis();

        double[][] arrays = new double[threadNumber][];

        //the last array can have different size than others
        int size = arr.length / threadNumber;
        for(int i = 0; i < threadNumber - 1; i++){
            arrays[i] = new double[size];
        }
        arrays[threadNumber - 1] = new double[arr.length - size * (threadNumber - 1)];

        Thread[] splitters = new Thread[threadNumber];
        Thread[] workers = new Thread[threadNumber];
        Thread[] joiners = new Thread[threadNumber];

        for(int i = 0, stPos = 0; i < threadNumber; stPos += arrays[i++].length){
            int n = i;  // to be possible to use in lambda
            int startPos = stPos;
            splitters[i] = new Thread(() ->
                    System.arraycopy(arr, startPos, arrays[n], 0, arrays[n].length)
            );
            splitters[i].start();
        }

        joinThreads(splitters);

        for(int i = 0, stPos = 0; i < threadNumber; stPos += arrays[i++].length){
            int n = i;  // to be possible to use in lambda
            int prefix = stPos;
            workers[i] = new Thread(() ->
                    calcArray(arrays[n], prefix)
            );
            workers[i].start();
        }

        joinThreads(workers);

        for(int i = 0, stPos = 0; i < threadNumber; stPos += arrays[i++].length){
            int n = i;  // to be possible to use in lambda
            int destPos = stPos;
            joiners[i] = new Thread(() ->
                    System.arraycopy(arrays[n], 0, arr, destPos, arrays[n].length)
            );
            joiners[i].start();
        }

        joinThreads(joiners);
        return System.currentTimeMillis() - startTime;
    }

    private static void testMultithread(double[] arr, int threadNumber){
        fillArray(arr, arrayFiller);

        System.out.printf("Start %s-thread array calculation%n", threadNumber < 2 ? "single" : threadNumber);
        long millis = multiThreadCalc(arr, threadNumber);
        System.out.printf("%s-thread finished in %d milliseconds%n%n", threadNumber < 2 ? "Single" : threadNumber, millis);
    }

    public static void main(String[] args) {
        double[] arr = new double[size];

        testMultithread(arr, 1);
        testMultithread(arr, 2);
        testMultithread(arr, 4);
    }

}
