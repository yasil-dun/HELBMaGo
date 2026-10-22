package com.example;

import com.example.util.SpamValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests unitaires de SpamValidator.
 */
public class SpamValidatorTest {

    /**
     * Messages utilisés pour les tests.
     */
    private static final String HTTP_MESSAGE = "http://example.com";
    private static final String NO_LETTER_MESSAGE = "12345 !!!";
    private static final String NORMAL_MESSAGE = "Hello world";

    /**
     * Validateur testé.
     */
    private final SpamValidator validator =
            new SpamValidator();

    /**
     * Vérifie qu'un lien http est considéré comme un spam.
     */
    @Test
    public void testHttpMessageIsSpam() {

        assertTrue(
                validator.isSpam(
                        HTTP_MESSAGE));

    }

    /**
     * Vérifie qu'un message sans lettre est considéré comme un spam.
     */
    @Test
    public void testMessageWithoutLetterIsSpam() {

        assertTrue(
                validator.isSpam(
                        NO_LETTER_MESSAGE));

    }

    /**
     * Vérifie qu'un message normal n'est pas considéré comme un spam.
     */
    @Test
    public void testNormalMessageIsNotSpam() {

        assertFalse(
                validator.isSpam(
                        NORMAL_MESSAGE));

    }

}