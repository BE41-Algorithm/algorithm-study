package src.example.ex1;

public class Psh {
    public String solution(int num) {
        // 짝수와 홀수 판별 - num을 2로 나눈 나머지가 0이면 짝수, 아니면 홀수
        return num % 2 == 0 ? "Even" : "Odd";
    }
}
