package com.example;

import javafx.application.Application;
import javafx.stage.Stage;

import com.example.controller.MainController;

/**
 * Lance l'application.
 */
public class Main extends Application {

    /**
     * Point d'entrée JavaFX.
     *
     * @param stage fenêtre principale
     */
    @Override
    public void start(Stage stage) {

        new MainController(stage);

    }

    /**
     * Point d'entrée de l'application.
     *
     * @param args arguments de lancement
     */
    public static void main(String[] args) {

        launch(args);

    }

}