package com.example.model.message;

import com.example.model.mago.MaGo;
import com.example.strategy.MessageSelectionStrategy;
import com.example.util.MessageReader;

import java.util.ArrayList;
import java.util.List;

/**
 * Gère les messages disponibles dans l'application.
 */
public class MessageManager {

    /**
     * Tous les messages valides.
     */
    private final List<Message> allMessages;

    /**
     * Messages encore disponibles.
     */
    private final List<Message> availableMessages;

    /**
     * Construit un gestionnaire de messages.
     */
    public MessageManager() {

        MessageReader reader = new MessageReader();

        allMessages = reader.readMessages();

        availableMessages = new ArrayList<>(allMessages);

    }

    /**
     * Retourne les messages disponibles.
     *
     * @return liste des messages disponibles
     */
    public List<Message> getAvailableMessages() {

        return availableMessages;

    }

    /**
     * Sélectionne le prochain message selon une stratégie.
     * Le message choisi est retiré de la liste des messages
     * disponibles. Lorsque tous les messages ont été utilisés,
     * la liste est automatiquement rechargée.
     *
     * @param strategy stratégie utilisée
     * @param magos population de MaGos
     * @return message sélectionné
     */
    public Message getNextMessage(
            MessageSelectionStrategy strategy,
            List<MaGo> magos) {

        /*
         * Si tous les messages ont déjà été utilisés,
         * on recharge la liste complète avant la sélection.
         */
        if (availableMessages.isEmpty()) {

            resetMessages();

        }

        Message message =
                strategy.selectMessage(
                        availableMessages,
                        magos);

        availableMessages.remove(message);

        return message;

    }

    /**
     * Recharge tous les messages disponibles.
     */
    private void resetMessages() {

        availableMessages.clear();

        availableMessages.addAll(allMessages);

    }

}