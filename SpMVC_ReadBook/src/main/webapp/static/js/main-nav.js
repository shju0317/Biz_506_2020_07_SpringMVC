$(function () {
  // 화면에 스크롤이 발생하면
  $(window).scroll(function () {
    let headerHeight = $("header").height(); // header 태그의 높이값
    let windowTop = $(window).scrollTop(); // 화면을 세로방향으로 스크롤할 때 윈도우화면의 최상단 좌표값

    if (windowTop > headerHeight) {
      $("#main-nav").css("position", "fixed");
      $("#main-nav").css("top", "0");
    } else {
      $("#main-nav").css("position", "relative");
    }

    console.log(headerHeight, windowTop);
  });

  // nav li 태그를 클릭했을 때
  $("#main-nav li").click(function () {
    let menu_text = $(this).text();
    if (menu_text === "도서정보") {
      document.location.href = `${rootPath}/books`;
    }
  });
});
