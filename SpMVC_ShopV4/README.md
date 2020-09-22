# spring Project 빛나리 쇼핑몰 V1
* 상품관리, 거래처관리, 회원가입, 로그인을 포함
* DB 오라클
* 반응형 메뉴를 사용, 반응형 메인화면 구현

## Project 시작
* Java Version 1.8로 변경
* Spring Framework 5.2.8
* lombok, logback dependency 설정
* views/home.jsp 삭제 후 재생성
* Run Service 수행하여 home화면이 나타나도록

## DB연동 설정(pom.xml)
* spring-jdbc
* mybatis
* mybatis-spring
* commons-dbcp2
* ojdbc6

* spring/appServlet/mybatis-context.xml 파일 생성,작성

## URL(Uniform Resource Location), URI(Uniform Resource Identifier)
* URL : 파일식별자
* URI : 통합자원식별자 
* ex) http://localhost:8080/shop/index.html
* -> URL(http://localhost:8080/) + Query(shop/index.html) = URI
### View단에서 사용하는 URL
* <a href="http://localhost:8080/shop/"> 서버 Home</a>
tomcat WAS에게 shop이라는 Context를 가진 project가 작동되고 있는지 물어보는 request
* <a href="http://localhost:8080/shop/product/list">상품리스트</a>
shop Context의 Dispatcher에게 product/list를 수행할 수 있는 Controller method가 있는지 물어보는 request
* 이 HTML 코드를 화면에서 만나면 HyperText(anchor문자열)를 클릭했을 때 서버에 request한다
이 때 수행하는 request는 method=RequestMethod.GET 설정된 함수에서 처리한다.

* href : Hyper Text Reference, URL주소라고 생각하면 됨.

### HTML코드에서 GET method로 Request를 요청하는 곳들
* anchor tag : <a href="주소">텍스트</a>

* script에서 : document.location.href="주소"
* script에서 : document.location.replace("주소")

* css 가져오기 : <link rel="stylesheet" href="주소">
* script 가져오기 : <script src="주소"></script>
* 이미지 보이기 : <img src="주소"/>
* 배경이미지 : background-image : url("주소")

*** 
***
# Spring Project 빛나리 쇼핑몰 V3

### 상품관리 거래처 관리 이후에 회원가입, 로그인 구현

### session
* Hyper Text
 : Anchor Tag로 구성된 Text를 Web browser에서 클릭했을 때
   해당하는 단어의 설명하는 새로운 문서가 열리는 구조로 된 문서
* HTML(Hyper Text Markup Language)
 : Hyper Text기능을 구현하는 데 사용되는 마크업 언어
* HTTP(Hyper Text Transfer Protocol)
 : Hyper Text로 구성된 문서를 Web browser에서 보여주고
   사용자가 마우스로 Anchor tag를 클릭하면 그에 따른 다른 문서를
   연속해서 보여주는 용도로 최적화된 인터넷 프로토콜
* HTTP의 특징 중 하나는 단방향이다.
 1. web client에서 서버에 request를 보냈을 때만 서버에서 response를 할 수 있다.
 2. 한번 req-res가 이루어지면 그 연결은 끊어진다.

* 서버의 어떤 연산을 요청할 때 요청하는 정보가 누구나 봐서는 안되는 정보라고 가정
서버에 연산을 요청할 때 '나는 그 정보를 봐도 되는 권한을 가지고 있다.'라고 알려줘야 한다.
* 이러한 절차를 보통 '로그인(id, pwd)'이라고 한다.
* 서버는 client req에서 사용자의 로그인 정보가 포함되어 있으면 그 정보를 확인하여
정상적인 로그인 정보인지를 확인한다 = '인증'
* 확인이 되면 요청한 정보를 client에게 response한다.
* HTTP는 즉시 client로부터 받은 모든 정보(id, pwd 포함)를 삭제한다.
* 이후에 또다시 client같은 정보를 요청할 때는 다시 id,pwd를 request에 같이 실어서 보내야 한다.
* 서버로부터 request해야 할 정보가 여러 page에 있을 경우 매 page를 요청할 때마다
* id와 pwd를 보내고 인증 후 response하는 절차를 반복해야 한다.
* 불편해!!!
* 이러한 불편을 해결하기 위해서 'HTTPSession'이라고 하는 보조 프로토콜을 만들어두었다.

## HTTP Session(=연결통로가 만들어졌다)
1. client에서 로그인을 시도, id와 pwd를 먼저 request한다.
2. 인증절차: server에서 사용자가 보낸 id와 pwd를 확인하여 정상적인 정보인지 검사
3. 서버는 정상적인 사용자임이 확인되면 서버메모리 어딘가에 HTTPSession정보를 저장하기 위해
공간을 마련한다.
4. 이 공간에는 HTTPSession 규격에 따라 서버가 데이터를 보관한다.
5. 이 공간에는 Session ID라고 하는 식별자(PK)를 만들어 둔다.
6. Server가 client에게 response를 할 때 response정보에 생성된 SessionID를 같이 부착하여 보낸다.
7. web browser는 서버로부터 전달된 response에 HTTPSession 규격에 해당하는 SessionID가 있으면
Browser의 임시저장소에 보관한다.
8. 이후에 client가 server에 request하면, browser는 이 SessionID를 Request에 같이 부착하여 server로 보낸다.
9. server에서 request를 수신했을 때 HTTPSession 규격에 맞는 SessionID가 있으면,
서버가 정상적으로 발행(=resposne에 부착하여 보낸)한 SessionID이고, 유효기간이 정상적이라면,
이 요청은 '인가된' client로부터 전달된 것임을 확인하고 이후 response를 수행한다.


## 빛나리 쇼핑몰 V4

#### V3의 회원가입 문제점
* 기본 CRUD 모두 구현이 가능
* 회원정보 중에서 민감한 정보(비밀번호)가 평문(Plain Text)으로 저장되어서
누군가 회원정보 DB SELECT하게 되면 ID와 PASSWORD가 노출되어 보안상 매우 위험한 상황이 될 수 있다.

### v3의 로그인 문제점
* 로그인이 필요한 기능을 사용자가 선택(메뉴에서)을 하면, 로그인된 정보가 있는지 확인하여
없으면 로그인을 수행하도록 redirection이 된다.
* 각각의 Controller/method에서 사용자 로그인 정보를 검사를 수행하고 있다.
* 만약 로그인이 필요한 기능이 많아진다면 상당히 불편한 상황이 발생한다.
  로그인을 검사하고 인증하는 절차에 해당하는 코드가 중복 작성되어야 한다.
  
#### V4에서 회원가입, 로그인의 개선사항
* 회원정보 중 민감한 정보를 암호화하여 DB 테이블에 저장해야 한다.
   - BCrypt 암호화
* 로그인 검사와 관련 코드 중 중복되는 코드를 모아서 처리하자.
   - intercepter 추가
