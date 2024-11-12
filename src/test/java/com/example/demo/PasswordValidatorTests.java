package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PasswordValidatorTests {

	// private final PassValidator validator = new PassValidator();

	@Test
	void validateSmallPass() {
		assertEquals(validator.validate("Abc123"), false);
		assertEquals(validator.validate("Abcde123456"), false);
		assertEquals(validator.validate("Aa1#"), false);
		assertEquals(validator.validate("123"), false);
		assertEquals(validator.validate("admin"), false);
	}
	
	@Test
	void validateNoNumberPass() {
		assertEquals(validator.validate("Aaaaaaaaaaaaaaaaaaaaa"), false);
		assertEquals(validator.validate("#############"), false);
	}

	@Test
	void validateNoLetterPass() {
		assertEquals(validator.validate("1234567890123"), false);
		assertEquals(validator.validate("#23456789012#"), false);
	}
	
	@Test
	void validateNoUppercasePass() {
		assertEquals(validator.validate("1234567abcdef"), false);
	}
	
	@Test
	void validateNoLowercasePass() {
		assertEquals(validator.validate("1234567ABCDEF"), false);
	}
	
	@Test
	void validatePass() {
		assertEquals(validator.validate("ABCdef123456"), true);
		assertEquals(validator.validate("ABCdef123456"), true);
		assertEquals(validator.validate("ABCdef123456###"), true);
	}
}
