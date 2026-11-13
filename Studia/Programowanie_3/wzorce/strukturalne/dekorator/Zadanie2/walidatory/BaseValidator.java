package wzorce.strukturalne.dekorator.Zadanie2.walidatory;

/**
 * Jeden z rodzai walidatora.
 */
public class BaseValidator implements Validator {

    @Override
    public boolean validate(String input) {
        return input != null;
    }
}
