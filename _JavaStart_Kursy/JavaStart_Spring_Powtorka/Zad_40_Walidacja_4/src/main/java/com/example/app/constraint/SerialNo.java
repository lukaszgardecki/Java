package com.example.app.constraint;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = SerialNoValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SerialNo {
    String message() default "{com.example.app.constraint.SerialNo.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    int codeLength();
    String startsWith();
}
