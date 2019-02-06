package dosomething;

import lambda.*;
import dosomething.*;


public class DoSomething<T extends Number> {
    private SharedContainer<T> sharedContainer;

    /**
     * The constructor
     * @param sharedContainer
     */
    public DoSomething(SharedContainer<T> sharedContainer) {
        this.sharedContainer = sharedContainer;
    }

    /**
     * Perform a lambda operation on the numbers
     * @param param1
     * @param param2
     * @param lambdaFunc
     * @return
     */
    protected static <T extends Number> double ProcessNumbers(T param1, T param2, LambdaFuncInterface<T> lambdaFunc) {
        return lambdaFunc.operation(param1, param2);
    }

    /**
     * Square the value in the container (power of 2)
     */
    @SuppressWarnings("unchecked")
    public void squareStoredNumber() {
        if (this.sharedContainer.getValue() == null) {
            // this will cause the warning (unchecked cast)
            this.sharedContainer.setValue((T)new Double(1.0));
        } else {
            // create the lambda function
            LambdaFuncInterface<T> plusOperation = (param1, param2) -> (param1.doubleValue() + param2.doubleValue());
            double newValue = DoSomething.ProcessNumbers(this.sharedContainer.getValue(), this.sharedContainer.getValue(), plusOperation);
            // this will cause the warning (unchecked cast)
            this.sharedContainer.setValue((T)new Double(newValue));
        }
    }

    /**
     * Get the stored value
     * @return
     */
    public T getStoredValue() {
        return this.sharedContainer.getValue();
    }

} // end class