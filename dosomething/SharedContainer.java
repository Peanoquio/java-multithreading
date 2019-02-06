package dosomething;

/**
 * The shared container to be accessed by threads
 * @param <T>
 */
public class SharedContainer<T> {
    // this will be written to and read from the main memory (instead of the CPU cache) when accessed by threads
    // but we won't really need this if we use synchronize in Thread.run()
    private volatile T value;

    /**
     * Get the value
     * @return
     */
    public T getValue() {
        return this.value;
    }

    /**
     * Set the value
     * @param value
     */
    public void setValue(T value) {
        this.value = value;
    }

} // end class