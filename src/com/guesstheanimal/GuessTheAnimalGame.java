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
            String userAnimal = scanner.nextLine();
            Object[] computerAnimal = animals.keySet().toArray();
            String randomValue = (String) computerAnimal[generator.nextInt(computerAnimal.length)];
            System.out.println("Это животное " + animals.get(randomValue) + "? (да/нет)");
            String userResponse = scanner.nextLine();

            if (userResponse.equalsIgnoreCase("да")) {
                System.out.println("Это животное '" + userAnimal + "' и оно " + animals.get(userAnimal.toLowerCase()));
            } else {
                addNewAnimal(userAnimal, animals, randomValue);
            }

            System.out.println("Хочешь продолжить игру?");
            String response = scanner.nextLine();

            if (response.equalsIgnoreCase("да")) {
                continueGame = true;
            } else {
                continueGame = false;
            }
        }
    }

    private static void addNewAnimal(String newAnimal, Map<String, String> animals, String randomValue) {
        System.out.println("Чем <" + newAnimal + "> отличается от <" + randomValue + ">?");
        String newValue = scanner.nextLine();
        animals.put(newAnimal, newValue);
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