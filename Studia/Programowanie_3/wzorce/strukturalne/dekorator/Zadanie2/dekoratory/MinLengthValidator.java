package wzorce.strukturalne.dekorator.Zadanie2.dekoratory;

import wzorce.strukturalne.dekorator.Zadanie2.Validator;

public class MinLengthValidator extends ValidatorDecorator {
    private final int minLength;

    public MinLengthValidator(Validator validator, int minLength) {
        super(validator);
        this.minLength = minLength;
    }

    @Override
    public boolean validate(String input) {
        return super.validate(input) && input.length() >= minLength;
    }
}
