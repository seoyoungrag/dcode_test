# 엔코드 관련 서영락

## 프로젝트 진행 과정 요약

### 1. 데이터베이스 설계
#### 1-1. 요구사항 확인(메일)
#### 1-2. 데이터 표준화 정의 및 표준용어사전 작성
#### 1-3. 논리 모델링 작성(da#)
#### 1-4. 물리 모델링 작성(da#)
#### 1-5. 스크립트 자동화 기능으로 데이터베이스 생성(da#)

### 2. 프로젝트 기본 셋팅
#### 2-1. spring boot 2.x 기반 생성 및 spring-data-jpa, swagger-ui, 로깅 등 기본 디펜던시 추가
#### 2-2. db 리버싱으로 기본 entity 생성(hibernate 이용)
#### 2-3. 기본 read interface 및 api 생성 테스트
#### 2-4. tdd 셋팅(test 코드 샘플 작성)
#### 2-5. swagger-ui 및 exception advice, response 공통 모듈 등 셋팅
#### 2-6. mybatis는 추가했으나, jpa 버전을 먼저 만들고 여유가 되면 mybatis 버전으로 만들기.

### 3. 애플리케이션 설계
#### 3-1. 데이터 모델링과 애플리케이션 기본 셋팅 기반으로 class diagram 작성(visual paradigm)
##### 3-1-2. domain driven develop 패턴으로 goodsSale와 상품판매명과 상품판매가격생성 로직을 추가, goodsSaleShape에는 연관관계편의메소드만 추가됨.
##### 3-1-3. 마찬가지로 transaction script로 뺄만한 로직이 별로 없어 모델-컨트롤러-리파지터리 레이어로 설계
#### 3-2. 테스트 코드 때문에 명명이 안맞을 수는 있으나, 일단 정리가능한 정도면 우선순위 낮춰서 진행하자.

### 4. 문서 정리
#### 4-1. swagger-ui로 API 문서 대체 가능여부 확인. 가능할 것 같음.
#### 4-2. 데이터 설계 문서 점검(표준용어 및 erd)
#### 4-3. 애플리케이션 설계 문서 점검(클래스다이어그램)

### 5. to-be 문서 생성(여유 되면)
#### 5-1. 한 상품판매형태가 복합적으로 표현되어야 할 경우, 상품판매 엔터티와 상품판매형태 엔터티를 결합하면 된다.
#### 5-2. 상품판매형테를 데이터 모델링의 서브타입모델과 oop의 상속관계로 표현하면 더 확장이 용이하다.
#### 5-3. 언급되지 않은 재고 관리, 사용자 정보 등에 대한 확장 작성

### 데이터 모델링 문서
![data_standard_1](https://user-images.githubusercontent.com/9579667/97805287-87918600-1c98-11eb-8704-da09d40caad0.jpg)
![data_standard_2](https://user-images.githubusercontent.com/9579667/97805290-895b4980-1c98-11eb-81de-3e3ae908d615.jpg)
![data_standard_3](https://user-images.githubusercontent.com/9579667/97805291-895b4980-1c98-11eb-95c7-3dec9590b1fc.jpg)
![data_standard_4](https://user-images.githubusercontent.com/9579667/97805292-89f3e000-1c98-11eb-97ac-2e77f736982d.jpg)
![logical_erd](https://user-images.githubusercontent.com/9579667/97805293-89f3e000-1c98-11eb-9216-075c2b000db7.png)
![physical_erd](https://user-images.githubusercontent.com/9579667/97805294-8a8c7680-1c98-11eb-9e97-da5bb1831f2a.png)

### 클래스다이어그램 문서
![classdiagram](https://user-images.githubusercontent.com/9579667/97805296-8b250d00-1c98-11eb-85de-1c33de218327.jpg)


