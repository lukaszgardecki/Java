package BigNum;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigNum {
    public static void main(String[] args) {
        int i;
        long l;
        double d;

        i = 1000000000;
        l = 1000000000000000000L;
        d = 1e308;


        BigInteger bi1, bi2, bi3, bi4;
        BigDecimal bd;

        //wartoœci musz¹ byæ w cudzys³owie:
        bi1 = new BigInteger("1000000245896023450920934586702800");
        bi2 = new BigInteger("1234569263487563457987304958603");

        System.out.println(bi1.multiply(bi2));
        System.out.println(bi1.add(bi2));
        System.out.println(bi1.subtract(bi2));
        System.out.println(bi1.divide(bi2));

        //przekonwertowanie liczby na BigInteger
        bi3 = BigInteger.valueOf(l);
        bi4 = BigInteger.valueOf(i);




    }
}
