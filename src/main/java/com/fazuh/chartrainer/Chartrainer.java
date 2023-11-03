package com.fazuh.chartrainer;

import java.util.Set;


public class Chartrainer {
    private static final Set<String> EXIT_COMMANDS = Set.of("exit", "quit", "e", "q");
    private static final Set<String> TRAINER_COMMANDS = Set.of("matchChar", "matchNum", "mathChar");

    public static void main(String[] args) {
        while (true) {
            String userInput = Colour.askInput("Enter trainer mode: ");

            if (EXIT_COMMANDS.contains(userInput)) {  // Exit
                Colour.printError("Exiting program...");
                break;
            } else if (!TRAINER_COMMANDS.contains(userInput)) {  // Invalid command
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
