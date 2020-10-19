# 자유게시판 프로젝트

### 회원가입, 로그인이 필요없는 자유게시판 만들기
* 기본 CRUD 구현
* 페이지네이션
* 파일업로드 : 이미지 갤러리 형식으로
* MySQL, Oracle DB 사용
* 검색 기능
* 말머리 기능

### 화면 layout
* tiles를 활용한 화면 layout

### DBMS
* oracle, mysql, mybatis, dbcp2를 활용

### 추가기능
* oracle, mysql의 username,password 암호화

### context.xml 파일의 위치
* spring framework 프로젝트에서 권장하는 위치는 /WEB-INF/* 이다
* 전자정부 프레임워크 등 일부 프로젝트에서 src/main/* 폴더에 *.xml파일을 위치하는 경우가 있다
* src/main/* 폴더에 *.xml 파일이 위치할 경우 web.xml에서 경로 설정은 classpath:/**/root-context.xml 이라고 사용한다
* 실제 프로젝트에서 src/main/* 폴더에 *.xml 파일을 위치할 경우
* 프로젝트가 시작될 때 프로젝트의 모든 패키지를 검색하는 경우가 있어서 시작 퍼포먼스가 문제가 되는 경우가 있다
* 하지만 시중 프로젝트에서 상당히 많이 이러한 방식으로 사용을 하고 있기 때문에 관심을 가질 필요가 있다

* classpath:/*/mycontext.xml -> src/main/*/mycontext.xml 파일을 찾아라
* classpath:/**/mycontext.xml -> src/main/*/mycontext.xml, src/main/*/*/*/mycontext.xml 을 뒤져서  파일을 찾아라

* classpath에 context.xml을 위치시킬 경우 web.xml의 파일이름에 가급적 와일드카드(*)를 사용하지 말자
* root-context.xml을 *-context.xml 로 설정할 경우, root-context.xml 뿐만 아니라 servlet-context.xml 파일도 스캔하고
읽어서 설정한느 중간에 프로젝트가 심각한 문제를 일으키는 경우가 있다.

### /WEB-INF/ 폴더
* 이 폴더는 tomcat서버에서 구동되는 어플리케이션에서는 가장 보안이 잘 되는 폴더이다.
* 이 폴던느 client에서 특별한 경우가 아니면 직접 접근이 불가능하다
* 따라서 *.xml파일이나, 중요한 설정 파일들은 다른 곳에 위치하지 말고 이곳에 저장하는 것이 좋다

### tiles를 이용한 layout
* 최근 프로젝트에서는 많이 사용하지 않지만, 전통적으로 spring framework 프로젝트에서 사용하던 layout 관리 도구
* 전자정부 프레임워크의 상당부분 프로젝트에서 지금도 많이 활용하고 있다.
* spring framework 프로젝트에서 오랫동안 사용하던 layout 도구이고, 현재는 버전업이 중단되었지만 비교적 사용하기 간편하여 많이 활용한다

* layout에 해당하는 jsp를 만들고, 다른 jsp파일을 *.xml파일에 설정하여 자동으로 layout을 만들어주는 도구이다