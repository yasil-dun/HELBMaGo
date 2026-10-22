package com.example.strategy;

import com.example.model.mago.MaGo;
import com.example.model.message.Message;

import java.util.List;

/**
 * Représente une stratégie de sélection d'un message.
 */
public interface MessageSelectionStrategy {

    /**
     * Sélectionne le prochain message à afficher.
     *
     * @param messages messages encore disponibles
     * @param magos population de MaGos
     * @return message sélectionné
     */
    Message selectMessage(List<Message> messages, List<MaGo> magos);

}