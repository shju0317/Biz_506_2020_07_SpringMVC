$(function () {
  /*
    js, jq에서 사용하는 event핸들러
    event핸들러: 사용자(user)가 화면(interface)에 보이는 어떤 대상을
    클릭했을 때(또는 어떤 행위를 했을때)까지 기다리고 있다가
    사용자가 클릭을 하면 function()으로 지정된 코드를 실행하도록 만든 코드블럭
    js의 콜백(call back)함수: function() 코드블럭
  */

  function getPCode() {
    $("#p_code_gen").click(function () {
      $.ajax({
        type: "GET",
        url: `${rootPath}/api/product/get_pcode`,
        success: function (result) {
          $("#p_code").val(result);
        },
      });
    });
  }

  $("#p_code_gen").click(getPCode);
  $("#btn_save").click(function () {
    /*
    js 변수선언 키워드
    var, let, const
    var : public 전역변수 선언, 함수와 함수 간 데이터를 공유
    let : 함수(function) scope형 변수 한번 선언되면 그 변수는 다시 선언할 수 없다.
    const : 상수, 값이 한번 저장되면 그 값은 변경할 수 없다.
     
    ES6(ESCMA2015) 이상의 JS에서는 변수를 선언할 때
    코드 중간에 값을 변경해야 할 필요가 없으면 const
    함수 내에서 변수를 선언할 때는 let
    특별히 public scope로 선언할 때는 var

    고려하는 순서는 const, let, var 순으로 생각하자
    가급적 var는 자제하자
    */
    const p_code = $("#p_code").val();
    const p_name = $("#p_name").val();

    if (p_code == "") {
      if (
        confirm("상품코드는 반드시 필요합니다\n" + "상품코드를 생성할까요?")
      ) {
        getPCode();
      }
      return false;
    }
    if (p_name == "") {
      alert("상품이름은 반드시 입력해야 합니다");
      $("#p_name").focus();
      return false;
    }
    $("form").submit();
  });
});
