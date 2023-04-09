package com.sensemeka .tweaksense.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import com.sensemeka .tweaksense.*;

public class Test1Model {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private DbManager db;

	public Test1Model(DbManager db) {
		this.db = db;
	}

	public int getData(List<Map<String, String>> dst, String strId) {
		int nError = ErrorCode.NO_ERROR;

		String strSql  = "SELECT * from test1";
		if (strId != null && strId.isEmpty() == false)
			strSql += " WHERE test1_id=" + strId;

		logger.info(strSql);

		if (db.open() == false)
			return ErrorCode.FAILED_CONNECT_DB;

		if (db.select(dst, strSql) == false)
			nError = ErrorCode.QUERY_ERROR;

		logger.info(dst.toString());

		int nCount = db.selectSingleInt("SELECT count(*) from test1");
		if (nCount < 0)
			nError = ErrorCode.QUERY_ERROR;

		logger.info("[TRACE] nCount = " + nCount);

		String str = db.selectSingleStr("SELECT test_data from test1");
		if (str == null)
			nError = ErrorCode.QUERY_ERROR;
		else
			logger.info("[TRACE] str = " + str);

		db.close();

		return nError;
	}

	public int addData(String strTestData) {
		int nError = ErrorCode.NO_ERROR;

		String strSql  = "INSERT INTO test1 (test_data, reg_time) VALUES ('" + strTestData + "', Now())";
		logger.info(strSql);

		if (db.open() == false)
			return ErrorCode.FAILED_CONNECT_DB;

		if (db.execute(strSql) == false)
			nError = ErrorCode.QUERY_ERROR;

		db.close();

		return nError;
	}

	public int modifyData(String strId, String strTestData) {
		int nError = ErrorCode.NO_ERROR;

		String strSql  = "UPDATE test1 SET test_data='" + strTestData + "' WHERE test1_id=" + strId;
		logger.info(strSql);

		if (db.open() == false)
			return ErrorCode.FAILED_CONNECT_DB;

		if (db.execute(strSql) == false)
			nError = ErrorCode.QUERY_ERROR;

		db.close();

		return nError;
	}

	public int deleteData(String strId) {
		int nError = ErrorCode.NO_ERROR;

		String strSql  = "DELETE FROM test1 WHERE test1_id=" + strId;
		logger.info(strSql);

		if (db.open() == false)
			return ErrorCode.FAILED_CONNECT_DB;

		if (db.execute(strSql) == false)
			nError = ErrorCode.QUERY_ERROR;

		db.close();

		return nError;
	}
}
