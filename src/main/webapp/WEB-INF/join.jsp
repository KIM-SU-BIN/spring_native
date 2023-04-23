<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
    <!doctype html>
    <html>

    <head>
        <title>회원가입</title>
        <meta charset="UTF-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <script src="https://code.jquery.com/jquery-3.6.4.min.js"
            integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8=" crossorigin="anonymous"></script>

        <link href="hglobal230302.css" rel="stylesheet">
        <script src="hglobal230302.js"></script>
        <link href="join.css" rel="stylesheet">
        <link href="common.css" rel="stylesheet">
        <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script> <!-- 카카오지도 API -->
        <script src="https://developers.kakao.com/sdk/js/kakao.js"></script> <!-- 카카오 회원가입 -->
    </head>

    <body>
        <div class="wrap">
            <h1>ZOE__JUNE__SHIFT</h1>
            <!-- ---------- 공통 헤더 ---------- -->
            <h2>JOIN US</h2>

            <form name="form" method="post" onsubmit="return checkAll();">
                <table>
                    <tr>
                        <th scope="row">구분</th>
                        <td>
                            <label for="person"><input type="radio" id="person" name="user_type" value="person" checked>
                                개인</label>
                            <label for="conpany"><input type="radio" id="conpany" name="user_type" value="company">
                                기업</label>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">아이디</th>
                        <td>
                            <input type="text" id="user_id" class="username_input" name="user_id" placeholder="ID"
                                check_result="fail" size="25" required>
                            <span class="email_url">@sensemeka.com</span>
                            <button type="button" id="check_id" class="id_button">중복검사</button>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">비밀번호</th>
                        <td><input type="password" name="user_pw" placeholder="PASSWORD" id="user_pw" size="25"
                                required></td>
                    </tr>
                    <tr>
                        <th scope="row">이름</th>
                        <td><input type="text" name="user_name" placeholder="NAME" id="user_name" size="25" required>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">전화번호</th>
                        <td><input type="text" name="user_phone" placeholder="PHONE NUMBER" id="user_phone" size="25"
                                required>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">주소</th>
                        <td>
                            <input type="text" name="address1" id="address1" size="45" readonly />
                            <button type="button" id="search_address" onclick="search_address()">찾기</button>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">나머지주소</th>
                        <td><input type="text" name="address2" id="address2" size="45" required></td>
                    </tr>
                </table>
                <div class="join_agreement">
                    <label for="check_all"><input id="check_all" class="chk_join" type="checkbox">전체 동의</label><br>
                    <label for="check_all"><input id="check_1" class="chk_join" type="checkbox"><a
                            href="javascrip:agreePopup()" onclick="agreePopup()">14세 이상</a>입니다.</label><br>
                    <label for="check_all"><input id="check_2" class="chk_join" type="checkbox"><a
                            href="https://hoy.kr/page/terms#" value="agreement_link">개인정보 수집 및 이용</a> 동의</label>
                </div>
                <!-- ---------- 팝업 ---------- -->
                <div class="popup_layer" id="popup_layer" style="display: none;">
                    <div class="popup_box">
                        <div style="height: 10px; width: 375px; float: top;">
                            <a href="javascript:closePop();"></a>
                        </div>
                        <!-- ----------팝업 컨텐츠 영역 ---------- -->
                        <div class="popup_cont">
                            <h3>[ 14세 미만 아동의 개인정보 보호 ]</h3>
                            <p style="text-align:left;">
                                𖤐사이트 운영자는 만 14세 미만의 아동으로부터 개인정보 수집·이용·제공 등의 동의를 받으려면 법정대리인의 동의를 받아야 하고, 다음의 어느 하나에 해당하는
                                방법으로 법정대리인이 동의하였는지를 확인해야 합니다(「개인정보 보호법」 제39조의3제4항 및 「개인정보 보호법 시행령」 제48조의3제1항).<br><br>

                                𖤐동의 내용을 게재한 인터넷 사이트에 법정대리인이 동의 여부를 표시하도록 하고 정보통신서비스 제공자등이 그 동의 표시를 확인했음을 법정대리인의 휴대전화
                                문자메시지로 알리는 방법<br><br>

                                𖤐동의 내용을 게재한 인터넷 사이트에 법정대리인이 동의 여부를 표시하도록 하고 법정대리인의 신용카드·직불카드 등의 카드정보를 제공받는 방법<br><br>

                                𖤐동의 내용을 게재한 인터넷 사이트에 법정대리인이 동의 여부를 표시하도록 하고 법정대리인의 휴대전화 본인인증 등을 통해 본인 여부를 확인하는
                                방법<br><br>

                                𖤐동의 내용이 적힌 서면을 법정대리인에게 직접 발급하거나, 우편 또는 팩스를 통하여 전달하고 법정대리인이 동의 내용에 대하여 서명날인 후 제출하도록 하는
                                방법<br><br>

                                𖤐동의 내용이 적힌 전자우편을 발송하여 법정대리인으로부터 동의의 의사표시가 적힌 전자우편을 전송받는 방법
                                전화를 통하여 동의 내용을 법정대리인에게 알리고 동의를 얻거나 인터넷주소 등 동의 내용을 확인할 수 있는 방법을 안내하고 재차 전화 통화를 통하여 동의를 얻는
                                방법<br><br>

                                𖤐그 밖에 위의 규정에 따른 방법에 준하는 방법으로 법정대리인에게 동의 내용을 알리고 동의의 의사표시를 확인하는 방법<br><br>

                                𖤐사이트 운영자는 개인정보 수집 매체의 특성상 동의 내용을 전부 표시하기 어려운 경우 법정대리인에게 동의 내용을 확인할 수 있는 방법(인터넷주소·사업장
                                전화번호 등)을 안내할 수 있습니다(「개인정보 보호법 시행령」 제48조의3제2항).<br><br>

                                𖤐사이트 운영자는 만 14세 미만의 아동에게 개인정보 처리와 관련한 사항의 고지 등을 하는 때에는 이해하기 쉬운 양식과 명확하고 알기 쉬운 언어를 사용해야
                                합니다(「개인정보 보호법」 제39조의3제5항).<br><br>

                                𖤐만 14세 미만의 아동은 개인정보 처리에 따른 위험성과 그로인해 초래될 수 있는 결과 및 이용자의 권리 등을 명확하게 인지하지 못할 수 있으므로 개인정보
                                보호위원회에서 이들을 보호하기 위한 방안을 마련하도록 하고 있습니다(「개인정보 보호법」 제39조의3제6항).
                            </p>
                        </div>
                        <!-- 팝업 버튼 영역 -->
                        <div class="popup_btn" style="float: bottom; margin-top: 200px;">
                            <a href="javascript:closePop();">닫기</a>
                        </div>
                    </div>
                </div>
                <div class="btn_join_all">
                    <input id="btn_join2" type="submit" value="JOIN">
                    <input id="btn_cancle" type="reset" value="CANCLE">
                </div>
                <a id="kakao-login-btn" href="javascript:loginWithKakao()" onclick="kakaobtn()">
                    <img src="https://k.kakaocdn.net/14/dn/btroDszwNrM/I6efHub1SN5KCJqLm1Ovx1/o.jpg" width="222"
                        alt="카카오 로그인 버튼" />
                </a>
                <p id="token-result"></p>
            </form>
            <!-- ---------- content table ---------- -->

            <div class="footer">
                <div class="footer-text">
                    <p>SENSEMEKA</p>
                    <p>대표 : 박용</p>
                    <p>사업자 번호 : 123-456-789</p>
                    <p>경기도 고양시 덕양구 무원로6번길 36 남정시티프라자 6층 804호</p>
                    <br>
                    <p>고객센터 | 평일 9 : 30 ~ 18 : 30, 점심시간 : 12 : 00 ~ 13 : 00 (토, 일요일, 공휴일 휴무)</p>
                    <p>Tel. 02 - 1111 - 1111</p>
                    <p>Fax. 02 - 1111 - 1111</p>
                    <p>Email. subintoto@sensemeka.com</p>
                </div>
                <br>
                <div class="footer-btn">
                    <button id="footerbtn" type="button" name="" value="">자주묻는 질문</button>
                    <button id="footerbtn" type="button" name="" value="">1:1 문의</button>
                </div>
                <br>
                <hr class="common-hr1">
                <p id="footer-Copyright">SENSEMEKA, Inc. All rights reserved.</p>
            </div> <!-- ---------- footer ---------- -->
        </div> <!-- ---------- wrap ---------- -->
    </body>
    <script src="join.js"></script>

    </html>