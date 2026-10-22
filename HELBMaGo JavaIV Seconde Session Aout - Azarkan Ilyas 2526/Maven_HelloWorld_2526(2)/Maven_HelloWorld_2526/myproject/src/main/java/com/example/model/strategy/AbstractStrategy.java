package com.example.strategy;

import com.example.model.mago.MaGo;
import com.example.model.message.Message;
import com.example.util.Constants;

import java.util.List;

/**
 * Classe abstraite regroupant le comportement commun
 * des stratégies d'optimisation.
 */
public abstract class AbstractStrategy implements MessageSelectionStrategy {

    /**
     * Sélectionne le meilleur message.
     *
     * @param messages messages disponibles
     * @param magos population de MaGos
     * @return meilleur message
     */
    @Override
    public Message selectMessage(List<Message> messages,
                                 List<MaGo> magos) {

        Message bestMessage = messages.get(Constants.ZERO);

        int bestScore =
                computeAverageVariation(bestMessage, magos);

        for (int i = Constants.FIRST_ELEMENT_AFTER_ZERO;
            i < messages.size();
            i++) {

            Message currentMessage = messages.get(i);

            int currentScore =
                    computeAverageVariation(currentMessage, magos);

            if (currentScore > bestScore) {

                bestScore = currentScore;
                bestMessage = currentMessage;

            }

        }

        return bestMessage;

    }

    /**
     * Calcule la variation moyenne pour les MaGos concernés.
     *
     * @param message message étudié
     * @param magos population
     * @return variation moyenne
     */
    private int computeAverageVariation(Message message,
                                        List<MaGo> magos) {

        int total = Constants.ZERO;
        int count = Constants.ZERO;

        for (int i = Constants.ZERO; i < magos.size(); i++) {

            MaGo mago = magos.get(i);

            if (accept(mago)) {

                total += mago.computeStatusVariation(message);
                count++;

            }

        }

        if (count == Constants.ZERO) {
            return Constants.ZERO;
        }

        return total / count;

    }

    /**
     * Indique si un MaGo est concerné par la stratégie.
     *
     * @param mago MaGo à tester
     * @return vrai si concerné
     */
    protected abstract boolean accept(MaGo mago);

}