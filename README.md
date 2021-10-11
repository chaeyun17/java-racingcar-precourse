# 자동차 경주 게임


## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* 제출일자: 2021.10.13(수) 23시 59분까지
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)
* [Pull Request 제출 링크](https://github.com/next-step/java-racingcar-precourse/pulls)
* 이메일로도 제출

## 기능 요구사항
- 주어진 횟수동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 떄는 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼포(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다.
- 우승자가 한 명 이상일 경우, 쉼표(,)로 이름을 구분해 출력한다.
- 사용자가 잘못된 값을 입력할 경우 "[ERROR]"로 시작하는 에러 메시지를 출력 후 입력을 다시 받는다.

## 프로그래밍 요구사항
- JAVA 버전: JDK 8
- `nextstep.utils` 의 Random, Console API 사용
- 주어진 테스트 케이스 만족
- 코드 스타일 컨벤션: [핵데이 자바 코드 컨벤션](https://naver.github.io/hackday-conventions-java/)
- indent `depth`는 1까지
  - `while`문에 `if`문이 있으면 안됨
- java 8에 추가된 `stream API`를 사용하지 않고 구현. `람다`는 사용 가능.
- `else` 예약어 금지. if 조건절에서 return 하는 방식으로 구현
- 함수 내 코드 길이가 `10라인` 초과 금지
- [일급 콜렉션을 사용](https://developerfarm.wordpress.com/2012/02/01/object_calisthenics_/): `콜렉션을 포함한 클래스는 반드시 다른 멤버 변수가 없어야 한다`
- [원시값과 문자열을 포장](https://developerfarm.wordpress.com/2012/01/27/object_calisthenics_4/)
- 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 제외
  - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.
- Junit 5와 AssertJ 를 사용한다.
- 커밋 컨벤션: [AngularJS Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)
  - feat (feature)
  - fix (bug fix)
  - docs (documentation)
  - style (formatting, missing semi colons, …)
  - refactor
  - test (when adding missing tests)
  - chore (maintain)

## 기능 설계
1. 프로젝트 세팅
   1. readme 작성
   2. git 설정
2. 자동차 생성 및 주행 기능
   1. 이름을 가진 자동차 생성
   2. 주행(전진 또는 멈춤)
      1. `4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.`
3. 주행 횟수에 따른 주행 기능
   1. 주행횟수는 사전설정 
   2. 주행 횟수에 따른 자동차 주행
   3. 주행 기록: 한 횟수당 각 자동차 주행 기록(전진, 멈춤)
4. 여러 자동차 주행 기능
   1. 여러 자동차 생성/주행/주행기록
5. 우승자 판단
   1. 여러 자동차의 주행 기록을 기반으로 최종 우승자 판단
6. 사용자 입력 기능
   1. 자동차 이름 입력
   2. 시도 횟수 입력
   3. 게임 시작
7. 주행 결과 출력
   1. 주행 진행 횟수 1회당 각 자동차 주행기록(전진, 멈춤) 출력 
8. 우승자 출력 기능
   1. `우승자가 한 명 이상일 경우, 쉼표(,)로 이름을 구분해 출력한다.`
9. 사용자 입력 검증 기능
   1. 자동차 이름 입력 검증
      1. `자동차 이름은 쉼포(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.`
   2. 에러 처리
      2. `사용자가 잘못된 값을 입력할 경우 "[ERROR]"로 시작하는 에러 메시지를 출력 후 입력을 다시 받는다.`
10. 디버깅 및 개선
    1. 요구사항에 빠진 부분이 없는지 확인
    2. 테스트 케이스를 점검
