package com.example.controller;

import com.example.manager.GameManager;
import com.example.model.GameModel;
import com.example.model.mago.MaGo;
import com.example.model.message.Message;
import com.example.strategy.GoAnyStrategy;
import com.example.strategy.GoCircleStrategy;
import com.example.strategy.GoSquareStrategy;
import com.example.strategy.RandomStrategy;
import com.example.view.MainView;

import javafx.stage.Stage;

import java.util.List;

/**
 * Contrôleur principal de l'application.
 * Il fait le lien entre la vue et le modèle.
 */
public class MainController {

    /**
     * Gestionnaire principal.
     */
    private final GameManager gameManager;

    /**
     * Fenêtre principale.
     */
    private final MainView view;

    /**
     * Construit le contrôleur.
     *
     * @param stage fenêtre principale JavaFX
     */
    public MainController(Stage stage) {

        gameManager = GameManager.getInstance();

        view = new MainView(
                this,
                stage);

        nextMessage();

        startTimer();

    }

    /**
     * Passe au message suivant.
     */
    public void nextMessage() {

        gameManager.nextMessage();

    }

    /**
     * Active la stratégie Random.
     */
    public void setRandomStrategy() {

        gameManager.setStrategy(
                new RandomStrategy());

    }

    /**
     * Active la stratégie Circle.
     */
    public void setCircleStrategy() {

        gameManager.setStrategy(
                new GoCircleStrategy());

    }

    /**
     * Active la stratégie Square.
     */
    public void setSquareStrategy() {

        gameManager.setStrategy(
                new GoSquareStrategy());

    }

    /**
     * Active la stratégie GoAny.
     */
    public void setAnyStrategy() {

        gameManager.setStrategy(
                new GoAnyStrategy());

    }

    /**
     * Retourne le message courant.
     *
     * @return message courant
     */
    public Message getCurrentMessage() {

        return getModel().getCurrentMessage();

    }

    /**
     * Retourne la population.
     *
     * @return population de MaGos
     */
    public List<MaGo> getMagos() {

        return getModel().getMagos();

    }

    /**
     * Retourne le statut moyen.
     *
     * @return statut moyen
     */
    public int getAverageStatus() {

        return getModel().getAverageStatus();

    }

    /**
     * Retourne le modèle principal.
     *
     * @return modèle du jeu
     */
    public GameModel getModel() {

        return gameManager.getGameModel();

    }

    /**
     * Ouvre la fenêtre de contrôle d'un MaGo.
     *
     * @param mago MaGo sélectionné
     */
    public void openMaGoWindow(MaGo mago) {

        MaGoController controller =
                new MaGoController(
                        mago,
                        this);

        controller.showView();

    }

    /**
     * Retourne le temps restant avant le prochain message.
     *
     * @return temps restant
     */
    public int getRemainingSeconds() {

        return gameManager
                .getTimer()
                .getRemainingSeconds();

    }

    /**
     * Lance le timer.
     */
    public void startTimer() {

        gameManager.startTimer();

    }

    /**
     * Réinitialise le timer.
     */
    public void resetTimer() {

        gameManager
                .getTimer()
                .reset();

    }

    /**
     * Met le timer en pause.
     */
    public void pauseTimer() {

        gameManager.pauseTimer();

    }

    /**
     * Reprend le timer.
     */
    public void resumeTimer() {

        gameManager.resumeTimer();

    }

    /**
     * Retourne la fenêtre principale.
     *
     * @return vue principale
     */
    public MainView getView() {

        return view;

    }

}