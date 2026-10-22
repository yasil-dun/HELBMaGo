package com.example.strategy;

import com.example.model.mago.MaGo;
import com.example.model.mago.MaGoType;
import com.example.model.message.Message;
import com.example.util.Constants;

import java.util.List;
import java.util.Random;

/**
 * Sélectionne aléatoirement un type de MaGo
 * puis choisit le meilleur message pour ce type.
 */
public class GoAnyStrategy implements MessageSelectionStrategy {

    /**
     * Générateur aléatoire.
     */
    private final Random random;

    /**
     * Stratégie Circle.
     */
    private final GoCircleStrategy circleStrategy;

    /**
     * Stratégie Square.
     */
    private final GoSquareStrategy squareStrategy;

    /**
     * Construit la stratégie GoAny.
     */
    public GoAnyStrategy() {

        random = new Random();
        circleStrategy = new GoCircleStrategy();
        squareStrategy = new GoSquareStrategy();

    }

    /**
     * Sélectionne un message.
     *
     * @param messages messages disponibles
     * @param magos population
     * @return meilleur message
     */
    @Override
    public Message selectMessage(List<Message> messages,
                                 List<MaGo> magos) {

        MaGoType type = chooseType(magos);

        if (type == MaGoType.CIRCLE) {
            return circleStrategy.selectMessage(messages, magos);
        }

        return squareStrategy.selectMessage(messages, magos);

    }

    /**
     * Choisit un type présent dans la population.
     *
     * @param magos population
     * @return type choisi
     */
    private MaGoType chooseType(List<MaGo> magos) {

        boolean hasCircle = false;
        boolean hasSquare = false;

        for (int i = Constants.ZERO;
             i < magos.size();
             i++) {

            MaGo mago = magos.get(i);

            if (mago.getType() == MaGoType.CIRCLE) {
                hasCircle = true;
            }

            if (mago.getType() == MaGoType.SQUARE) {
                hasSquare = true;
            }

        }

        if (hasCircle && hasSquare) {

            if (random.nextBoolean()) {
                return MaGoType.CIRCLE;
            }

            return MaGoType.SQUARE;

        }

        if (hasCircle) {
            return MaGoType.CIRCLE;
        }

        return MaGoType.SQUARE;

    }

}