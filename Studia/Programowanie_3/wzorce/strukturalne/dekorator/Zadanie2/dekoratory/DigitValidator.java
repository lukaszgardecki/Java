package wzorce.strukturalne.dekorator.Zadanie2.dekoratory;

import wzorce.strukturalne.dekorator.Zadanie2.Validator;

public class DigitValidator extends  ValidatorDecorator {

    public DigitValidator(Validator validator) {
        super(validator);
    }

    @Override
    public boolean validate(String input) {
        return super.validate(input) && containsDigit(input);
    }

    private boolean containsDigit(String input) {
        char[] chars = input.toCharArray();
        for (char aChar : chars) {
            if (Character.isDigit(aChar)) { return true; }
        }
        return false;
    }
}
