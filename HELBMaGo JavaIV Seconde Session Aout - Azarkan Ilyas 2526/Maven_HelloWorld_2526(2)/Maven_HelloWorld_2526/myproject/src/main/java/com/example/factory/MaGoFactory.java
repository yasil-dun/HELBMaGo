package com.example.factory;

import com.example.model.mago.CircleMaGo;
import com.example.model.mago.MaGo;
import com.example.model.mago.MaGoType;
import com.example.model.mago.SquareMaGo;
import com.example.util.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Fabrique permettant de créer les MaGos.
 */
public class MaGoFactory {

    /**
     * Générateur aléatoire.
     */
    private final Random random;

    /**
     * Construit la fabrique.
     */
    public MaGoFactory() {

        random = new Random();

    }

    /**
     * Crée une population complète de MaGos.
     *
     * @return population créée
     */
    public List<MaGo> createPopulation() {

        List<MaGo> population = new ArrayList<>();

        int numberOfMagos = random.nextInt(
                Constants.MAX_MAGOS
                        - Constants.MIN_MAGOS
                        + Constants.FIRST_ELEMENT_AFTER_ZERO)
                + Constants.MIN_MAGOS;

        long timestamp =
                System.currentTimeMillis()
                / Constants.MILLISECONDS_PER_SECOND;

        for (int i = Constants.ZERO;
             i < numberOfMagos;
             i++) {

            // Extraction du ième chiffre en partant de la droite.
            int digit = (int) (
                    timestamp
                            / powerOfTen(i))
                    % Constants.DECIMAL_BASE;

            population.add(createMaGo(determineType(digit)));

        }

        return population;

    }

    /**
     * Crée un MaGo d'un type donné.
     *
     * @param type type souhaité
     * @return MaGo créé
     */
    private MaGo createMaGo(MaGoType type) {

    if (type == MaGoType.CIRCLE) {
        return new CircleMaGo();
    }

    if (type == MaGoType.SQUARE) {
        return new SquareMaGo();
    }

    throw new IllegalArgumentException(
        "Unknown MaGo type: " + type);

}

    /**
     * Détermine le type du MaGo.
     *
     * @param digit chiffre du timestamp
     * @return type correspondant
     */
    private MaGoType determineType(int digit) {

        if (digit % Constants.NUMBER_OF_MAGO_TYPES
                == Constants.ZERO) {

            return MaGoType.CIRCLE;

        }

        return MaGoType.SQUARE;

    }

    /**
     * Calcule 10 puissance n.
     *
     * @param exponent exposant
     * @return puissance de dix
     */
    private long powerOfTen(int exponent) {

        long value = Constants.FIRST_ELEMENT_AFTER_ZERO;

        for (int i = Constants.ZERO;
             i < exponent;
             i++) {

            value *= Constants.DECIMAL_BASE;

        }

        return value;

    }

}