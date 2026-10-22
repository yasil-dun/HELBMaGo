package com.example.model.mago;

import com.example.model.message.Message;
import com.example.util.Constants;

/**
 * Représente un MaGo de type Square.
 * Son bonheur dépend du ratio voyelles / consonnes.
 */
public class SquareMaGo extends MaGo {

    /**
     * Construit un SquareMaGo.
     */
    public SquareMaGo() {
        super();
    }

    @Override
    public MaGoType getType() {

        return MaGoType.SQUARE;

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

        int vowels = countVowels(text);

        int consonants = countConsonants(text);

        int variation =
                Constants.MAX_STATUS
                * Constants.SQUARE_CHANGE_PERCENT
                / Constants.ONE_HUNDRED_PERCENT;

        if (consonants == Constants.ZERO) {

            return computeRealVariation(-variation);

        }

        double ratio = (double) vowels / consonants;

        if (ratio > Constants.SQUARE_RATIO_LIMIT) {

            return computeRealVariation(variation);

        }

        return computeRealVariation(-variation);

    }

    /**
     * Compte le nombre de voyelles.
     *
     * @param text texte à analyser
     * @return nombre de voyelles
     */
    private int countVowels(String text) {

        int count = Constants.ZERO;

        for (int i = Constants.ZERO; i < text.length(); i++) {

            if (Constants.VOWELS.indexOf(text.charAt(i))
                    != Constants.NOT_FOUND) {

                count++;

            }

        }

        return count;

    }

    /**
     * Compte le nombre de consonnes.
     *
     * @param text texte à analyser
     * @return nombre de consonnes
     */
    private int countConsonants(String text) {

        int count = Constants.ZERO;

        for (int i = Constants.ZERO; i < text.length(); i++) {

            char character = text.charAt(i);

            if (Character.isLetter(character)
                    && Constants.VOWELS.indexOf(character)
                    == Constants.NOT_FOUND) {

                count++;

            }

        }

        return count;

    }

}