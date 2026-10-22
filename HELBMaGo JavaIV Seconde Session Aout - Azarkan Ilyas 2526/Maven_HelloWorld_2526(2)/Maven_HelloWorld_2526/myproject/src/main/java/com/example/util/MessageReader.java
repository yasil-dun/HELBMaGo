package com.example.util;

import com.example.model.message.Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Responsable de la lecture du fichier contenant les messages.
 */
public class MessageReader {

    /**
     * Validateur de spam.
     */
    private final SpamValidator validator;

    /**
     * Construit un lecteur de messages.
     */
    public MessageReader() {
        this.validator = new SpamValidator();
    }

    /**
     * Lit tous les messages présents dans le fichier.
     *
     * @return liste des messages valides
     */
    public List<Message> readMessages() {

        List<Message> messages = new ArrayList<>();

        InputStream inputStream = getClass()
                .getClassLoader()
                .getResourceAsStream(Constants.MESSAGE_FILE);

        if (inputStream == null) {
            return messages;
        }

        try (BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(inputStream))) {

            String line;

            while ((line = reader.readLine()) != null) {

                if (!validator.isSpam(line)) {

                    messages.add(
                            new Message(
                                    line,
                                    false));

                }

            }

        } catch (IOException exception) {

            throw new IllegalStateException(
                    "Impossible de lire le fichier des messages.",
                    exception);

        }

        return messages;

    }

}