package wzorce.strukturalne.dekorator.Zadanie2.dekoratory;

import wzorce.strukturalne.dekorator.Zadanie2.Validator;

public class SpecialCharValidator extends ValidatorDecorator {

    public SpecialCharValidator(Validator validator) {
        super(validator);
    }

    @Override
    public boolean validate(String input) {
        return super.validate(input) && containsSpecialChar(input);
    }

    private boolean containsSpecialChar(String input) {
        char[] specials = { '!', '@', '#', '$', '%', '^', '&', '*', '?' };
        char[] chars = input.toCharArray();
        for (char c : chars) {
            for (char special : specials) {
                if (c == special) return true;
            }
        }
        return false;
    }
}
