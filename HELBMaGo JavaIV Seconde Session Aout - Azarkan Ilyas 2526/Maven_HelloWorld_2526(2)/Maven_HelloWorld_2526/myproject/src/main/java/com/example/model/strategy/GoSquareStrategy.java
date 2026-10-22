package com.example.strategy;

import com.example.model.mago.MaGo;
import com.example.model.mago.MaGoType;

/**
 * Optimise les messages pour les MaGos Square.
 */
public class GoSquareStrategy extends AbstractStrategy {

    /**
     * Indique si le MaGo est un Square.
     *
     * @param mago MaGo à tester
     * @return vrai si Square
     */
    @Override
    protected boolean accept(MaGo mago) {

        return mago.getType() == MaGoType.SQUARE;

    }

}