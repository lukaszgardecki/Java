package com.example.app.constraint;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SerialNoValidator implements ConstraintValidator<SerialNo, String> {
    private String startsWith;
    private int codeLength;

    @Override
    public void initialize(SerialNo annotation) {
        startsWith = annotation.startsWith();
        codeLength = annotation.codeLength();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return checkPrefix(value) && checkCodeLength(value) && checkCode(value);
    }

    private boolean checkPrefix(String serialNumber) {
        return serialNumber.startsWith(startsWith);
    }

    private boolean checkCodeLength(String serialNumber) {
        int prefixLength = startsWith.length();
        int serialNumberLength = serialNumber.length();
        return serialNumberLength - prefixLength == codeLength;
    }

    private boolean checkCode(String serialNumber) {
        int prefixLength = startsWith.length();
        char[] serlaNumberCode = serialNumber.substring(prefixLength).toCharArray();
        for (char c : serlaNumberCode) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
}
