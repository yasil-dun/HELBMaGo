package com.example.model.mago;

import com.example.model.message.Message;
import com.example.util.Constants;

/**
 * Représente un MaGo de type Circle.
 * Son bonheur dépend de la ponctuation présente dans le message.
 */
public class CircleMaGo extends MaGo {

    /**
     * Construit un CircleMaGo.
     */
    public CircleMaGo() {
        super();
    }

    @Override
    public MaGoType getType() {

        return MaGoType.CIRCLE;

    }
    
    /**
     * Calcule la variation de bonheur provoquée par un message.
     *
     * @param message message reçu
     * @return variation réellement appliquée
     */
    @Override
    public int computeStatusVariation(Message message) {

        String text = message.getText();

        int punctuationCount = countPositivePunctuation(text);

        int variation;

        if (punctuationCount > Constants.ZERO) {

            int increase =
                    Constants.MAX_STATUS
                    * Constants.CIRCLE_INCREASE_PERCENT
                    / Constants.ONE_HUNDRED_PERCENT;

            variation = punctuationCount * increase;

        } else {

            int decrease =
                    Constants.MAX_STATUS
                    * Constants.CIRCLE_DECREASE_PERCENT
                    / Constants.ONE_HUNDRED_PERCENT;

            variation = -decrease;

        }

        return computeRealVariation(variation);

    }


    /**
     * Compte le nombre de caractères '!' et '?'.
     *
     * @param text texte à analyser
     * @return nombre de ponctuations positives
     */
    private int countPositivePunctuation(String text) {

        int count = Constants.ZERO;

        for (int i = Constants.ZERO; i < text.length(); i++) {

            char character = text.charAt(i);

            if (character == Constants.EXCLAMATION_MARK
                    || character == Constants.QUESTION_MARK) {

                count++;

            }

        }

        return count;

    }

}