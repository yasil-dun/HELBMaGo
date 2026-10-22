package com.example.strategy;

import com.example.model.mago.MaGo;
import com.example.model.message.Message;

import java.util.List;
import java.util.Random;

/**
 * Sélectionne un message aléatoirement.
 */
public class RandomStrategy implements MessageSelectionStrategy {

    /**
     * Générateur de nombres aléatoires.
     */
    private final Random random;

    /**
     * Construit la stratégie Random.
     */
    public RandomStrategy() {

        random = new Random();

    }

    /**
     * Sélectionne un message au hasard.
     *
     * @param messages messages disponibles
     * @param magos population de MaGos
     * @return message choisi
     */
    @Override
    public Message selectMessage(List<Message> messages,
                                 List<MaGo> magos) {

        int index = random.nextInt(messages.size());

        return messages.get(index);

    }

}