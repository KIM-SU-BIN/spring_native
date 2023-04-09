//회원가입 버튼 클릭 시 입력된 정보가 비어있는지 확인



//회원가입
var join = function (user_type, user_id, user_pw, user_name, user_phone, address1, address2) {
    var data = {
        user_type: user_type,
        user_id: user_id,
        user_pw: user_pw,
        user_name: user_name,
        user_phone: user_phone,
        address1: address1,
        address2: address2
    }
    var url = "/api/save.do";
    $.ajax({
        type: "POST",
        url: url,
        data: data,
        success: function (resp) {
            if (resp.errCode != 0) {
                alert("Error : " + resp.errCode);
                return;
            }
            alert("Join success");
            window.location.href = "/";
        },
        error: function (request, status, error) {
            alert("<Request Error>\nstatus = " + request.status + "\nresponseText = " + request.responseText + "\nerror = " + error);
        }
    });
}

$("#btn_join2").click(function () {
    var user_type = $("input[name='user_type']").val();
    var user_id = $("input[name='user_id']").val();
    var user_pw = $("input[name='user_pw']").val();
    var user_name = $("input[name='user_name']").val();
    var user_phone = $("input[name='user_phone']").val();
    var address1 = $("input[name='address1']").val();
    var address2 = $("input[name='address2']").val();
    alert("type" + user_type + "user_id" + user_id + "user_pw" + user_pw + "user_name" + user_name + "user_phone" + user_phone + "address1" + address1 + "address2" + address2);

    join(user_type, user_id, user_pw, user_name, user_phone, address1, address2);
});


//아이디 중복확인
$("#check_id").click(function () {
    if ($("input[name='user_id']").val() != '') {
        var url = "/api/checkDuplicateId.do";
        $.ajax({
            type: "POST",
            url: url,
            data: $("input[name='user_id']").val(),
            success: function (resp) {
                if (resp.errCode != 0) {
                    alert("사용 가능한 아이디입니다.");
                } else
                    alert("이미 사용중인 아이디입니다.");
            },
            error: function (request, status, error) {
                alert("<Request Error>\nstatus = " + request.status + "\nresponseText = " + request.responseText + "\nerror = " + error);
            }
        });
    }
});

//주소찾기 
//window.onload
$("#search_address").click(function () {
    alert("주소를 찾자!");
    new daum.Postcode({
        oncomplete: function(data) {
            //주소창에 data.address(결과값) 를 밸류로 설정하기
            $("input[name='address1']").val(data.address);
        }
    }).open();
});


