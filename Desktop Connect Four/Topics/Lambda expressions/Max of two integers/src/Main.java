import java.util.function.IntBinaryOperator;

class Operator {

    public static IntBinaryOperator binaryOperator = (a, b) -> {
        return a > b ? a : b;
    };
}