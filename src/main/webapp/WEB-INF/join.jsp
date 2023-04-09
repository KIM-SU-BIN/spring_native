<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<!doctype html>
<html>
<head>
    <title>회원가입</title>
    <meta charset="UTF-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <script src="https://code.jquery.com/jquery-3.6.4.min.js" integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8=" crossorigin="anonymous"></script>

    <link href="hglobal230302.css" rel="stylesheet">
    <script src="hglobal230302.js"></script>
    <link href="join.css" rel="stylesheet">
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>   //카카오지도 API
</head>

<body>
    <div class="wrap">
        <h1>ZOE__JUNE__SHIFT</h1>
        <!-- ---------- 공통 헤더 ---------- -->

        <table border="1">
            <tr>
                <th>구분</th>
                <td>
                    <input type="radio" id="person" name="user_type" value="person"
                        checked>
                    <label for="person">개인</label>
                    <input type="radio" id="conpany" name="user_type" value="company">
                    <label for="conpany">기업</label>
                </td>
            </tr>
            <tr>
                <th>아이디</th>
                <td>
                    <input type="text" id="id" class="username_input" name="user_id" check_result="fail" required>
                    <span class="email_url">@sensemeka.com</span>
                    <button type="button" id="check_id" class="id_overlap_button" onclick="idchk()">중복검사</button>
                    
                    <!-- <span class="id_ok">사용 가능한 아이디입니다.</span>
                    <span class="id_already">누군가 이 아이디를 사용하고 있어요.</span>
                    -->

                </td>
            </tr>
            <tr>
                <th>비밀번호</th>
                <td><input type="password" name="user_pw" placeholder="PASSWORD" id="user_pw" size="15" required></td>
            </tr>
            <tr>
                <th>이름</th>
                <td><input type="text" name="user_name" placeholder="NAME" id="user_name" size="15" required></td>
            </tr>
            <tr>
                <th>전화번호</th>
                <td><input type="text" name="user_phone" placeholder="PHONE NUMBER" id="user_phone" size="15"></td>
            </tr>
            <tr>
                <th>주소</th>
                <td>
                    <input type="text" name="address1" id="address1" size="45" readonly /> 
                    <button type="button" id="search_address" onclick="search_address()">찾기</button>
                </td>
            </tr>
            <tr>
                <th>나머지주소</th>
                <td><input type="text" name="address2" id="address2" size="45"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input id="btn_join2" type="submit" value="회원가입">
                    <input id="btn_cancle" type="reset" value="취소">
                </td>
            </tr>
        </table>
        <!-- ---------- content table ---------- -->


    </div> <!-- ---------- wrap ---------- -->
</body>

<script src="join.js"></script>

<script>
    // 기업/개인 버튼 둘 중 하나만 check
    /*function chkOne(element) {
        const checkboxes
            = document.getElementsByName("chk_only_one");

        checkboxes.forEach((cb) => {
            cb.checked = false;
        })
        element.checked = true;
    }*/
</script>

</html>