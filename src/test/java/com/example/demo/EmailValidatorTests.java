package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailValidatorTests {
    
    // private final EmailValidator validator = new EmailValidator();

    @Test
    void validateNoDotCom() {
        assertEquals(validator.validate("email@email"), false);
        assertEquals(validator.validate("a@a"), false);
        assertEquals(validator.validate("email@a."), false);
        assertEquals(validator.validate("email@mail.com."), false);
        assertEquals(validator.validate("juninho@escola.pr.gov."), false);
    }
    
    @Test
    void validateNoAt() {
        assertEquals(validator.validate("email.com"), false);
        assertEquals(validator.validate("juninhoescola.pr.gov.br"), false);
        assertEquals(validator.validate("email@"), false);
        assertEquals(validator.validate("email@.com"), false);
        assertEquals(validator.validate("email.@mail.com"), false);
        assertEquals(validator.validate("email@mail@mail.com"), false);
    }

    @Test
    void validateNoEmail() {
        assertEquals(validator.validate("@mail.com"), false);
        assertEquals(validator.validate("@juninhoescola.pr.gov.br"), false);
    }
    
    @Test
    void validateEmail() {
        assertEquals(validator.validate("email@mail.com"), true);
        assertEquals(validator.validate("a@a.a"), true);
        assertEquals(validator.validate("juninho@escola.pr.gov.br"), true);
    }
    
    @Test
    void validateWrongOrderEmail() {
        assertEquals(validator.validate("email.mail@com"), false);
        assertEquals(validator.validate("email.mail.com@br"), false);
        assertEquals(validator.validate("juninho@escola.pr.gov@br"), false);
    }
}
