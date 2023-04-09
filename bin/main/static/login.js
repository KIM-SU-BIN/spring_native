var log_in = function (id, pw) {
    var data = {
        user_id: id,
        user_pw: pw
    }

    var url = "/api/log_in.do";
    $.ajax({
        type: "POST",
        url: url,
        data: data,
        success: function (resp) {
            if (resp.errCode != 0) {
                alert("Error : " + resp.errCode);
                return;
            }

            alert("Log in success");
            window.location.href = "/";
        },
        error: function (request, status, error) {
            alert("<Request Error>\nstatus = " + request.status + "\nresponseText = " + request.responseText + "\nerror = " + error);
        }
    });
}

$("#btn_login").click(function () {
    var user_id = $("#user_id").val();
    var user_pw = $("#user_pw").val();
    alert("btn_login : user_id = " + user_id + ", user_pw = " + user_pw);

    log_in(user_id, user_pw);
});


$(document).ready(function () {
    alert("$(document).ready()");
    //...
});


//join 넘어가기
$("#btn_join").click(function () {
    alert("success");
    window.location.href = "/join";
});

