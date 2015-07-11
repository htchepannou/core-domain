package com.tchepannou.core.validator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EnumContraintValidatorTest  {
    enum Gender {
        MALE, FEMALE
    }

    @Enum(enumClass = Gender.class, message = "gender", ignoreCase = true)
    public String gender;

    private EnumContraintValidator validator = new EnumContraintValidator();

    @Test
    public void testIsValid() throws Exception {
        // Given
        validator.initialize(EnumContraintValidatorTest.class.getField("gender").getAnnotation(Enum.class));

        // Then
        assertThat(validator.isValid("male", null)).isTrue();
        assertThat(validator.isValid("MALE", null)).isTrue();
        assertThat(validator.isValid("???", null)).isFalse();
    }


}
