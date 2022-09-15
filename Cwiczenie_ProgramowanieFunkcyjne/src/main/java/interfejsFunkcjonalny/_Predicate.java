package interfejsFunkcjonalny;

import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        // Normal java functions:
        System.out.println("Normal java functions:");
        System.out.println(isPhoneNumberValid("07000000000"));
        System.out.println(isPhoneNumberValid("0700000000"));
        System.out.println(isPhoneNumberValid("09003456600"));

        // Predicate
        System.out.println("Predicate:");
        System.out.println(isPhoneNumberValidPredicate.test("07000000000"));
        System.out.println(isPhoneNumberValidPredicate.test("0700000000"));
        System.out.println(isPhoneNumberValidPredicate.test("09003456600"));

        System.out.println("Is phone number valid and contains number 3 = "
                        + isPhoneNumberValidPredicate.and(containsNumber3).test("09003456600")
        );

        System.out.println("Is phone number valid and contains number 3 = "
                + isPhoneNumberValidPredicate.and(containsNumber3).test("07000000003")
        );


        //BiPredicate


    }

    static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }

    static Predicate<String> isPhoneNumberValidPredicate =
            phoneNumber -> phoneNumber.startsWith("07") && phoneNumber.length() == 11;

    static Predicate<String> containsNumber3 =
            phoneNumber -> phoneNumber.contains("3");
}
