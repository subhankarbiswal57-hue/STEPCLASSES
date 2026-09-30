import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 * Week 8 Practice - Problem 4: Examination Question Grader
 * 
 * Demonstrates polymorphism:
 * Base class Question with subclasses MCQQuestion, TFQuestion, EssayQuestion.
 */
public class PROGRAM4 {

    abstract static class Question {
        protected String questionText;
        protected String correctAnswer;
        protected String studentAnswer;
        protected double points;

        public Question(String questionText, String correctAnswer, String studentAnswer, double points) {
            this.questionText = questionText;
            this.correctAnswer = correctAnswer;
            this.studentAnswer = studentAnswer;
            this.points = points;
        }

        public abstract String getQuestionType();
        public abstract double evaluateScore();
    }

    static class MCQQuestion extends Question {
        public MCQQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
            super(questionText, correctAnswer, studentAnswer, points);
        }

        @Override
        public String getQuestionType() {
            return "MCQ";
        }

        @Override
        public double evaluateScore() {
            return studentAnswer.equals(correctAnswer) ? points : 0.0;
        }
    }

    static class TFQuestion extends Question {
        public TFQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
            super(questionText, correctAnswer, studentAnswer, points);
        }

        @Override
        public String getQuestionType() {
            return "TF";
        }

        @Override
        public double evaluateScore() {
            return studentAnswer.equalsIgnoreCase(correctAnswer) ? points : 0.0;
        }
    }

    static class EssayQuestion extends Question {
        public EssayQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
            super(questionText, correctAnswer, studentAnswer, points);
        }

        @Override
        public String getQuestionType() {
            return "ESSAY";
        }

        @Override
        public double evaluateScore() {
            String[] keywords = correctAnswer.split(",");
            int matched = 0;
            String lowerStudentAnswer = studentAnswer.toLowerCase();

            for (String kw : keywords) {
                String cleanKw = kw.trim().toLowerCase();
                if (!cleanKw.isEmpty() && lowerStudentAnswer.contains(cleanKw)) {
                    matched++;
                }
            }

            if (matched >= 2) {
                return points * 0.75;
            } else if (matched == 1) {
                return points * 0.50;
            } else {
                return 0.0;
            }
        }
    }

    private static List<String> parseTokens(String line) {
        List<String> tokens = new ArrayList<>();
        int i = 0;
        int n = line.length();

        while (i < n) {
            while (i < n && Character.isWhitespace(line.charAt(i))) {
                i++;
            }
            if (i >= n) break;

            if (line.charAt(i) == '"') {
                i++;
                StringBuilder sb = new StringBuilder();
                while (i < n && line.charAt(i) != '"') {
                    sb.append(line.charAt(i));
                    i++;
                }
                if (i < n && line.charAt(i) == '"') {
                    i++; // skip closing quote
                }
                tokens.add(sb.toString());
            } else {
                StringBuilder sb = new StringBuilder();
                while (i < n && !Character.isWhitespace(line.charAt(i))) {
                    sb.append(line.charAt(i));
                    i++;
                }
                tokens.add(sb.toString());
            }
        }
        return tokens;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextLine()) {
            return;
        }
        String firstLine = scanner.nextLine().trim();
        if (firstLine.isEmpty()) {
            return;
        }
        int n = Integer.parseInt(firstLine);
        List<Question> questions = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            List<String> tokens = parseTokens(line);
            if (tokens.size() < 5) continue;

            String type = tokens.get(0);
            String qText = tokens.get(1);
            String correctAns = tokens.get(2);
            String studentAns = tokens.get(3);
            double points = Double.parseDouble(tokens.get(4));

            if ("MCQ".equalsIgnoreCase(type)) {
                questions.add(new MCQQuestion(qText, correctAns, studentAns, points));
            } else if ("TF".equalsIgnoreCase(type)) {
                questions.add(new TFQuestion(qText, correctAns, studentAns, points));
            } else if ("ESSAY".equalsIgnoreCase(type)) {
                questions.add(new EssayQuestion(qText, correctAns, studentAns, points));
            }
        }

        double totalScore = 0.0;
        for (Question q : questions) {
            double score = q.evaluateScore();
            System.out.printf("%s: %.2f\n", q.getQuestionType(), score);
            totalScore += score;
        }

        System.out.printf("Total Score: %.2f\n", totalScore);
        scanner.close();
    }
}
