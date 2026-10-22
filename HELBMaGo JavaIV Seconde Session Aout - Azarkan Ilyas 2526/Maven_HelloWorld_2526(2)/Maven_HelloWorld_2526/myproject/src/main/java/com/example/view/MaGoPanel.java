package com.example.view;

import com.example.controller.MainController;
import com.example.model.mago.MaGo;
import com.example.model.mago.MaGoType;
import com.example.util.ColorUtil;
import com.example.util.Constants;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

import java.util.List;

/**
 * Panneau chargé d'afficher les MaGos.
 */
public class MaGoPanel extends Canvas {

    /**
     * Contrôleur principal.
     */
    private final MainController controller;

    /**
     * Construit le panneau.
     *
     * @param controller contrôleur principal
     */
    public MaGoPanel(MainController controller) {

        this.controller = controller;

        setWidth(Constants.MAGO_PANEL_WIDTH);
        setHeight(Constants.MAGO_PANEL_HEIGHT);

        registerListeners();

        widthProperty().addListener(
                (obs, oldValue, newValue) -> draw());

        heightProperty().addListener(
                (obs, oldValue, newValue) -> draw());

    }

    /**
     * Rend le Canvas redimensionnable.
     *
     * @return toujours vrai
     */
    @Override
    public boolean isResizable() {

        return true;

    }

    /**
     * Adapte la taille du Canvas.
     *
     * @param width nouvelle largeur
     * @param height nouvelle hauteur
     */
    @Override
    public void resize(
            double width,
            double height) {

        setWidth(width);

        setHeight(height);

        draw();

    }

    /**
     * Associe les écouteurs.
     */
    private void registerListeners() {

        setOnMouseClicked(this::handleClick);

    }

    /**
     * Gère le clic sur un MaGo.
     *
     * @param event évènement souris
     */
    private void handleClick(
            MouseEvent event) {

        List<MaGo> magos =
                controller.getMagos();

        if (magos.isEmpty()) {
            return;
        }

        double cellWidth =
                getWidth() 
                        / magos.size();

        double size =
                Math.min(
                        cellWidth,
                        getHeight())
                        / Constants.MAGO_SIZE_DIVISOR;

        for (int i = Constants.ZERO;
             i < magos.size();
             i++) {

            double drawX =
                    i * cellWidth
                            + (cellWidth - size)
                            / Constants.TWO;

            double drawY =
                    (getHeight() - size)
                            / Constants.TWO;

            if (isClicked(
                    magos.get(i),
                    event.getX(),
                    event.getY(),
                    drawX,
                    drawY,
                    size)) {

                controller.openMaGoWindow(
                        magos.get(i));

                return;

            }

        }

    }

    /**
     * Vérifie si un MaGo a été cliqué.
     *
     * @param mago MaGo concerné
     * @param mouseX position X
     * @param mouseY position Y
     * @param drawX position X du MaGo
     * @param drawY position Y du MaGo
     * @param size taille
     * @return vrai si le MaGo est cliqué
     */
    private boolean isClicked(
            MaGo mago,
            double mouseX,
            double mouseY,
            double drawX,
            double drawY,
            double size) {

        if (mago.getType()
                == MaGoType.SQUARE) {

            return mouseX >= drawX
                    && mouseX <= drawX + size
                    && mouseY >= drawY
                    && mouseY <= drawY + size;

        }

        double centerX =
                drawX
                        + size
                        / Constants.TWO;

        double centerY =
                drawY
                        + size
                        / Constants.TWO;

        double radius =
                size
                        / Constants.TWO;

        double dx =
                mouseX - centerX;

        double dy =
                mouseY - centerY;

        return dx * dx + dy * dy
                <= radius * radius;

    }

    /**
     * Dessine les MaGos.
     */
    public void draw() {

        GraphicsContext graphics =
                getGraphicsContext2D();

        graphics.clearRect(
                0,
                0,
                getWidth(),
                getHeight());

        List<MaGo> magos =
                controller.getMagos();

        if (magos.isEmpty()) {
            return;
        }

        double cellWidth =
        getWidth()
                / magos.size();

        double size =
                Math.min(
                        cellWidth
                                * Constants.MAGO_WIDTH_RATIO,
                        getHeight()
                                * Constants.MAGO_HEIGHT_RATIO);

        for (int i = Constants.ZERO;
             i < magos.size();
             i++) {

            drawMaGo(
                    graphics,
                    magos.get(i),
                    i,
                    cellWidth,
                    size);

        }

    }

    /**
     * Dessine un MaGo.
     *
     * @param graphics contexte graphique
     * @param mago MaGo
     * @param index position
     * @param cellWidth largeur disponible
     * @param size taille
     */
      private void drawMaGo(
                GraphicsContext graphics,
                MaGo mago,
                int index,
                double cellWidth,
                double size) {

        double totalWidth =
                cellWidth
                        * controller.getMagos().size();

        double startX =
                (getWidth() - totalWidth)
                        / Constants.TWO;

        double x =
                startX
                        + index * cellWidth
                        + (cellWidth - size)
                        / Constants.TWO;

        double y =
                (getHeight() - size)
                        / Constants.TWO;

        graphics.setFill(
                ColorUtil.getColor(
                        mago.getStatus()));

        graphics.setStroke(
                javafx.scene.paint.Color.BLACK);

        graphics.setLineWidth(
                Constants.MAGO_BORDER_WIDTH);

        if (mago.getType()
                == MaGoType.CIRCLE) {

                graphics.fillOval(
                        x,
                        y,
                        size,
                        size);

                graphics.strokeOval(
                        x,
                        y,
                        size,
                        size);

                return;

        }

        graphics.fillRect(
                x,
                y,
                size,
                size);

        graphics.strokeRect(
                x,
                y,
                size,
                size);

        }

    

}