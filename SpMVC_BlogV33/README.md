# WAS: Web Application Service(Server)
* Web Browser를 사용하여 Server와 통신을 하면서 어떤 일을 수행하는 어플리케이션.
* 클래스에 포함된 method는 함수라고 표현하자

## Web Browser에서 Server로 보내는 Request
* a href="주소": Hyper Text를 보여주고, Hyper Text를  클릭했을 때 Server로 Request를 보내는 가장 기본적인 형태
이 Request를 Controller에서 받아 처리할 때는 method=Request.GET로 지정된 함수가 연산을 수행하는 처리를 한다.

* form tag의 button을 클릭했을 때 Server로 보내는 Request
input box에 문자열을 입력한 후 button을 클릭하면 그 문자열들을 Query String이라는 형식으로 바꾸어서
Server에 한꺼번에 Request한다.

* form tag에 특별히 method를 지정하지 않으면
Controller에서 처리할 때는 method=Request.GET로 지정된 함수가 처리한다.

* form tag에 mehtod를 지정(통상 POST)하면
Controller에서 처리할 때는 지정된 method의 처리가 표현된 함수가 처리한다.

## Request, Response
* Req_1 (a href="input") == Res_1 (write.jsp)
* Req_2 (write.jsp, form, input, button click) 
==> Controller 
==> write(String title, String content)
* Res_2(write 함수에서 model에 TITLE, CONTENT attribute를 설정하고, view.jsp와 Rendering)
==> html코드를 보내주기
