package com.example.model.message;

/**
 * Représente un message valide pouvant être affiché dans l'application.
 */
public class Message {

    /**
     * Texte du message.
     */
    private final String text;

    /**
     * Indique si le message est considéré comme un spam.
     */
    private final boolean spam;

    /**
     * Construit un nouveau message.
     *
     * @param text contenu du message
     * @param spam vrai si le message est un spam
     */
    public Message(String text, boolean spam) {
        this.text = text;
        this.spam = spam;
    }

    /**
     * Retourne le texte du message.
     *
     * @return texte du message
     */
    public String getText() {
        return text;
    }

    /**
     * Indique si le message est un spam.
     *
     * @return vrai si spam
     */
    public boolean isSpam() {
        return spam;
    }

    @Override
    public String toString() {
        return text;
    }
}