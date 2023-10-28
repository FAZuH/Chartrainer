package com.fazuh.chartrainer;

import java.util.Arrays;


public class Chartrainer {
    private static final String[] EXIT_COMMANDS = {"exit", "e"};
    private static final String[] TRAINER_COMMANDS = {"matchChar", "matchNum", "mathChar"};


    public static void main(String[] args) {
        while (true) {
            String userInput = Colour.askInput("Enter trainer mode: ");


            if (Arrays.asList(EXIT_COMMANDS).contains(userInput)) {  // Exit
                Colour.printError("Exiting program...");
                break;
            } else if (!Arrays.asList(TRAINER_COMMANDS).contains(userInput)) {  // Invalid command
                Colour.printError(
                    "Invalid command. Available commands are " + String.join(", ", TRAINER_COMMANDS)
                );
                continue;
            }

            int attempts = Integer.parseInt(Colour.askInput("Enter number of attempts: "));

            switch (userInput) {
                case "matchChar":
                    MatchChar matchCharTrainer = new MatchChar(attempts);
                    matchCharTrainer.run();
                    break;
                case "matchNum":
                    MatchNum matchNumTrainer = new MatchNum(attempts);
                    matchNumTrainer.run();
                    break;
                case "mathChar":
                    MathChar mathChar = new MathChar(attempts);
                    mathChar.run();
                    break;
            }
        }
    }
}
