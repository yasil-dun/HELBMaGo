package com.example.util;

import javafx.scene.paint.Color;

/**
 * Convertit un statut de MaGo en couleur.
 */
public final class ColorUtil {

    /**
     * Empêche l'instanciation.
     */
    private ColorUtil() {
    }

    /**
     * Retourne la couleur correspondant au statut.
     *
     * @param status statut du MaGo
     * @return couleur associée
     */
    public static Color getColor(int status) {

        if (status >= Constants.ZERO) {
            return getPositiveColor(status);
        }

        return getNegativeColor(status);

    }

    /**
     * Calcule une couleur pour un statut positif.
     *
     * @param status statut
     * @return couleur
     */
    private static Color getPositiveColor(int status) {

        int value =
                Constants.MAX_STATUS - status;

        int component =
                value
                        * Constants.COLOR_MAX_VALUE
                        / Constants.MAX_STATUS;

        return Color.rgb(
                Constants.COLOR_MAX_VALUE,
                component,
                component);

    }

    /**
     * Calcule une couleur pour un statut négatif.
     *
     * @param status statut
     * @return couleur
     */
    private static Color getNegativeColor(int status) {

        int value =
                status + Constants.MAX_STATUS;

        int component =
                value
                        * Constants.COLOR_MAX_VALUE
                        / Constants.MAX_STATUS;

        return Color.rgb(
                component,
                component,
                Constants.COLOR_MAX_VALUE);

    }

}