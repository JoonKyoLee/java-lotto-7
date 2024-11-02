# java-lotto-precourse

### 🖥️ 프로그램 진행 흐름

1. 로또 발매기를 실행하고 사용자로부터 로또 구입 금액을 입력 받는다. 구입 금액은 1,000원 단위로 입력 받는다.
    ``` 
    "구입금액을 입력해 주세요."
    ```
2. 입력한 구입 금액에 대한 유효성을 검증한다.
    - 구입 금액은 1,000원 단위여야 한다.
3. 구입 금액을 바탕으로 로또를 발행해서 사용자에게 로또 번호를 출력한다. 출력할 때는 오름차순 정렬 해야 한다.
    ``` 
    8개를 구매했습니다.
    [8, 21, 23, 41, 42, 43]
    [3, 5, 11, 16, 32, 38]
    [7, 11, 16, 35, 36, 44]
    [1, 8, 11, 31, 41, 42]
    [13, 14, 16, 38, 42, 45]
    [7, 11, 30, 40, 42, 43]
    [2, 13, 22, 32, 38, 45]
    [1, 3, 5, 14, 22, 45]
    ```
4. 사용자에게 당첨 번호를 입력 받는다. 번호는 쉼표(,)를 기준으로 구분한다.
    ``` 
    당첨 번호를 입력해 주세요.
    ```
5. 당첨 번호에 대한 유효성을 검증한다.
    - 당첨 번호는 6개의 서로 다른 숫자여야 한다. 또한, 1과 45 사이의 숫자여야 한다.
6. 사용자에게 보너스 번호를 입력 받는다.
    ``` 
    보너스 번호를 입력해 주세요.
    ``` 
7. 보너스 번호에 대한 유효성을 검증한다.
    - 보너스 번호는 하나의 숫자이며 당첨 번호와 겹치지 않아야 한다. 1과 45 사이의 숫자여야 한다.
8. 로또 당첨 번호와 사용자의 로또 번호를 비교해서 통계를 계산한다.
9. 당첨 통계를 사용자에게 출력해준다.
    ``` 
    당첨 통계
    ---
    3개 일치 (5,000원) - 1개
    4개 일치 (50,000원) - 0개
    5개 일치 (1,500,000원) - 0개
    5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
    6개 일치 (2,000,000,000원) - 0개
    총 수익률은 62.5%입니다.
    ``` 

### 🚨예외처리 사항 정리

```
사용자가 입력한 금액과 당첨 번호 및 보너스 번호에 대한 예외처리를 진행해야 한다. 
사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 [ERROR]로 시작하는 에러메시지를 출력 후 그 부분부터 다시 입력 받는다.
```

- 공통 부분
    - 값을 입력하지 않은 경우
- 금액에 대한 예외 사항
    - 문자를 입력한 경우(천원, 만원, 십만원)
    - 음수를 입력한 경우(-2000)
    - 천 원 미만의 금액을 입력한 경우(300)
    - 금액이 천 원으로 나누어 떨어지지 않는 수를 입력한 경우(12300)
- 로또 당첨 번호에 대한 예외 사항
    - 6개를 입력하지 않은 경우(1,2,3,4,5 또는 일,이,삼,사,오)
        - 먼저 6개만 확인 후 그 밖의 예외 사항은 다음에 처리한다.
    - 문자를 입력한 경우(1,이,삼,4,5,6)
    - 중복된 수를 입력한 경우(1,2,3,3,3,3)
    - 범위를 벗어난 수를 입력한 경우(1,2,3,4,5,46)
- 보너스 번호에 대한 예외 사항
    - 문자가 포함된 경우(1,2 또는 1@)
    - 범위를 벗어난 수를 입력한 경우(47)
    - 로또 당첨 번호와 중복된 값을 입력한 경우

---

### 💻 구현 목록 정리

#### 사용자로부터 입력을 받는 부분

- [ ] 올바른 값을 입력하지 않는다면 오류 메시지를 출력하고 다시 입력 받는다.([ERROR]로 시작해야 함)
- [x] 값을 입력하지 않은 경우에 예외 처리를 진행한다.
- [x] 로또 구매금액을 입력 받는다.
    ``` 
    "구입금액을 입력해 주세요."
    ```
    - [ ] 금액에 대한 유효성을 검증한다.
        - [ ] 문자를 입력한 경우
        - [ ] 음수를 입력한 경우
        - [ ] 천 원 미만의 금액을 입력한 경우
        - [ ] 1,000으로 나누어 떨어지지 않는 수를 입력한 경우
- [x] 로또 당첨 번호를 입력 받는다.
    ``` 
    "당첨 번호를 입력해 주세요."
    ```
    - [ ] 당첨 번호에 대한 유효성을 검증한다.
        - [ ] 6개를 입력하지 않은 경우
            - 먼저 6개만 확인 후 그 밖의 예외 사항은 다음에 처리한다.
        - [ ] 문자를 입력한 경우
        - [ ] 중복된 수를 입력한 경우
        - [ ] 범위를 벗어난 수를 입력한 경우
- [x] 보너스 번호를 입력 받는다.
    ``` 
    "보너스 번호를 입력해 주세요."
    ```
    - [ ] 보너스 번호에 대한 유효성을 검증한다.
        - [ ] 문자가 포함된 경우
        - [ ] 범위를 벗어난 수를 입력한 경우
        - [ ] 로또 당첨 번호와 중복된 값을 입력한 경우

#### 로또 게임 수 계산

- [ ] 금액을 바탕으로 발행 가능한 수를 결정한다.

#### 로또 발행

- [ ] 발행 가능한 만큼 로또를 발행한다.
- [ ] 오름차순으로 정렬해서 저장한다.
- [ ] 발행한 로또를 사용자에게 전달한다.

#### 당첨 번호와 사용자의 로또 번호 비교

- [ ] 당첨 번호와 사용자의 번호를 비교해서 얼마나 일치했는지 확인한다.
- [ ] 5개가 일치했을 경우에는 보너스 번호와 비교한다.
- [ ] 일치한 개수를 바탕으로 등수를 저장한다.

#### 수익률 계산

- [ ] 당첨된 로또 등수들을 종합해 플레이어가 입력한 로또 금액에 대한 수익률을 계산한다.
    - [ ] 수익률은 소수점 둘째자리에서 반올림한다.

#### 사용자에게 출력해야 할 부분

- [ ] 로또 게임 수와 발행된 로또를 출력한다.
    - [ ] 사용자에게 입력받은 로또 금액에 대한 로또 게임 수와 번호를 출력한다.
    ``` 
    8개를 구매했습니다.
    [8, 21, 23, 41, 42, 43]
    [3, 5, 11, 16, 32, 38]
    [7, 11, 16, 35, 36, 44]
    [1, 8, 11, 31, 41, 42]
    [13, 14, 16, 38, 42, 45]
    [7, 11, 30, 40, 42, 43]
    [2, 13, 22, 32, 38, 45]
    [1, 3, 5, 14, 22, 45]
    ```
- [ ] 당첨된 로또의 통계를 출력한다.
    - [ ] 당첨된 등수가 몇 개인지와 수익률을 출력해준다.
    ``` 
    당첨 통계
    ---
    3개 일치 (5,000원) - 1개
    4개 일치 (50,000원) - 0개
    5개 일치 (1,500,000원) - 0개
    5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
    6개 일치 (2,000,000,000원) - 0개
    총 수익률은 62.5%입니다.
    ``` 

#### 저장해야 할 사항

- [ ] 당첨 기준과 금액을 Enum을 적용해 저장한다.
    ``` 
    1등: 6개 번호 일치 / 2_000_000_000
    2등: 5개 번호 + 보너스 번호 / 30_000_000
    3등: 5개 번호 일치 / 1_500_000
    4등: 4개 번호 일치 / 50_000
    5등: 3개 번호 일치 / 5_000
    그 밖의 등수: 2개 이하 일치 / 0
    ```