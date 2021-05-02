# 자동차 경주 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 요구사항
* 주어진 횟수동안 n대의 자동차는 전진 또는 멈출수있다.
* 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할때 자동차 이름을 같이 출력한다.
* 자동차이름은 쉼표(,)를 기준으로 구분하며 이름은 5자이하만 가능하다.
* 사용자는 몇번의 이동을 할것인지를 입력할 수 있어야한다.
* 전진하는조건은 0에서9사이에서 random값을 구한후 random 값이 4이상 일 경우 전진하고,3이하의 값이면 멈춘다.
* 자동차경주게임을완료한후누가우승했는지를알려준다.우승자는한명이상일수있다.

## 구현 기능 목록
* [ ] 자동차 경주 기능
    * 입력된 자동차들 경주 기능
* [X] 자동차 전진 멈춤 판단 기능
    * 원시값 포장 MoveDistance 객체 생성
        * 4이상 입력 시 이동
        * 3이하 값 입력 시 멈춤
        * 이동 거리 비교 기능
* [ ] 경주 자동차 최대 주행 거리값 계산 기능
    * 자동차들의 이동 거리를 비교하여 최대 이동 거리 반환
* [ ] 우승자 판별 기능
    * 최대 이동 거리 기준으로 같은 거리 이동한 자동차 리스트 반환
* [ ] 경주할 자동차 입력 기능
    * 일급 컬렉션 RaceCars 객체 생성
    * 사용자 입력값 유효성 검사 기능
        * ','로 구분되어 있는지 확인
        * 같은 이름이 포함되어 있는지 확인
        * 두대 이상의 차량이 입력되었는지 확인
    * 원시값 포장 CarName 객체 생성
        * 입력된 자동차 이름 좌우 공백 제거
        * 입력된 자돋차 이름이 0보다 크고 5보다 작거나 같은지 확인
* [X] 주행 횟수 입력 기능
    * 원시값 포장 RacingCount 객체 생성
        * 사용자 입력값이 0보다 큰지 확인
    * 문자열 입력 처리 시 에러 처리
* [X] 랜덤값 생성 기능
    * 원시값 포장 RandomNumber 객체
        * 입력된 random 값이 0에서 9사이 값인지 확인  
