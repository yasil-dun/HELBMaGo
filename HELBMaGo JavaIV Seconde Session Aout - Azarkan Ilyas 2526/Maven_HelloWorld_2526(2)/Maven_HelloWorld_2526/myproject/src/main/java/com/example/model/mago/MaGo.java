package com.example.model.mago;

import com.example.model.message.Message;
import com.example.util.Constants;

/**
 * Représente un MaGo.
 * Cette classe est abstraite car chaque type de MaGo
 * réagit différemment aux messages.
 */
public abstract class MaGo {

    /**
     * Niveau actuel de bonheur du MaGo.
     */
    private int status;

    /**
     * Construit un MaGo avec un bonheur initial.
     */
    public MaGo() {
        this.status = Constants.INITIAL_STATUS;
    }

    /**
     * Retourne le niveau de bonheur.
     *
     * @return niveau de bonheur
     */
    public int getStatus() {
        return status;
    }

    /**
     * Retourne le type du MaGo.
     *
     * @return type du MaGo
     */
    public abstract MaGoType getType();

    /**
     * Modifie le niveau de bonheur.
     * La valeur reste toujours comprise entre
     * MIN_STATUS et MAX_STATUS.
     *
     * @param status nouvelle valeur
     */
    protected void setStatus(int status) {

        if (status > Constants.MAX_STATUS) {
            this.status = Constants.MAX_STATUS;
        } else if (status < Constants.MIN_STATUS) {
            this.status = Constants.MIN_STATUS;
        } else {
            this.status = status;
        }

    }

    /**
     * Calcule la variation réellement appliquée
     * après prise en compte des limites.
     *
     * @param variation variation souhaitée
     * @return variation réellement appliquée
     */
    protected int computeRealVariation(int variation) {

        int oldStatus = getStatus();

        int newStatus = oldStatus + variation;

        if (newStatus > Constants.MAX_STATUS) {
            newStatus = Constants.MAX_STATUS;
        }

        if (newStatus < Constants.MIN_STATUS) {
            newStatus = Constants.MIN_STATUS;
        }

        return newStatus - oldStatus;

    }

    /**
     * Modifie directement le statut du MaGo.
     *
     * @param status nouvelle valeur
     */
    public void updateStatus(int status) {

        setStatus(status);

    }
    
    /**
     * Calcule la variation de bonheur provoquée
     * par un message.
     *
     * @param message message reçu
     * @return variation réellement appliquée
     */
    public abstract int computeStatusVariation(Message message);

    /**
     * Fait réagir le MaGo à un message.
     *
     * @param message message reçu
     */
    public void react(Message message) {

        int variation = computeStatusVariation(message);

        setStatus(getStatus() + variation);

    }

}