package com.fazuh.chartrainer;

public class MatchChar extends TrainerBase {
    MatchChar(int attempts) {
        super(attempts);
    }

    public void run() {
        while (this.isSession) {
            // Asked character, answers with corresponding number
            int correct_answer = this.generateQuestion();
            char question = this.intToChar(correct_answer);

            int answer = Integer.parseInt(Colour.askQuestion(String.valueOf(question)));

            if (answer == correct_answer) {
                this.correctAnswer();
            } else {
                this.incorrectAnswer(String.valueOf(correct_answer));
            }
        }
    }
}
