package com.example.util;

/**
 * Vérifie si un message est considéré comme un spam.
 */
public class SpamValidator {

    /**
     * Détermine si un message est un spam.
     *
     * Un message est considéré comme un spam si :
     * - il contient "http://"
     * - il ne contient aucune lettre.
     *
     * @param text texte à vérifier
     * @return vrai si le message est un spam
     */
    public boolean isSpam(String text) {

        if (text.contains(Constants.HTTP_PREFIX)) {
            return true;
        }

        for (int i = 0; i < text.length(); i++) {

            if (Character.isLetter(text.charAt(i))) {
                return false;
            }

        }

        return true;
    }

}