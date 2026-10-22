package com.example.controller;

import com.example.model.mago.MaGo;
import com.example.view.MaGoControlView;

/**
 * Contrôleur de la fenêtre de contrôle d'un MaGo.
 */
public class MaGoController {

    /**
     * MaGo contrôlé.
     */
    private final MaGo mago;

    /**
     * Vue associée.
     */
    private final MaGoControlView view;

    /**
     * Contrôleur principal.
     */
    private final MainController mainController;

    /**
     * Construit le contrôleur.
     *
     * @param mago MaGo contrôlé
     * @param mainController contrôleur principal
     */
    public MaGoController(
            MaGo mago,
            MainController mainController) {

        this.mago = mago;

        this.mainController = mainController;

        view = new MaGoControlView(this);

    }

    /**
     * Retourne le MaGo.
     *
     * @return MaGo
     */
    public MaGo getMaGo() {

        return mago;

    }

    /**
     * Retourne la vue.
     *
     * @return vue
     */
    public MaGoControlView getView() {

        return view;

    }

    /**
     * Retourne le contrôleur principal.
     *
     * @return contrôleur principal
     */
    public MainController getMainController() {

        return mainController;

    }

    /**
     * Affiche la fenêtre.
     */
    public void showView() {

        mainController.pauseTimer();

        view.show();

    }

    /**
     * Valide la nouvelle valeur.
     */
    public void confirmValue() {

        try {

            int value =
                    Integer.parseInt(
                            view.getNewValueField().getText());

            mago.updateStatus(value);

            mainController
                    .getModel()
                    .notifyObservers();

            mainController.resetTimer();

            mainController.resumeTimer();

            view.close();

        } catch (NumberFormatException exception) {

            // Ne devrait jamais arriver.

        }

    }

}