import multithread.*;
import dosomething.*;


class Test {
    public static void main(String[] args) {
        SharedContainer<Double> sharedContainer = new SharedContainer<>();
        DoSomething<Double> doSomething = new DoSomething<>(sharedContainer);

        CustomThread myThread1 = new CustomThread("thread_1", doSomething);
        CustomThread myThread2 = new CustomThread("thread_2", doSomething);

        try {
            // join allows one thread to wait until another thread completes its execution
            myThread1.start();
            myThread1.join();
            myThread2.start();
            myThread2.join();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

