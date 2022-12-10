package com.example.emailapp;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

@Documented
@Constraint(validatedBy = CustomValidator.class)
@Target({FIELD, PARAMETER})
@Retention(RUNTIME)
public @interface CustomConstraint {
    String message() default "Value is invalid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
