package com.example.strategy;

import com.example.model.mago.MaGo;
import com.example.model.mago.MaGoType;

/**
 * Optimise les messages pour les MaGos Circle.
 */
public class GoCircleStrategy extends AbstractStrategy {

    /**
     * Indique si le MaGo est un Circle.
     *
     * @param mago MaGo à tester
     * @return vrai si Circle
     */
    @Override
    protected boolean accept(MaGo mago) {

        return mago.getType() == MaGoType.CIRCLE;

    }

}