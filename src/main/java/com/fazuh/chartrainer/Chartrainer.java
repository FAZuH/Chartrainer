package com.fazuh.chartrainer;

import java.util.Set;


public class Chartrainer {
    static final Set<String> EXIT_COMMANDS = Set.of("exit", "quit", "q");
    static final Set<String> TRAINER_COMMANDS = Set.of("matchChar", "matchNum", "mathChar");

    public static void main(String[] args) {
        while (true) {
            String userInput;
            int attempts;

            userInput = Colour.askInput("Enter trainer mode: ");
            if (EXIT_COMMANDS.contains(userInput)) {  // Exit
                Colour.printError("Exiting program...");
                break;
            } else if (!TRAINER_COMMANDS.contains(userInput)) {  // Invalid command
                Colour.printError(
                    "Invalid command. Available commands are " + String.join(", ", TRAINER_COMMANDS)
                );
                continue;
            }

            try {
                attempts = Integer.parseInt(Colour.askInput("Enter number of attempts: "));
            } catch (Exception e) {
                Colour.printError("Invalid input. " + e);
                continue;
            }

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
