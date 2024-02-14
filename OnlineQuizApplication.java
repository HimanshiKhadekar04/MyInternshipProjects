import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question {
    private String questionText;
    private List<String> options;
    private int correctAnswerIndex;

    public Question(String questionText, List<String> options, int correctAnswerIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }
}

class Quiz {
    private List<Question> questions;
    private int score;

    public Quiz(List<Question> questions) {
        this.questions = questions;
        this.score = 0;
    }

    public void start() {
        try (Scanner scanner = new Scanner(System.in)) {
            for (Question question : questions) {
                System.out.println(question.getQuestionText());
                List<String> options = question.getOptions();
                for (int i = 0; i < options.size(); i++) {
                    System.out.println((i + 1) + ". " + options.get(i));
                }

                System.out.print("Enter your answer (1-" + options.size() + "): ");
                int userAnswer = scanner.nextInt();

                if (userAnswer == question.getCorrectAnswerIndex() + 1) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Incorrect!");
                }
            }
        }

        System.out.println("Quiz completed! Your score: " + score + "/" + questions.size());
    }
}

public class OnlineQuizApplication {
    public static void main(String[] args) {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Number of primitive data types in Java are?",
                List.of("6", "7", "8", "9"), 3));
        questions.add(new Question("What is the size of float and double in java?",
                List.of("32&64", "32&32", "64&64", "64&32"), 1));
        questions.add(new Question("Automatic type conversion is possible in which of the possible cases?",
                List.of("byte to int", "int to long", "long to int", "short to int"), 2));
        questions.add(new Question("Arrays in java are-",
                List.of("Object references", "Objects", "Primitive data type", "None"), 2));
        questions.add(new Question("Total constructor string class have?",
                List.of("3", "7", "13", "20"), 3));

        Quiz quiz = new Quiz(questions);
        quiz.start();
    }
}

    

