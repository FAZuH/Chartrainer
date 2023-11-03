package com.fazuh.chartrainer;


public class MathChar extends TrainerBase {
    MathChar(int attempts) {
        super(attempts);
    }

    public void run() {
        while (this.isSession) {

            String answer;
            int question = this.generateQuestion();
            String correct_answer = String.valueOf(this.intToChar(question));

            // Math question logic
            if (this.rand.nextBoolean()) {
                int rand_temp = this.rand.nextInt(question);
                int left_side = question - rand_temp;
                int right_side = question - left_side;
                answer = Colour.askQuestion(this.intToChar(left_side) + "+" + this.intToChar(right_side));
            } else {
                int left_side = this.rand.nextInt(question , 27);
                int right_side = left_side - question;
                answer = Colour.askQuestion(this.intToChar(left_side) + "-" + this.intToChar(right_side));
            }

            if (answer.equals(correct_answer)) {
                this.correctAnswer();
            } else {
                this.incorrectAnswer(correct_answer);
            }
        }
    }
}
