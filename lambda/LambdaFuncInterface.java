package lambda;

@FunctionalInterface
public interface LambdaFuncInterface<T extends Number> {
    /**
     * Performs an operation with two numbers
     * @param param1
     * @param param2
     * @return
     */
    public double operation(T param1, T param2);
}