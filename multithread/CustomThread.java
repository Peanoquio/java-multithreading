package multithread;

import dosomething.DoSomething;


/**
 * The custom thread class to support multi-threading
 */
public class CustomThread extends Thread {
    private Thread thread;
    private String threadName;
    private DoSomething<? extends Number> doSomething;

    /**
     * The constructor
     * @param name
     * @param doSomething
     */
    public CustomThread(String name, DoSomething<? extends Number> doSomething) {
        this.threadName = name;
        this.doSomething = doSomething;
    }

    /**
     * Run/execute the thread
     */
    @Override
    public void run() {
        // synchronization of the process (when multi-threading)
        synchronized(this.doSomething) {
            for (int i = 0; i < 4; ++i) {
                this.doSomething.squareStoredNumber();
                System.out.println("stored value after calling squareStoredNumber: " + this.doSomething.getStoredValue());
            } // end loop
        }
        System.out.println("Thread " + this.threadName + " is exiting");
    }

    /**
     * Start the thread
     */
    @Override
    public void start() {
        if (this.thread == null) {
            System.out.println("Thread " + this.threadName + " is starting");
            // create the actual thread
            this.thread = new Thread(this, this.threadName);
            this.thread.start();
        }
    }

} // end class