package com.example.observer;

/**
 * Représente un observateur.
 * Un observateur est averti lorsqu'un sujet est modifié.
 */
public interface Observer {

    /**
     * Met à jour l'observateur.
     */
    void update();

}