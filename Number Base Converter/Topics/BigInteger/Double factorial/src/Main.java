import java.math.BigInteger;

class DoubleFactorial {
    public static BigInteger calcDoubleFactorial(int n) {
        if (n == 0 || n == 1) {
            return BigInteger.ONE;
        }
        return new BigInteger(String.valueOf(n)).multiply(calcDoubleFactorial(n - 2));
    }
}