package com.example.view;

import com.example.controller.MainController;
import com.example.observer.Observer;
import com.example.util.Constants;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Fenêtre principale de l'application.
 */
public class MainView
        implements Observer {

    /**
     * Contrôleur principal.
     */
    private final MainController controller;

    /**
     * Fenêtre JavaFX.
     */
    private final Stage stage;

    /**
     * Partie supérieure.
     */
    private final TopPanel topPanel;

    /**
     * Partie centrale.
     */
    private final CenterPanel centerPanel;

    /**
     * Partie inférieure.
     */
    private final BottomPanel bottomPanel;

    /**
     * Construit la fenêtre principale.
     *
     * @param controller contrôleur principal
     * @param stage fenêtre principale
     */
    public MainView(
            MainController controller,
            Stage stage) {

        this.controller = controller;
        this.stage = stage;

        BorderPane root = new BorderPane();

        topPanel = new TopPanel(controller);

        centerPanel = new CenterPanel(controller);

        bottomPanel = new BottomPanel(controller);

        root.setTop(topPanel);

        root.setCenter(centerPanel);

        root.setBottom(bottomPanel);

        Scene scene = new Scene(root);

        stage.setTitle(Constants.MAIN_WINDOW_TITLE);

        stage.setScene(scene);

        stage.sizeToScene();

        controller
                .getModel()
                .addObserver(this);

        stage.show();

    }

    /**
     * Met à jour toute l'interface graphique.
     */
    private void updateView() {

        topPanel.updateAverageStatus();

        centerPanel.updateMessage();

        centerPanel.updateTimer();

        bottomPanel
                .getMaGoPanel()
                .draw();

    }

    /**
     * Réagit à une modification du modèle.
     */
    @Override
    public void update() {

        Platform.runLater(this::updateView);

    }

    /**
     * Retourne le contrôleur principal.
     *
     * @return contrôleur principal
     */
    public MainController getController() {

        return controller;

    }

    /**
     * Retourne le panneau supérieur.
     *
     * @return panneau supérieur
     */
    public TopPanel getTopPanel() {

        return topPanel;

    }

    /**
     * Retourne le panneau central.
     *
     * @return panneau central
     */
    public CenterPanel getCenterPanel() {

        return centerPanel;

    }

    /**
     * Retourne le panneau inférieur.
     *
     * @return panneau inférieur
     */
    public BottomPanel getBottomPanel() {

        return bottomPanel;

    }

    /**
     * Retourne la fenêtre principale.
     *
     * @return fenêtre
     */
    public Stage getStage() {

        return stage;

    }

}