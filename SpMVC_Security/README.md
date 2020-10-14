# spring web tiles project

### spring에서 전통적으로 많이 사용하던 layout관리자
### 최근 4-5년 전부터 인기가 시들해졌지만, 전자정부 프레임워크에서는 지금도 표준 layout처럼 사용되고 있다.

### tiles dependency 가져오기
* tiles-core, tiles-extras

### tiles-layout.xml 설정하기
* jsp를 이용하여 화면 layout을 꾸미는 방법을 정의하는 파일
* tiles-definitions 태그 사이에 layout을 꾸미는 방법을 기술
* xml 파일의 태그를 정의할 때 태그이름이 복수형으로 되어있다는 것은 태그 내부에 단수형으로 여러개의 설정내용이 정의된다.

* 정의 방법
1. layout.jsp 파일을 default라는 이름으로 정의
2. layout.jsp attribute로 등록한 이름들을 tiles-layout.xml에 put-atttribute로 등록하기
3. views 폴더에 layout폴더를 만들고 header.jsp, menu.jsp, content.jsp, footer.jsp를 만들기

### tiles-context.xml 파일의 UrlBaseResolver bean을 설정할 때 유의사항
* 일반적으로 spring에서는 bean에 bean을 주입할 때 미리 bean을 만들고 id를 통해서 주입한다.
* tiles에서 tilesView 클래스를 UrlBaseResolver에 bean으로 주입할 때는 그러한 일반적인 방식으로 주입하면 안된다.
* 반드시 직접 TilesView 클래스이름을 value값에 문자열로 주입하는 방식을 사용해야 한다.
* 여기에서 TilesView 클래스를 valueㄱ밧에 문자열로 지정을 하는 데 자동완성이 안된다.
* 이럴때는 임시로 bean을 하나 만들고 class값에 TilesView를 입력한 후 클래스 이름을 자동완성하여 그 문자열을 잘라붙이고 수행하면 된다.
* order porperty의 value값을 반드시 1로 설정해주어야 한다.

### tiles-context.xml을 설정한 후 servlet-context.xml의 변경사항 추가
* InternalResourceViewResolver의 order 속성을 반드시 2이상의 값으로 지정해주어야 한다.
* tilesView를 사용하는 ulrBaseResolver를 우선순위 1, InternalResolver를 우선순위 2로 변경하는 것이다.
