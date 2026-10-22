package com.example.observer;

/**
 * Représente un sujet observable.
 */
public interface Subject {

    /**
     * Ajoute un observateur.
     *
     * @param observer observateur à ajouter
     */
    void addObserver(Observer observer);

    /**
     * Supprime un observateur.
     *
     * @param observer observateur à supprimer
     */
    void removeObserver(Observer observer);

    /**
     * Notifie tous les observateurs.
     */
    void notifyObservers();

}