package wzorce.strukturalne.dekorator.Zadanie2.dekoratory;

import wzorce.strukturalne.dekorator.Zadanie2.walidatory.Validator;

public class NotEmptyValidator extends ValidatorDecorator {

    public NotEmptyValidator(Validator validator) {
        super(validator);
    }

    @Override
    public boolean validate(String input) {
        return super.validate(input) && !input.isBlank();
    }
}
