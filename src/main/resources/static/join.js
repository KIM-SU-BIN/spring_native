//회원가입, 입력된 정보 확인
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

    //유효성 검사
    var user_pw = $("input[name='user_pw']").val();
    var user_name = $("input[name='user_name']").val();
    var user_phone = $("input[name='user_phone']").val();

    var check_pw = RegExp(/^[a-zA-Z0-9]{4,10}$/);
    var check_name = RegExp(/^[a-zA-Z0-9]{4,10}$/);
    var check_phone = RegExp(/^[a-zA-Z0-9]{4,10}$/);

    if (!check_pw.test(user_pw)) {
        alert('PASSWORD = ' + user_pw + '영문 및 숫자만 4-10자리까지 입력해주세요.');
        $('#user_pw').val("");
        $('#user_pw').focus();
        return false;
    }
    if (!check_name.test(user_name)) {
        alert('NAME = ' + user_name + '기호는 사용이 불가합니다.');
        $('#user_name').val("");
        $('#user_name').focus();
        return false;
    }
    if (!check_phone.test(user_phone)) {
        alert('PHONE = ' + user_phone + '기호는 사용이 불가합니다.');
        $('#user_phone').val("");
        $('#user_phone').focus();
        return false;
    }   //검사 끝

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

//유효성 검사 실패!
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

    if ($('#user_id').val() == '') {
        alert("아이디를 입력해주세요.")
        return;
    }

    //아이디 특수기호 사용 불가
    var user_id = $("input[name='user_id']").val();
    var check_id = RegExp(/^[a-zA-Z0-9]{4,10}$/);

    if (!check_id.test(user_id)) {
        alert('ID = ' + user_id + '영문 및 숫자만 4-10자리까지 입력해주세요.');
        $('#user_id').val("");
        $('#user_id').focus();
        return false;
    }

    $.ajax({
        type: "POST",
        url: "/api/checkDuplicateId.do",
        data: { "user_id": $('#user_id').val() },
        success: function (resp) {
            if (resp.errCode == 0) {
                alert("사용 가능한 아이디입니다.");
            } else {
                alert("이미 사용중인 아이디입니다.");
            }
        },
        error: function (request, status, error) {
            alert("아이디 중복 ajax 에러입니다.");
            alert("<Request Error>\nstatus = " + request.status + "\nresponseText = " + request.responseText + "\nerror = " + error);
        }
    });
});


//주소찾기 
$("#search_address").click(function () {
    new daum.Postcode({
        oncomplete: function (data) {
            //주소창에 data.address(결과값) 를 밸류로 설정하기
            $("input[name='address1']").val(data.address);
        }
    }).open();
});


//취소 버튼
$("#btn_cancle").click(function () {
    window.location.href = "/";
});


// --------------- 팝업영역 --------------- //
//팝업 열기
function agreePopup() {
    document.getElementById("popup_layer").style.display = "block";
}
//팝업 닫기
function closePop() {
    document.getElementById("popup_layer").style.display = "none";
}

//팝업 전체 동의 
$(".join_agreement").on("click", "#check_all", function () {
    var checked = $(this).is(":checked");

    if (checked) {
        $(this).parents(".join_agreement").find('input').prop("checked", true);
    } else {
        $(this).parents(".join_agreement").find('input').prop("checked", false);
    }
});

//팝업 개별 선택
$(".join_agreement").on("click", ".chk_join", function () {
    var is_checked = true;

    $(".join_agreement .chk_join").each(function () {
        is_checked = is_checked && $(this).is(":checked");
    });

    $("#check_all").prop("checked", is_checked);
});

// --------------- 카카오 회원가입 --------------- //
Kakao.init('78eaf46aa96ab0bda56f93f01a767552');       //고유 API키

// 카카오 로그인 버튼 생성
/*Kakao.Auth.createLoginButton({
  container: '#kakao-login-btn',
  success: function(authObj) {
    // 로그인 성공시 처리할 코드 작성
    kakaoLogin(authObj.access_token);
  },
  fail: function(err) {
    // 로그인 실패시 처리할 코드 작성
    console.log(err);
  }
});

// 카카오 로그인 처리 함수
function kakaoLogin(accessToken) {
  // 로그인 처리 후 작성할 코드 작성
  console.log(accessToken);
}
*/

// function kakaobtn() {
//     Kakao.Auth.login({
//         success: function(response) {
//             Kakao.API.request({                        // 사용자 정보 가져오기
//                 url: '/v2/user/me',
//                 success: (response) => {
//                 	var kakaoid = response.id+"K";
//                     $.ajax({
//     					type : "post",
//     					url : '/api/checkId.do', // ID중복체크를 통해 회원가입 유무를 결정한다.
//     					data : { "user_id":kakaoid },
//     					//dataType:"json", -> 오류
//     					success : function(json){
//                             if(json.idExists){
//                                 // 존재하는 경우 로그인 처리
//     							createHiddenLoginForm(kakaoid);
//     						} else{
//                                 // 회원가입
//                              $.ajax({
//     								type : "post",
//     		    					url : '/api/kakaoSignUp.do',
//     		    					data : {
//                                             "user_id":kakaoid,
//     		    						    "name":response.properties.nickname,    //유효하지 않은 nickname
//     		    						    //"email":response.kakao_account.email
//                                         },
//     		    					//dataType :"json",
//     		    					success : function(json){
//     		    						if(json.success){
//     		    							// 로그인
//                                             alert("2번째 ajax 로그인 성공");
//     		    							createHiddenLoginForm(kakaoid);
//     		    						} else {
//     		    							alert('카카오 회원가입 실패. 일반계정으로 로그인하시기 바랍니다.');
//     		    						}
//     		    					},
//     		    					error: function(request, status, error){
//     		    		                   alert("code: "+request.status+"\n"+"message: "+request.responseText+"\n"+"error: "+error);
//     		    		                }
//     							});
//     						}
//     					},
//     					error: function(request, status, error){
//     		                   alert("code: "+request.status+"\n"+"message: "+request.responseText+"\n"+"error: "+error);
//     		                }
//     				});
//                 }
//             });
//             // window.location.href='/ex/kakao_login.html' //리다이렉트 되는 코드
//         },
//         fail: function(error) {
//             alert(error);
//         }
//     });
// }

// function createHiddenLoginForm(kakaoId){

// 	var frm = document.createElement('form');
// 	frm.setAttribute('method', 'post');
// 	frm.setAttribute('action', '/api/kakaobtn.go'); //주소 확인해야함!!
// 	var hiddenInput = document.createElement('input');
// 	hiddenInput.setAttribute('type','hidden');
// 	hiddenInput.setAttribute('name','user_id');
// 	hiddenInput.setAttribute('value',kakaoId);
// 	frm.appendChild(hiddenInput);
// 	document.body.appendChild(frm);
// 	frm.submit();
// }

/////////////////////////////////////////////////////////////////////////////////////////////////////

function loginWithKakao() {
    Kakao.Auth.login({
        success: function (response) {
            Kakao.API.request({
                url: '/v2/user/me',
                success: function (response) {
                    kakaoLoginPro(response)
                },
                fail: function (error) {
                    console.log(error)
                },
            })
        },
        fail: function (error) {
            console.log(error)
        },
    })
}

function kakaoLoginPro(response) {
    var data = { id: response.id }
    $.ajax({
        type: 'POST',
        url: '/api/kakaoLoginPro.do',
        data: data,
        dataType: 'json',
        success: function (data) {
            alert(data);
            if (data.JavaData == "YES") {
                alert("로그인되었습니다.");

                location.href = '/api/kakaoSignUp.do'

            } else if (data.JavaData == "register") {
                //$("#kakaoEmail").val(response.kakao_account.email);
                $("#kakaoId").val(response.id);
                $("#kakaoForm").submit();
            } else {
                alert("로그인에 실패했습니다");
            }

        },
        error: function (xhr, status, error) {
            alert("로그인에 실패했습니다." + error);
        }
    });
}