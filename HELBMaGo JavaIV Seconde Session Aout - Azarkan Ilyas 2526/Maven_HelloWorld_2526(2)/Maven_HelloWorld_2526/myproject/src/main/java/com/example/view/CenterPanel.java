package com.example.view;

import com.example.controller.MainController;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * Partie centrale de la fenêtre.
 */
public class CenterPanel extends BorderPane {

    /**
     * Contrôleur principal.
     */
    private final MainController controller;

    /**
     * Zone affichant le message.
     */
    private final TextArea messageArea;

    /**
     * Bouton message suivant.
     */
    private final Button nextButton;

    /**
     * Compteur.
     */
    private final TextField timerField;

    /**
     * Bouton radio Random.
     */
    private final RadioButton randomButton;

    /**
     * Bouton radio GoCircle.
     */
    private final RadioButton goCircleButton;

    /**
     * Bouton radio GoSquare.
     */
    private final RadioButton goSquareButton;

    /**
     * Bouton radio GoAny.
     */
    private final RadioButton goAnyButton;

    /**
     * Construit le panneau.
     *
     * @param controller contrôleur principal
     */
    public CenterPanel(MainController controller) {

        this.controller = controller;

        setPadding(new Insets(10));

        messageArea = new TextArea();

        messageArea.setEditable(false);

        messageArea.setWrapText(true);

        messageArea.setPrefRowCount(6);

        messageArea.setPrefWidth(450);

        messageArea.setBorder(
                new Border(
                        new BorderStroke(
                                Color.GRAY,
                                BorderStrokeStyle.SOLID,
                                new CornerRadii(15),
                                new BorderWidths(1.5))));

        setCenter(messageArea);

        VBox rightPanel = new VBox(15);

        rightPanel.setAlignment(Pos.TOP_CENTER);

        timerField = new TextField();

        timerField.setEditable(false);

        timerField.setAlignment(Pos.CENTER);

        timerField.setPrefWidth(70);

        timerField.setMaxWidth(70);

        nextButton = new Button("→");

        nextButton.setPrefSize(70, 40);

        VBox radioPanel = new VBox(8);

        radioPanel.setPadding(new Insets(10));

        radioPanel.setBorder(
                new Border(
                        new BorderStroke(
                                Color.GRAY,
                                BorderStrokeStyle.SOLID,
                                new CornerRadii(15),
                                BorderWidths.DEFAULT)));

        radioPanel.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.WHITE,
                                new CornerRadii(15),
                                Insets.EMPTY)));

        randomButton = new RadioButton("Random");

        goCircleButton = new RadioButton("GoCircle");

        goSquareButton = new RadioButton("GoSquare");

        goAnyButton = new RadioButton("GoAny");

        ToggleGroup group = new ToggleGroup();

        randomButton.setToggleGroup(group);

        goCircleButton.setToggleGroup(group);

        goSquareButton.setToggleGroup(group);

        goAnyButton.setToggleGroup(group);

        randomButton.setSelected(true);

        radioPanel.getChildren().addAll(
                randomButton,
                goCircleButton,
                goSquareButton,
                goAnyButton);

        rightPanel.getChildren().addAll(
                timerField,
                nextButton,
                radioPanel);

        setRight(rightPanel);

        setMargin(messageArea, new Insets(0, 15, 0, 0));

        registerListeners();

        updateTimer();

    }

    /**
     * Associe les composants graphiques au contrôleur.
     */
    private void registerListeners() {

        nextButton.setOnAction(event ->
                controller.nextMessage());

        randomButton.setOnAction(event ->
                controller.setRandomStrategy());

        goCircleButton.setOnAction(event ->
                controller.setCircleStrategy());

        goSquareButton.setOnAction(event ->
                controller.setSquareStrategy());

        goAnyButton.setOnAction(event ->
                controller.setAnyStrategy());

    }

    /**
     * Met à jour le message affiché.
     */
    public void updateMessage() {

        messageArea.setText(
                controller
                        .getCurrentMessage()
                        .getText());

    }

    /**
     * Met à jour le compteur.
     */
    public void updateTimer() {

        timerField.setText(
                String.valueOf(
                        controller.getRemainingSeconds()));

    }

}