package com.example.view;

import com.example.controller.MainController;
import com.example.util.ColorUtil;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

/**
 * Partie supérieure de la fenêtre.
 */
public class TopPanel extends GridPane {

    /**
     * Contrôleur principal.
     */
    private final MainController controller;

    /**
     * Carré représentant le statut moyen.
     */
    private final Region averageColorPanel;

    /**
     * Construit le panneau.
     *
     * @param controller contrôleur principal
     */
    public TopPanel(MainController controller) {

        this.controller = controller;

        setHgap(100);

        setPadding(new Insets(
                10,
                10,
                10,
                10));

        averageColorPanel = new Region();

        add(createAveragePanel(), 0, 0);

        add(createColorPanel(
                Color.BLUE,
                "Negative Color"),
                1,
                0);

        add(createColorPanel(
                Color.RED,
                "Positive Color"),
                2,
                0);

        updateAverageStatus();

    }

    /**
     * Crée le panneau du statut moyen.
     *
     * @return panneau
     */
    private HBox createAveragePanel() {

        HBox panel = new HBox(10);

        panel.setAlignment(Pos.CENTER);

        panel.setPadding(new Insets(10));

        panel.setBorder(
                new Border(
                        new BorderStroke(
                                Color.GRAY,
                                BorderStrokeStyle.SOLID,
                                CornerRadii.EMPTY,
                                BorderWidths.DEFAULT)));

        averageColorPanel.setPrefSize(30, 30);

        averageColorPanel.setBorder(
                new Border(
                        new BorderStroke(
                                Color.BLACK,
                                BorderStrokeStyle.SOLID,
                                CornerRadii.EMPTY,
                                BorderWidths.DEFAULT)));

        panel.getChildren().addAll(
                averageColorPanel,
                new Label("Average Status"));

        return panel;

    }

    /**
     * Crée un panneau de couleur.
     *
     * @param color couleur
     * @param text texte
     * @return panneau
     */
    private HBox createColorPanel(
            Color color,
            String text) {

        HBox panel = new HBox(10);

        panel.setAlignment(Pos.CENTER);

        panel.setPadding(new Insets(10));

        panel.setBorder(
                new Border(
                        new BorderStroke(
                                Color.GRAY,
                                BorderStrokeStyle.SOLID,
                                CornerRadii.EMPTY,
                                BorderWidths.DEFAULT)));

        Region square = new Region();

        square.setPrefSize(30, 30);

        square.setBackground(
                new Background(
                        new BackgroundFill(
                                color,
                                CornerRadii.EMPTY,
                                Insets.EMPTY)));

        square.setBorder(
                new Border(
                        new BorderStroke(
                                Color.BLACK,
                                BorderStrokeStyle.SOLID,
                                CornerRadii.EMPTY,
                                BorderWidths.DEFAULT)));

        panel.getChildren().addAll(
                square,
                new Label(text));

        return panel;

    }

    /**
     * Met à jour le statut moyen.
     */
    public void updateAverageStatus() {

        averageColorPanel.setBackground(
                new Background(
                        new BackgroundFill(
                                ColorUtil.getColor(
                                        controller.getAverageStatus()),
                                CornerRadii.EMPTY,
                                Insets.EMPTY)));

        }

    /**
     * Retourne le contrôleur principal.
     *
     * @return contrôleur
     */
    public MainController getController() {

        return controller;

    }

}