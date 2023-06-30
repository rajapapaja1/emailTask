package dev.ante.email.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class CCEmailValidator implements ConstraintValidator<CCEmailValid, String> {
    private static final String EMAIL_PATTERN = "^\\S+@\\S+\\.\\S+$";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return false;
        }

        return Arrays.stream(value.split(",")).allMatch(x -> x.matches(EMAIL_PATTERN));
    }
}
