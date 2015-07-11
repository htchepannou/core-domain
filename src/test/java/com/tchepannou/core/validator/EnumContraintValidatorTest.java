package com.tchepannou.core.validator;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EnumContraintValidatorTest  {
    enum Gender {
        MALE, FEMALE
    }

    @Enum(enumClass = Gender.class, message = "gender", ignoreCase = true)
    public String gender;

    private EnumContraintValidator validator = new EnumContraintValidator();

    @Before
    public void setUp () throws Exception{
        validator = new EnumContraintValidator();
        validator.initialize(EnumContraintValidatorTest.class.getField("gender").getAnnotation(Enum.class));
    }

    @Test
    public void testIsValid() throws Exception {
        // Then
        assertThat(validator.isValid("male", null)).isTrue();
    }

    @Test
    public void testIsValid_ignoreCase() throws Exception {
        // Then
        assertThat(validator.isValid("MaLe", null)).isTrue();
    }

    @Test
    public void testIsValid_null() throws Exception {
        assertThat(validator.isValid(null, null)).isTrue();
    }


    @Test
    public void testIsValid_badValue() throws Exception {
        assertThat(validator.isValid("???", null)).isFalse();
    }
}
