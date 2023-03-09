package src.programmers.bruteforce.bruteforce2;

import java.util.ArrayList;
import java.util.List;

class Chanbin {
    // 학생1, 2, 3의 찍기 패턴
    int[] student1GuessPattern = {1, 2, 3, 4, 5};
    int[] student2GuessPattern = {2, 1, 2, 3, 2, 4, 2, 5};
    int[] student3GuessPattern = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    // 각 패턴별 index를 관리할 변수 선언
    int index1 = 0;
    int index2 = 0;
    int index3 = 0;

    // 각 학생이 맞춘 정답의 개수
    int student1AnswerCount = 0;
    int student2AnswerCount = 0;
    int student3AnswerCount = 0;

    public int[] solution(int[] answers) {
        int[] answerCounts = new int[3];

        for (int answer : answers) {
            // 각 학생의 찍은 답
            int guess1 = student1GuessPattern[index1];
            int guess2 = student2GuessPattern[index2];
            int guess3 = student3GuessPattern[index3];

            // 답이 맞았는지 확인. 맞았다면 정답 개수 +1
            if (isAnswer(answer, guess1)) student1AnswerCount++;
            if (isAnswer(answer, guess2)) student2AnswerCount++;
            if (isAnswer(answer, guess3)) student3AnswerCount++;

            // 인덱스 관리
            index1 = manageIndex(student1GuessPattern.length - 1, index1);
            index2 = manageIndex(student2GuessPattern.length - 1, index2);
            index3 = manageIndex(student3GuessPattern.length - 1, index3);
        }

        answerCounts[0] = student1AnswerCount;
        answerCounts[1] = student2AnswerCount;
        answerCounts[2] = student3AnswerCount;

        return findStudentsByMostCorrectAnswers(answerCounts);
    }

    // 정답 체크
    private boolean isAnswer(int answer, int guess) {
        return answer == guess;
    }

    // 찍기 패턴의 길이가 넘지 않도록 0으로 초기화
    private int manageIndex(int lastIndex, int guessIndex) {
        if (lastIndex == guessIndex) return 0;
        return guessIndex + 1;
    }

    // 가장 많은 정답을 맞춘 학생을 찾아주는 메서드
    private int[] findStudentsByMostCorrectAnswers(int[] answerCounts) {
        int max = 0;
        int answerCount;
        int student;

        List<Integer> students = new ArrayList<>();

        for (int i = 0; i < answerCounts.length; i++) {
            answerCount = answerCounts[i];
            student = i + 1;

            if (max < answerCount) {
                max = answerCount;
                students.clear();
                students.add(student);
            } else if (max == answerCount) {
                students.add(student);
            }
        }

        return students.stream().mapToInt(i -> i).toArray();
    }
}
