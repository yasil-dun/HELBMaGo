package com.example.view;

import com.example.controller.MainController;

import javafx.geometry.Insets;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

/**
 * Partie inférieure de la fenêtre.
 */
public class BottomPanel extends BorderPane {

    /**
     * Panneau affichant les MaGos.
     */
    private final MaGoPanel maGoPanel;

    /**
     * Construit le panneau.
     *
     * @param controller contrôleur principal
     */
    public BottomPanel(MainController controller) {

        setPadding(new Insets(
                10,
                10,
                10,
                10));

        maGoPanel =
                new MaGoPanel(controller);

        StackPane container =
                new StackPane(maGoPanel);

        container.setBorder(
                new Border(
                        new BorderStroke(
                                Color.GRAY,
                                BorderStrokeStyle.SOLID,
                                CornerRadii.EMPTY,
                                new BorderWidths(2))));

        setCenter(container);

    }

    /**
     * Met à jour l'affichage des MaGos.
     */
    public void updateMaGos() {

        maGoPanel.draw();

    }

    /**
     * Retourne le panneau des MaGos.
     *
     * @return panneau des MaGos
     */
    public MaGoPanel getMaGoPanel() {

        return maGoPanel;

    }

}