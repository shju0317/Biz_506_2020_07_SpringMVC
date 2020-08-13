### 주의사항! WAS를 만들면서 외부의 css파일을 link하여 jsp에 부착할 때
* 외부에 css파일을 만들고 style을 저장한 다음 jsp파일에서 link를 하여 사용할 때,
css파일을 변경하고 저장하였지만 화면에 반영되지 않는 경우가 자주 있다.
* 서버 App을 Run As Server로 실행을 하면
tomcat이 jsp파일을 _jsp.java파일로 변환하고 class파일로 컴파일하는데
jsp파일을 변경하면, 그때마다 jsp를 _jsp.java로 변환을 하게 된다.
그래야만 변경된 jsp화면이 사용자에게 보여지게 된다.
* 그런데 css와 같은 파일은 tomcat이 변경된 것을 인지하지 못하고 
Run As Server를 수행했을 때 서버에 올라가 있는 css파일을 갱신하지 않아버린다.
* 그러한 문제로 css파일의 내용을 변경하고 view를 새로고침하여도
변경된 css가 반영이 안된다.
* 이런 문제를 해결하는 트릭으로 css파일에 의미없는 문자열을 부착하여
tomcat에게 파일의 변화됨을 알려줄 수 있다.
* <link href="파일.css?ver=00001"/> 형식으로 link코드를 작성하자
