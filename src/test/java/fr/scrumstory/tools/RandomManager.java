package fr.scrumstory.tools;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

/**
 * Utilitaire de génération aléatoire de types simples.
 */
public final class RandomManager {

    /**
     * Générateur unique
     */
    private static final Random RANDOM = new Random();

    /**
     * Constructeur Privé
     */
    private RandomManager() {
    }

    /**
     * Génère un ID de 20 caractères alpha-numérique.
     *
     * @return 20 caractères aléatoires
     */
    public static String randomId() {
        return RandomStringUtils.randomAscii(20);
    }

    /**
     * Génère un chaîne de 5 à 30 caractères.
     *
     * @return 5 à 30 caractères aléatoires
     */
    public static String randomString() {
        return RandomStringUtils.random(randomInt(5, 30));
    }

    /**
     * Génère une chaîne caractères alphabétique.
     *
     * @param nbChar : nombre de caractères
     * @return une chaîne caractères alphabétique
     */
    public static String randomLetter(int nbChar) {
        return RandomStringUtils.randomAlphabetic(3);
    }

    /**
     * Choisi aléatoirement une des valeurs possible
     * @param values : les valeurs possibles
     * @return la valeur choisie
     */
    public static String randomString(String ... values) {
        return values[randomInt(values.length - 1)];
    }

    /**
     * Génère un entier compris entre min et max (inclus)
     *
     * @param min : entier minium
     * @param max : entier maximum
     * @return un entier compris entre min et max
     */
    public static int randomInt(int min, int max) {
        return RANDOM.nextInt(max - min + 1) + min;
    }

    /**
     * Génère un entier compris entre 0 et max (inclus)
     *
     * @param max : entier maximum
     * @return un entier compris entre min et max
     */
    public static int randomInt(int max) {
        return randomInt(0, max);
    }
}
