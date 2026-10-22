package com.example.util;

/**
 * Regroupe toutes les constantes utilisées dans l'application.
 * Centraliser ces valeurs permet d'éviter les constantes magiques
 * et facilite les futures modifications.
 */
public final class Constants {

    /**
     * Empêche l'instanciation de cette classe utilitaire.
     */
    private Constants() {
    }

    // =====================================================
    // Statut des MaGos
    // =====================================================

    /**
     * Valeur maximale du bonheur.
     */
    public static final int MAX_STATUS = 100;

    /**
     * Valeur minimale du bonheur.
     */
    public static final int MIN_STATUS = -MAX_STATUS;

    /**
     * Bonheur initial d'un MaGo.
     */
    public static final int INITIAL_STATUS = 0;

    // =====================================================
    // Population
    // =====================================================

    /**
     * Nombre minimum de MaGos.
     */
    public static final int MIN_MAGOS = 2;

    /**
     * Nombre maximum de MaGos.
     */
    public static final int MAX_MAGOS = 8;

    // =====================================================
    // Valeurs numériques
    // =====================================================

    /**
     * Représente la valeur zéro.
     */
    public static final int ZERO = 0;

    /**
     * Représente la valeur un.
     */
    public static final int ONE = 1;

    /**
     * Représente la valeur deux.
     */
    public static final int TWO = 2;

    /**
     * Premier indice après zéro.
     */
    public static final int FIRST_ELEMENT_AFTER_ZERO = 1;

    /**
     * Valeur renvoyée lorsqu'un élément n'est pas trouvé.
     */
    public static final int NOT_FOUND = -1;

    /**
     * Représente 100 %.
     */
    public static final int ONE_HUNDRED_PERCENT = 100;

    /**
     * Base décimale.
     */
    public static final int DECIMAL_BASE = 10;

    /**
     * Nombre de types de MaGo.
     */
    public static final int NUMBER_OF_MAGO_TYPES = 2;

    /**
     * Nombre de millisecondes dans une seconde.
     */
    public static final int MILLISECONDS_PER_SECOND = 1000;

    // =====================================================
    // Réactions des MaGos
    // =====================================================

    /**
     * Seuil du ratio voyelles / consonnes
     * utilisé par les MaGos Square.
     */
    public static final double SQUARE_RATIO_LIMIT = 0.89;

    /**
     * Pourcentage de variation du bonheur
     * d'un MaGo Square.
     */
    public static final int SQUARE_CHANGE_PERCENT = 10;

    /**
     * Pourcentage de bonheur gagné
     * par ponctuation positive d'un Circle.
     */
    public static final int CIRCLE_INCREASE_PERCENT = 5;

    /**
     * Pourcentage de bonheur perdu lorsqu'un
     * message ne contient aucune ponctuation positive.
     */
    public static final int CIRCLE_DECREASE_PERCENT = 10;

    // =====================================================
    // Analyse des messages
    // =====================================================

    /**
     * Caractère représentant un point d'exclamation.
     */
    public static final char EXCLAMATION_MARK = '!';

    /**
     * Caractère représentant un point d'interrogation.
     */
    public static final char QUESTION_MARK = '?';

    /**
     * Ensemble des voyelles reconnues.
     */
    public static final String VOWELS =
        "aeiouyàâäéèêëîïôöùûüÿAEIOUYÀÂÄÉÈÊËÎÏÔÖÙÛÜŸ";

    /**
     * Préfixe d'un lien Internet.
     */
    public static final String HTTP_PREFIX = "http://";

    /**
     * Nom du fichier contenant les messages.
     */
    public static final String MESSAGE_FILE = "mess.msg.txt";

    // =====================================================
    // Couleurs
    // =====================================================

    /**
     * Valeur maximale d'une composante RGB.
     */
    public static final int COLOR_MAX_VALUE = 255;

    // =====================================================
    // Interface graphique
    // =====================================================

    /**
     * Titre de la fenêtre principale.
     */
    public static final String MAIN_WINDOW_TITLE = "HELBMaGo";

    /**
     * Facteur de largeur utilisé pour dessiner un MaGo.
     */
    public static final double MAGO_WIDTH_RATIO = 0.7;

    /**
     * Facteur de hauteur utilisé pour dessiner un MaGo.
     */
    public static final double MAGO_HEIGHT_RATIO = 0.55;

    /**
     * Épaisseur du contour des MaGos.
     */
    public static final double MAGO_BORDER_WIDTH = 2.0;

    /**
     * Largeur préférée du panneau des MaGos.
     */
    public static final int MAGO_PANEL_WIDTH = 700;

    /**
     * Hauteur préférée du panneau des MaGos.
     */
    public static final int MAGO_PANEL_HEIGHT = 300;

    /**
     * Diviseur utilisé pour calculer
     * la taille des MaGos.
     */
    public static final int MAGO_SIZE_DIVISOR = 2;

    /**
     * Temps entre deux messages.
     */
    public static final int TIMER_DURATION = 5;

    /**
     * Délai du timer JavaFX en millisecondes (1 seconde).
     */
    public static final int TIMER_DELAY =
            MILLISECONDS_PER_SECOND;

}