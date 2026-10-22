package com.example.view;

import com.example.controller.MaGoController;
import com.example.util.Constants;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Fenêtre de contrôle d'un MaGo.
 */
public class MaGoControlView {

    /**
     * Contrôleur.
     */
    private final MaGoController controller;

    /**
     * Fenêtre JavaFX.
     */
    private final Stage stage;

    /**
     * Valeur actuelle.
     */
    private final Label actualStatusLabel;

    /**
     * Champ de saisie.
     */
    private final TextField newValueField;

    /**
     * Bouton de confirmation.
     */
    private final Button confirmButton;

    /**
     * Construit la fenêtre.
     *
     * @param controller contrôleur
     */
    public MaGoControlView(
            MaGoController controller) {

        this.controller = controller;

        stage = new Stage();

        stage.setTitle("MaGo Control");

        stage.initModality(
                Modality.APPLICATION_MODAL);

        GridPane root = new GridPane();

        root.setPadding(new Insets(10));

        root.setHgap(10);

        root.setVgap(10);

        root.add(
                new Label("Actual Status"),
                0,
                0);

        actualStatusLabel =
                new Label(
                        String.valueOf(
                                controller
                                        .getMaGo()
                                        .getStatus()));

        root.add(
                actualStatusLabel,
                1,
                0);

        root.add(
                new Label(
                        "New Value ["
                                + Constants.MIN_STATUS
                                + " ; "
                                + Constants.MAX_STATUS
                                + "]"),
                0,
                1);

        newValueField =
                new TextField();

        root.add(
                newValueField,
                1,
                1);

        confirmButton =
                new Button(
                        "Confirm New Value");

        confirmButton.setDisable(true);

        root.add(
                confirmButton,
                1,
                2);

        registerListeners();

        stage.setScene(
                new Scene(root));

        stage.sizeToScene();

    }

    /**
     * Associe les écouteurs.
     */
    private void registerListeners() {

        newValueField.textProperty().addListener(
                (observable,
                 oldValue,
                 newValue) -> validateInput());

        confirmButton.setOnAction(event ->
                controller.confirmValue());

    }

    /**
     * Vérifie la valeur saisie.
     */
    private void validateInput() {

        try {

            int value =
                    Integer.parseInt(
                            newValueField.getText());

            confirmButton.setDisable(
                    value < Constants.MIN_STATUS
                            || value > Constants.MAX_STATUS);

        } catch (NumberFormatException exception) {

            confirmButton.setDisable(true);

        }

    }

    /**
     * Affiche la fenêtre.
     */
    public void show() {

        stage.showAndWait();

    }

    /**
     * Ferme la fenêtre.
     */
    public void close() {

        stage.close();

    }

    /**
     * Retourne le contrôleur.
     *
     * @return contrôleur
     */
    public MaGoController getController() {

        return controller;

    }

    /**
     * Retourne le champ de saisie.
     *
     * @return champ
     */
    public TextField getNewValueField() {

        return newValueField;

    }

    /**
     * Retourne la fenêtre.
     *
     * @return fenêtre
     */
    public Stage getStage() {

        return stage;

    }

}