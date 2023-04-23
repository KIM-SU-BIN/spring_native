package com.sensemeka.tweaksense.model;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sensemeka.tweaksense.DbManager;
import com.sensemeka.tweaksense.ErrorCode;

public class AccountModel {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private DbManager db;

	public AccountModel(DbManager db) {
		this.db = db;
	}

	public int findAccount(Map<String, String> dst, String strId, String strPw) {
		int nError = ErrorCode.NO_ERROR;

		String strSql = "SELECT * from account WHERE user_id = '" + strId + "'";

		logger.info(strSql);

		if (db.open() == false)
			return ErrorCode.FAILED_CONNECT_DB;

		if (db.selectSingle(dst, strSql) == false)
			nError = ErrorCode.QUERY_ERROR;

		db.close();

		logger.info(dst.toString());

		return nError;
	}


	// AccountController에 join처리
	public int creatAccount(Map<String, String> dst, String strUserId, String strUserPw, String strUserName,
			String strUserPhone, String strAddress1, String strAddress2, String strUserType) {
		int nError = ErrorCode.NO_ERROR;

		String strSql = "INSERT INTO account values(NEXTVAL(SEQ_USER_NO), '" + strUserId + "', '" + strUserName + "', '"
		+ strUserPw + "', '" +  strUserPhone + "', '" + strAddress1 + "', '" + strAddress2 + "', '" + strUserType + "')";

		logger.info(strSql);

		if (db.open() == false)
			return ErrorCode.FAILED_CONNECT_DB;

		if (db.selectSingle(dst, strSql) == false)
			nError = ErrorCode.QUERY_ERROR;

		db.close();

		logger.info(dst.toString());

		return nError;
	}


	//아이디 중복확인
	public int checkDuplicateId(Map<String, String> dst, String strUserId) {

		int nError = ErrorCode.NO_ERROR;

		String strSql = "SELECT user_id from account WHERE user_id = '" + strUserId + "'";

		logger.info(strSql);
		
		if (db.open() == false)
			return ErrorCode.FAILED_CONNECT_DB;

		if (db.selectSingle(dst, strSql) == false)
			nError = ErrorCode.QUERY_ERROR;

		db.close();

		logger.info(dst.toString());
		
		return nError;
	}


}

