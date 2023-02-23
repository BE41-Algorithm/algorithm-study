# 알고리즘 스따디

## 팀원

|김정희|                                                                          김찬빈                                                                          |박성호|이재혁|
|:---:|:-----------------------------------------------------------------------------------------------------------------------------------------------------:|:---:|:---:|
|<img alt="김정희" src="https://user-images.githubusercontent.com/80394894/215561134-da53fca5-b85c-4d2f-b077-e83a707f3de0.png" height="100" width="100">| <img alt="김찬빈" src="https://user-images.githubusercontent.com/108569685/217835551-1572b6af-e7d7-4ca4-a184-d5fbec193352.png" height="100" width="100"> |<img alt="박성호" src="https://user-images.githubusercontent.com/80394894/215555107-23fa07fe-fe13-4fe2-8c2f-572ba9f3917c.png" height="100" width="100">|<img alt="이재혁" src="https://user-images.githubusercontent.com/95069395/215324198-c238be32-d721-4c18-8cea-e56f8ca35486.png" height="100" width="100">|
|**행동대장**|                                                                     **죄송합니다 NPC**                                                                     |**옴닉**|**물개**|
</br>


## 스터디 규칙
- 스터디 모임 시 최소 1문제 이상 푼 문제 설명하기
- 최대한 자기의 힘으로 풀기(권장)
- 적극적으로 피드백 해주기!
- 회의 미참여시 풀었던 문제를 블로그에 올린 후 링크 보내주기(실패한 문제도 OK)
- 알고리즘 코드 내용에 주석 달기
- 

## 스터디 일정
- 매주 목요일 오전 10시 부터
- 최소 30분 최대 2시간

## 깃 컨벤션
### 브렌치 전략
- 브렌치명 : [feat][이름]
  - 예시) feat/psh
  
### 커밋 메시지와 PR 방법
- 커밋 메시지 : Title: 귤 고르기, Time: 66.54 ms, Memory: 110 MB
- Feature 브렌치에서 main으로 PR
- Fork해서 PR
- 알잘딱깔센

### 패키지 및 문제 생성 방법
- 문제를 패키지로 생성하고 각 문제에 대한 자신의 코드 클래스 작성
- 클래스 명은 자유롭게 작성 가능하지만 구분 가능할 정도
- 예시) src/programmers/hash1/Psh.java

### 문제 코드 작성
- 백준 허브의 결과 내용 올리기!
- 코드 내용에 주석으로 설명 남기기!
```Java
public class Psh {
    public int solution(int[] nums) {
    
        ...
        
        // 설명1
        int possible = nums.length / 2;
        
        // 설명2
        nums = Arrays.stream(nums).distinct().toArray();
        
        ...
    }
}

```
