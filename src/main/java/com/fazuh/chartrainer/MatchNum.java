package com.fazuh.chartrainer;

public class MatchNum extends TrainerBase {
    MatchNum(int attempts) {
        super(attempts);
    }

    public void run() {
        while (this.isSession) {
            // Asked number, answers with corresponding character
            int question = this.generateQuestion();
            String correct_answer = String.valueOf(this.intToChar(question));

            String answer = Colour.askQuestion(String.valueOf(question)).toUpperCase();

            if (answer.equals(correct_answer)) {
                this.correctAnswer();
            } else {
                this.incorrectAnswer(correct_answer);
            }
        }
    }
}
