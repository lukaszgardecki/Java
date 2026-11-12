package wzorce.strukturalne.dekorator.Zadanie2;

import wzorce.strukturalne.dekorator.Zadanie2.dekoratory.MinLengthValidator;
import wzorce.strukturalne.dekorator.Zadanie2.dekoratory.NotEmptyValidator;

/**
 * Zadanie 2: system walidacji pól formularza
 *
 * - zaimplementuj system walidacji danych wejściowych (np. hasła, e-maila, loginu), w którym każda reguła walidacji (np. "niepuste", "minimum 8 znaków", "zawiera cyfrę", "zawiera znak specjalny") jest osobnym dekoratorem
 * - Wymagania:
 *      - interfejs Validator z metodą boolean validate(String input)
 *      - bazowy walidator (BaseValidator)
 *      - dekoratorzy: NotEmptyValidator, MinLengthValidator, DigitValidator, SpecialCharValidator
 *      - możliwość dynamicznego łączenia reguł
 * - Rozszerzenia:
 *      - dodaj dekorator LoggingValidator, który wypisuje, które reguły zostały spełnione
 *      - dodaj dekorator CachingValidator, który zapamiętuje wyniki walidacji dla tych samych danych
 */
public class Zadanie2 {
    public static void main(String[] args) {
        Validator validator = new MinLengthValidator(new NotEmptyValidator(new BaseValidator()), 8);
        String input1 = "admin123";
        String input2 = "";
        System.out.println("Input1 valid: " + validator.validate(input1)); // true
        System.out.println("Input2 valid: " + validator.validate(input2)); // false
    }
}
