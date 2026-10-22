package com.example.timer;

import com.example.manager.GameManager;
import com.example.util.Constants;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

/**
 * Gère le compteur des messages.
 */
public class GameTimer {

    /**
     * Timer JavaFX.
     */
    private final Timeline timer;

    /**
     * Temps restant avant le prochain message.
     */
    private int remainingSeconds;

    /**
     * Gestionnaire principal.
     */
    private final GameManager gameManager;

    /**
     * Construit le timer.
     *
     * @param gameManager gestionnaire principal
     */
    public GameTimer(GameManager gameManager) {

        this.gameManager = gameManager;

        remainingSeconds = Constants.TIMER_DURATION;

        timer = new Timeline(
                new KeyFrame(
                        Duration.millis(
                                Constants.TIMER_DELAY),
                        event -> tick()));

        timer.setCycleCount(
                Timeline.INDEFINITE);

    }

    /**
     * Lance le timer.
     */
    public void start() {

        timer.play();

    }

    /**
     * Arrête le timer.
     */
    public void stop() {

        timer.stop();

    }

    /**
     * Met le timer en pause.
     */
    public void pause() {

        timer.pause();

    }

    /**
     * Reprend le timer.
     */
    public void resume() {

        timer.play();

    }

    /**
     * Remet le compteur à sa valeur initiale.
     */
    public void reset() {

        remainingSeconds =
                Constants.TIMER_DURATION;

        gameManager
                .getGameModel()
                .notifyObservers();

    }

    /**
     * Retourne le temps restant.
     *
     * @return temps restant
     */
    public int getRemainingSeconds() {

        return remainingSeconds;

    }

    /**
     * Exécuté toutes les secondes.
     */
    private void tick() {

        remainingSeconds--;

        if (remainingSeconds
                <= Constants.ZERO) {

            gameManager.nextMessage();

        } else {

            gameManager
                    .getGameModel()
                    .notifyObservers();

        }

    }

}