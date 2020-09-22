$(function () {
  function getDCode() {
    $("#d_code_gen").click(function () {
      $.ajax({
        type: "GET",
        url: `${rootPath}/api/dept/get_dcode`,
        success: function (result) {
          $("#d_code").val(result);
        },
      });
    });
  }

  $("#d_code_gen").click(getDCode);
  
  $("#btn_save").click(function () {
    const d_code = $("#d_code").val();
    const d_name = $("#d_name").val();

    if (d_code == "") {
      if (
        confirm("거래처코드는 반드시 필요합니다\n" + "거래처코드를 생성할까요?")
      ) {
        getDCode();
      }
      return false;
    }
    if (d_name == "") {
      alert("거래처이름은 반드시 입력해야 합니다");
      $("#d_name").focus();
      return false;
    }
    $("form").submit();
  });
});
