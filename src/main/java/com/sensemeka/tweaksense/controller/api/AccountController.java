package com.sensemeka.tweaksense.controller.api;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sensemeka.tweaksense.DbManager;
import com.sensemeka.tweaksense.ErrorCode;
import com.sensemeka.tweaksense.model.AccountModel;

@RestController
@RequestMapping("/api")
public class AccountController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	DataSource dataSource;

	// 로그인
	@RequestMapping(value = "/log_in.do", method = RequestMethod.POST)
	public Map<String, Object> login(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			@RequestParam Map<String, String> body) {
		logger.info("req: /api/log_in.do");

		int nErrorCode = ErrorCode.NO_ERROR;
		Map<String, Object> map = new HashMap<String, Object>();

		String strUserId = body.get("user_id");
		if (strUserId == null || strUserId.isEmpty()) {
			map.put("errCode", ErrorCode.INVALID_PARAMETER);
			return map;
		}

		String strUserPw = body.get("user_pw");
		if (strUserPw == null || strUserPw.isEmpty()) {
			map.put("errCode", ErrorCode.INVALID_PARAMETER);
			return map;
		}

		Map<String, String> data = new HashMap<String, String>();
		AccountModel test1Model = new AccountModel(new DbManager(dataSource));
		nErrorCode = test1Model.findAccount(data, strUserId, strUserPw);

		if (data.size() <= 0 || data.get("user_pw").compareTo(strUserPw) != 0) {
			map.put("errCode", nErrorCode);
			return map;
		}

		// Login success
		session.setAttribute("account_id", strUserId);
		session.setMaxInactiveInterval(28800);

		map.put("errCode", nErrorCode);

		return map;
	}

	@RequestMapping(value = "/log_out.do", method = RequestMethod.GET)
	public Map<String, Object> logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		logger.info("req: /api/log_out.do");

		Map<String, Object> map = new HashMap<String, Object>();
		if (session.getAttribute("account_id") != null) {
			session.invalidate();
			map.put("errCode", ErrorCode.NO_ERROR);
		} else {
			map.put("errCode", ErrorCode.INVALID_PARAMETER);
		}

		return map;
	}

	// 회원가입 실행
	@RequestMapping(value = "/save.do", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> save(HttpServletRequest request, HttpServletResponse response,
			@RequestParam Map<String, String> body) {
		logger.info("req: /api/save.do");

		int nErrorCode = ErrorCode.NO_ERROR;
		Map<String, Object> map = new HashMap<String, Object>();

		String strUserId = body.get("user_id");
		if (strUserId == null || strUserId.isEmpty()) {
			map.put("errCode", ErrorCode.INVALID_PARAMETER);
			return map;
		}
		String strUserPw = body.get("user_pw");
		if (strUserPw == null || strUserPw.isEmpty()) {
			map.put("errCode", ErrorCode.INVALID_PARAMETER);
			return map;
		}
		String strUserName = body.get("user_name");
		if (strUserName == null || strUserName.isEmpty()) {
			map.put("errCode", ErrorCode.INVALID_PARAMETER);
			return map;
		}
		String strUserPhone = body.get("user_phone");
		if (strUserPhone == null || strUserPhone.isEmpty()) {
			map.put("errCode", ErrorCode.INVALID_PARAMETER);
			return map;
		}
		String strAddress1 = body.get("address1");
		if (strAddress1 == null || strAddress1.isEmpty()) {
			map.put("errCode", ErrorCode.INVALID_PARAMETER);
			return map;
		}
		String strAddress2 = body.get("address2");
		if (strAddress2 == null || strAddress2.isEmpty()) {
			map.put("errCode", ErrorCode.INVALID_PARAMETER);
			return map;
		}
		String strUserType = body.get("user_type");
		if (strUserType == null || strUserType.isEmpty()) {
			map.put("errCode", ErrorCode.INVALID_PARAMETER);
			return map;
		}

		Map<String, String> data = new HashMap<String, String>();
		AccountModel joinModel = new AccountModel(new DbManager(dataSource));
		nErrorCode = joinModel.creatAccount(data, strUserId, strUserPw, strUserName, strUserPhone, strAddress1,
				strAddress2, strUserType);

		map.put("errCode", nErrorCode);

		return map;
	}

	// 아이디 중복확인
	@RequestMapping(value = "/checkDuplicateId.do", method = RequestMethod.POST)
	public Map<String, Object> checkDuplicateId(HttpServletRequest request, HttpServletResponse response,
			@RequestParam Map<String, String> body) {
		logger.info("req:/api/checkDuplicateId.do");

		int nErrorCode = ErrorCode.NO_ERROR;
		Map<String, Object> map = new HashMap<String, Object>();

		String strUserId = body.get("user_id");
		if (strUserId == null || strUserId.isEmpty()) {
			map.put("errCode", ErrorCode.INVALID_PARAMETER);
			return map;
		}

		Map<String, String> data = new HashMap<String, String>();
		AccountModel checkDuplicateIdModel = new AccountModel(new DbManager(dataSource));
		nErrorCode = checkDuplicateIdModel.checkDuplicateId(data, strUserId);

		if (data.size() <= 0) {
			map.put("errCode", nErrorCode);
			return map;
		}
		return map;
	}

	// 카카오톡 로그인/회원가입
	// private kakao_api kakao_api = new kakao_api();

	@RequestMapping(value = "/checkId.do", method = RequestMethod.POST)
	public String kakao(@RequestParam Map<String, String> body) {
		System.out.println("AccountController > access_token");
		logger.info("req:/api/checkId.do");

		return "/";
	}

	@RequestMapping(value = "/kakaoSignUp.do", method = RequestMethod.POST)
	public String kakaoLogin(@RequestParam Map<String, String> body) {
		System.out.println("AccountController > kakaoLogin_access");
		logger.info("req:/api/kakaoSignUp.do");

		return "/";
	}
	// reset password
	// search account
	// ...
}
