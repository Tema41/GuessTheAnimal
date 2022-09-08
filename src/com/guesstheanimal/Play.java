package com.guesstheanimal;

import java.security.SecureRandom;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Play {
    static Scanner scanner = new Scanner(System.in);
    static Random generator = new SecureRandom();

    static void startGame(Map<String, String> animals) {
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
        System.out.println("Чем <" + randomValue + "> отличается от <" + newAnimal + ">?");
        String newValue = scanner.nextLine();
        animals.put(randomValue, newValue);
        System.out.println("Теперь я знаю таких животных --> " + animals);
    }
}
