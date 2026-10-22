package com.example.model;

import com.example.model.mago.MaGo;
import com.example.model.message.Message;
import com.example.model.message.MessageManager;
import com.example.observer.Observer;
import com.example.observer.Subject;
import com.example.strategy.MessageSelectionStrategy;
import com.example.strategy.RandomStrategy;
import com.example.util.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Modèle principal du jeu.
 * Il contient les MaGos, les messages et la stratégie courante.
 */
public class GameModel implements Subject {

    /**
     * Population des MaGos.
     */
    private final List<MaGo> magos;

    /**
     * Gestionnaire des messages.
     */
    private final MessageManager messageManager;

    /**
     * Liste des observateurs.
     */
    private final List<Observer> observers;

    /**
     * Stratégie actuellement utilisée.
     */
    private MessageSelectionStrategy strategy;

    /**
     * Message actuellement affiché.
     */
    private Message currentMessage;

    /**
     * Construit le modèle.
     *
     * @param magos population des MaGos
     */
    public GameModel(List<MaGo> magos) {

        this.magos = magos;
        messageManager = new MessageManager();
        observers = new ArrayList<>();
        strategy = new RandomStrategy();

    }

    /**
     * Retourne la population.
     *
     * @return liste des MaGos
     */
    public List<MaGo> getMagos() {

        return magos;

    }

    /**
     * Retourne le message courant.
     *
     * @return message courant
     */
    public Message getCurrentMessage() {

        return currentMessage;

    }

    /**
     * Modifie la stratégie de sélection.
     *
     * @param strategy nouvelle stratégie
     */
    public void setStrategy(MessageSelectionStrategy strategy) {

        this.strategy = strategy;

    }

    /**
     * Passe au message suivant.
     */
    public void nextMessage() {

        currentMessage =
                messageManager.getNextMessage(strategy, magos);

        for (MaGo mago : magos) {

            mago.react(currentMessage);

        }

        notifyObservers();

    }

    /**
     * Calcule le statut moyen des MaGos.
     *
     * @return moyenne des statuts
     */
    public int getAverageStatus() {

        if (magos.isEmpty()) {
            return Constants.ZERO;
        }

        int total = Constants.ZERO;

        for (MaGo mago : magos) {

            total += mago.getStatus();

        }

        return total / magos.size();

    }

    /**
     * Ajoute un observateur.
     *
     * @param observer observateur à ajouter
     */
    @Override
    public void addObserver(Observer observer) {

        observers.add(observer);

    }

    /**
     * Supprime un observateur.
     *
     * @param observer observateur à supprimer
     */
    @Override
    public void removeObserver(Observer observer) {

        observers.remove(observer);

    }

    /**
     * Notifie tous les observateurs.
     */
    @Override
    public void notifyObservers() {

        for (Observer observer : observers) {

            observer.update();

        }

    }

}