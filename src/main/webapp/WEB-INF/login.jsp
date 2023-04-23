<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
	<!doctype html>
	<html>

	<head>
		<title>로그인</title>
		<meta charset="utf-8">
		<meta http-equiv="x-ua-compatible" content="ie=edge">
		<meta name="description" content="">
		<meta name="viewport" content="width=device-width, initial-scale=1">

		<script src="https://code.jquery.com/jquery-3.6.4.min.js"
			integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8=" crossorigin="anonymous"></script>

		<link href="hglobal230302.css" rel="stylesheet">
		<script src="hglobal230302.js"></script>
		<link href="login.css" rel="stylesheet">
		<link href="common.css" rel="stylesheet">
		<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>    <!-- 카카오 로그인 -->
	</head>

	<body>
		<div class="wrap">
			<h1>ZOE__JUNE__SHIFT</h1>
			<!-- ---------- 공통 헤더 ---------- -->

			<div class="_sm2">
				<h2>Login</h2>
				<hr>
				<div class="check_user_type">
					<label for="person"><input type="radio" id="person" name="user_type" value="person"
							checked>개인</label>
					<label for="conpany"><input type="radio" id="conpany" name="user_type" value="company">기업</label>
				</div>
				<hr>
				<div class="login_input">
					<input type="text" id="user_id" placeholder="input id" /><br>
					<input type="password" id="user_pw" placeholder="input password" /><br>
				</div>
				<div class="btn_main">
					<button id="btn_login">Log in</button>
					<button id="btn_join">Join</button>
				</div>
				<div>
					<a id="kakao-login-btn" href="javascript:loginWithKakao()">
						<img src="https://k.kakaocdn.net/14/dn/btroDszwNrM/I6efHub1SN5KCJqLm1Ovx1/o.jpg" width="222"
							alt="카카오 로그인 버튼" />
					</a>
					<p id="token-result"></p>
				</div>
			</div> <!-- ---------- content ---------- -->

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
	<script src="login.js"></script>

	</html>