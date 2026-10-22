package com.example.manager;

import com.example.factory.MaGoFactory;
import com.example.model.GameModel;
import com.example.timer.GameTimer;
import com.example.strategy.MessageSelectionStrategy;

/**
 * Gestionnaire principal de l'application.
 * Cette classe implémente le patron Singleton.
 */
public final class GameManager {

    /**
     * Instance unique du gestionnaire.
     */
    private static GameManager instance;

    /**
     * Modèle principal du jeu.
     */
    private final GameModel gameModel;

    /**
     * Timer unique de l'application.
     */
    private final GameTimer gameTimer;

    /**
     * Construit le gestionnaire.
     * Constructeur privé car Singleton.
     */
    private GameManager() {

        MaGoFactory factory = new MaGoFactory();

        gameModel =
                new GameModel(
                        factory.createPopulation());

        gameTimer =
                new GameTimer(this);

    }

    /**
     * Retourne l'unique instance du gestionnaire.
     *
     * @return instance unique
     */
    public static GameManager getInstance() {

        if (instance == null) {

            instance = new GameManager();

        }

        return instance;

    }

    /**
     * Retourne le modèle principal.
     *
     * @return modèle du jeu
     */
    public GameModel getGameModel() {

        return gameModel;

    }

    /**
     * Retourne le timer.
     *
     * @return timer du jeu
     */
    public GameTimer getTimer() {

        return gameTimer;

    }

    /**
     * Démarre le timer.
     */
    public void startTimer() {

        gameTimer.start();

    }

    /**
     * Met le timer en pause.
     */
    public void pauseTimer() {

        gameTimer.pause();

    }

    /**
     * Reprend le timer.
     */
    public void resumeTimer() {

        gameTimer.resume();

    }

    /**
     * Passe au message suivant.
     */
    public void nextMessage() {

        gameModel.nextMessage();

        gameTimer.reset();

    }

    /**
     * Modifie la stratégie de sélection.
     *
     * @param strategy nouvelle stratégie
     */
    public void setStrategy(
            MessageSelectionStrategy strategy) {

        gameModel.setStrategy(strategy);

    }

}