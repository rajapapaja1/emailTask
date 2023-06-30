package dev.ante.email.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
@Constraint(validatedBy = {CCEmailValidator.class })
public @interface CCEmailValid {

    String message() default "Invalid cc email address";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
