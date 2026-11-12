package wzorce.dekorator.Zadanie2.dekoratory;

import wzorce.dekorator.Zadanie2.Validator;

abstract class ValidatorDecorator implements Validator {
    protected final Validator opakowanyWalidator;

    public ValidatorDecorator(Validator validator) {
        this.opakowanyWalidator = validator;
    }

    @Override
    public boolean validate(String input) {
        return opakowanyWalidator.validate(input);
    }
}
