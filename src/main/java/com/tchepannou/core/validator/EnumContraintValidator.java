package com.tchepannou.core.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EnumContraintValidator implements ConstraintValidator<Enum, String> {
    private Enum annotation;

    @Override
    public void initialize(final Enum annotation)
    {
        this.annotation = annotation;
    }

    @Override
    public boolean isValid(final String value, final ConstraintValidatorContext constraintValidatorContext) {
        if (value == null){
            return true;
        }

        final boolean result = false;
        final Object[] enumValues = this.annotation.enumClass().getEnumConstants();
        for(Object enumValue : enumValues) {
            final String str = enumValue.toString();
            if(str.equalsIgnoreCase(value)) {
                return true;
            }
        }

        return result;
    }
}
