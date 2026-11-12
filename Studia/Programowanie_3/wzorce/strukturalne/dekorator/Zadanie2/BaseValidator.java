package wzorce.strukturalne.dekorator.Zadanie2;

public class BaseValidator implements Validator {

    @Override
    public boolean validate(String input) {
        return input != null;
    }
}
