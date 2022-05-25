package com.guesstheanimal;

import java.security.SecureRandom;
import java.util.*;

public class GuessTheAnimalGame {
    static Scanner scanner = new Scanner(System.in);
    static Random generator = new SecureRandom();

    public static void main(String[] args) {
        Map<String, String> animals = new HashMap<>();
        animals.put("кит", "живет в океане");
        animals.put("кот", "живет на суше");
        startGame(animals);
    }

    private static void startGame(Map<String, String> animals) {

        boolean continueGame = true;

        while (continueGame) {

            System.out.println("Загадай животное, а я попробую угадать...");
            Object[] computerAnimal = animals.keySet().toArray();
            String randomValue = (String) computerAnimal[generator.nextInt(computerAnimal.length)];
            System.out.println("Это животное " + animals.get(randomValue.toLowerCase()) + "? (да/нет)");
            String userResponse = scanner.nextLine();

            guessTheAnimal(animals, userResponse, randomValue);

            System.out.println("Хочешь продолжить игру? (да/нет)");
            String response = scanner.nextLine();
            continueGame = response.equalsIgnoreCase("да");
        }
    }

    private static void guessTheAnimal(Map<String, String> animals, String userResponse, String randomValue) {

        if (userResponse.equalsIgnoreCase("да")) {
            System.out.println("Это животное '" + randomValue + "'?");
            String userResponse2 = scanner.nextLine();
            if (userResponse2.equalsIgnoreCase("да")) {
                System.out.println("Я победил!");
            } else {
                addNewAnimal(randomValue, animals);
            }
        } else {
            addNewAnimal(randomValue, animals);
        }

    }

    private static void addNewAnimal(String newAnimal, Map<String, String> animals) {
        System.out.println("Какое животное ты загадал?");
        String randomValue = scanner.nextLine();
        System.out.println("Чем <" + newAnimal + "> отличается от <" + randomValue + ">?");
        String newValue = scanner.nextLine();
        animals.put(randomValue, newValue);
        System.out.println("Теперь я знаю таких животных --> " + animals);

    }

}


/**
 * Угадай животное
 * Изначально компьютеру известно два животных - кит и кот.
 * Так-же известно, что “кот” отличается от “кит” тем, что живёт на суше.
 * Компьютер предлагает сыграть в игру:
 * Загадай животное, а я попробую угадать...
 * Далее, используя имеющиеся знания о различиях животных, компьютер задает вопросы, а игрок отвечает на них “да” или “нет”:
 * Это животное живет на суше? (да/нет)
 * … и в зависимости от ответа игрока делает предположение что это “кит” или “кот”
 * <p>
 * Если компьютер угадал, то предложит сыграть ещё раз. Если не угадал, спрашивает:
 * Какое животное ты загадал:
 * Игрок вводит название загаданного животного.
 * Чем <загаданное животное> отличается от <предложенное животное>:
 * Например:
 * Какое животное ты загадал: обезьяна
 * Чем “обезьяна” отличается от “кот”: ест бананы
 * Компьютер пополняет свою базу знаний и предлагает сыграть ещё раз.
 */