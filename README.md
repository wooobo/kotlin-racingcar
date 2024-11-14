# kotlin-racingcar

## 공통사항

- [Coding Conventions](https://kotlinlang.org/docs/coding-conventions.html)
  와 [Kotlin style guide](https://developer.android.com/kotlin/style-guide?hl=ko)를 원칙으로 한다.

## 컨벤션 설정

```shell
./gradlew ktlintApplyToIdea
mkdir .git/hooks
./gradlew addKtlintCheckGitPreCommitHook
```

- `verification/check` 하기

## 특이사항

- KoTest 알아보기

## 1단계 요구사항

- JAVA 스타일의 Person class를 코틀린으로 변환한다. (Person.java -> Person.kt)
    - [X] 이름 붙인 인자
    - [X] 널 타입
    - [X] 기본 인자
    - [X] 데이터 클래스

## 2단계 문자열 사칙 연산 계산기 구현 요구사항
### 요구사항
1. 입력 값에 따라 계산 순서가 결정된다(수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시)
2. 예시: "2 + 3 * 4 / 2" = 10

### 프로그래밍 요구 사항
- 메서드가 너무 많은 일을 하지 않도록 분리하기 위해 노력해 본다.
- 공백 문자열을 빈 공백 문자로 분리하려면 String 클래스의 split(" ") 메소드를 활용

### 작업목록
- [X] 입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
- [X] 사칙연산 기호가 아닌 경우 IllegalArgumentException throw
- [X] 덧셈
- [X] 뺄셈
- [X] 곱셈
- [X] 나눗셈
- [X] 객체 분리 리팩토링

### 2단계 피드백
- [ ] sealed interface 사용하여 책임 분리
- [ ] .fold() 를 활용
- [ ] enum abstract 함수 -> override로 전환해보기
- [ ] NodeTest ParameterizedTest 사용해보기
- [ ] assertEquals -> assertThat
- [ ] @EmptySource
